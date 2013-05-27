package basketnews

import java.awt.GraphicsConfiguration.DefaultBufferCapabilities;




class AgruparNoticiasJob {
	def concurrent = false
	def mongo

	static triggers = { simple repeatInterval: 20000 // execute job once in 5 seconds
	}

	def keywords = [
		'ACB',
		'NBA',
		'draft',
		'endesa',
		'eurocup',
		'euroleague',
		'euroliga'
	]

	def execute() {
		// Buscar noticias de los últimos dos días, sacar palabras clave, buscar candidatos y agrupar
		def db = mongo.getDB('basketnews')
		def not = db.noticia.find([:],[tags:1,_id:0])

		def tagCloud = [:]
		not.each{ 
			it['tags'].each{ tagTerms ->
				if(tagCloud[tagTerms])
				{
					tagCloud[tagTerms]=tagCloud[tagTerms]+1
				}
				else{
					tagCloud[tagTerms]=1
				}
			}
		}
		//Remover preposiciones
		println tagCloud
		def noticias = Noticia.findAllWhere(tags:null)
		noticias.each { noticia ->
			noticia.tags = calculateTags(noticia)
		}


	}

	def calculateTags(Noticia noticia){
		if(noticia.titulo)
		{
			noticia.tags = noticia.titulo.split(' ').findAll {
				Character.isUpperCase(it.charAt(0)) || keywords.contains(it)
			}
			noticia.save(flush: true)
			println noticia.tags
		}
	}
}
