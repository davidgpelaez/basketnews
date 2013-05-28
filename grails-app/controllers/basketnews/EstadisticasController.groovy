package basketnews

class EstadisticasController {

	def mongo
	
    def index() {
		
		def db = mongo.getDB('basketnews')
		def noticiasGroup = db.noticia.aggregate([$group:[_id:'$paginaWeb', noticias:[$sum:1]]])
		[noticiasGroup: noticiasGroup]
	}
}
