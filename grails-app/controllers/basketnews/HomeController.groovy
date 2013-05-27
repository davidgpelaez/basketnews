package basketnews

class HomeController {

    def index() { 
		
		[noticias: Noticia.list(max: 300)]
		
	}
}
