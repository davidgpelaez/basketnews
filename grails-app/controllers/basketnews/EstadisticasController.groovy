package basketnews

class EstadisticasController {

	def mongo
	
    def index() {
		
		def db = mongo.getDB('basketnews')
		def noticiasGroup = db.noticia.aggregate([$group:[_id:'$paginaWeb', noticias:[$sum:1]]])
		def noticiasLeidas = db.noticia.aggregate([$group:[_id:'$paginaWeb', leidas:[$sum:'$hits']]])

		[noticiasGroup: noticiasGroup, noticiasLeidas: noticiasLeidas]
	}
}
