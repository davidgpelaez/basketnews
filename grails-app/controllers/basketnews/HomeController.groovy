package basketnews

class HomeController {

	def mongo
	
    def index() {
		def noticias
		def db = mongo.getDB('basketnews')
		def tagCloud = db.tagCloud.find([$and: [[repeticiones:[$gte:6]], [isLast:true]]])
		if(params.tag){
			noticias = Noticia.findAllWhere(tags: params.tag)
		}
		else{
			noticias = Noticia.list(max: 100)
		}
		
		[noticias: noticias, tagCloud: tagCloud]
		
	}
}
