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
	
	def count(){
		def url = params.noticia
		def noticia = Noticia.findByUrl(url)
		if(noticia.hits){
			noticia.hits+=1
		}
		else{
			noticia.hits=1
		}
		noticia.save(flush:true)
		
		render "$noticia.hits"
	}
}
