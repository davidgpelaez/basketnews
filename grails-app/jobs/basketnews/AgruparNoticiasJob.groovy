package basketnews

import java.awt.GraphicsConfiguration.DefaultBufferCapabilities;

class AgruparNoticiasJob {
	def concurrent = false
	def mongo

	static triggers = { simple repeatInterval: 60000 
	}

	def keywords = [
		'ACB',
		'NBA',
		'draft',
		'endesa',
		'eurocup',
		'euroleague',
		'euroliga',
		'playoff',
		'playoffs',
		'final',
		'finales',
		'semifinal',
		'semifinales',
		'mock',
		'ascenso',
		'descenso',
		'fichaje',
		'fichajes',
		'traspaso',
		'supermanager'
		
	]
	
	def IGNORE_WORDS = ['Ya', 'Mi', 'Cuando', 'Por','Para','A','No','Un', 'Uno', 'Una', 'Unos', 'Unas', 'Lo', 'El', 'La', 'Los', 'Las', 'Y', 'Es', 'Son', 'Sin', 'Real', 'Hay', 'LA','PRENSA', 'DICE']

	def execute() {
		
		def noticias = Noticia.findAllWhere(tags:null)
		noticias.each { noticia ->
			noticia.tags = calculateTags(noticia)
		}


	}

	def calculateTags(Noticia noticia){
		if(noticia.titulo)
		{
			def tituloSplitted = noticia.titulo.split(' ')
			tituloSplitted = tituloSplitted.collect{
				it.replaceAll("[\\.|'|,|:|\"|\\?]", "")
			}
			
			noticia.tags = tituloSplitted.findAll {
				
				(it && Character.isUpperCase(it.charAt(0)) && isImportantWord(it)) || keywords.contains(it)
			}
			noticia.save(flush: true)
			println noticia.tags
		}
	}
	
	def isImportantWord(def word){
		!IGNORE_WORDS.contains(word)
	}
	

}
