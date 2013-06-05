package basketnews



class TagCloudJob {
   def concurrent = false
	def mongo

	
	static triggers = {
	  simple  startDelay: 360000, repeatInterval: 14400000
	}


    def execute() {
      // Buscar noticias de los últimos dos días, sacar palabras clave, buscar candidatos y agrupar
		def db = mongo.getDB('basketnews')
	    log.info 'Lets go to calculate tagCloud!'
		def not = db.noticia.find([fechaReal:[$gte:new Date()-3]],[tags:1,_id:0])

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
			//Guardamos tags que aparezcan más de una vez, por no recargar y porque los que aparecen una vez la mayoría son basuuura
			if(1<Integer.valueOf(value)){
				new TagCloud(fecha:fechaTagCloud, tag: key, repeticiones:Integer.valueOf(value), isLast:true).save(flush:true)
			}
			
		}
		log.info 'Calculate tagCloud finished'
    }
}
