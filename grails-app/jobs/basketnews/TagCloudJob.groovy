package basketnews



class TagCloudJob {
   def concurrent = false
	def mongo

	static triggers = { simple repeatInterval: 14400000 //each 4 hous
	}

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
	
		def lastTags = TagCloud.findAllWhere(isLast: true)
		lastTags.each {
			it.isLast=false
			it.save(flush:true)
		}
		Date fechaTagCloud = new Date()
		tagCloud.each { key, value ->
			new TagCloud(fecha:fechaTagCloud, tag: key, repeticiones:Integer.valueOf(value), isLast:true).save(flush:true)
			
		}
		
    }
}
