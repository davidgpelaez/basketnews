package basketnews

import es.kaylan.basket.ManiacsHomePage
import es.kaylan.basket.ManiacsRumoresPage;
import geb.Browser

class NbaManiacsController {

	def index() {
		Browser.drive {
			to ManiacsHomePage
			news.each{
				if(!Noticia.findByUrl(it.@href) && !IgnoreURL.findByUrl(it.@href)) {

					Noticia noticia = new Noticia(url: it.@href, paginaWeb:'NbaManiacs', fechaDeteccion: new Date()).save(flush: true)
					log.info 'Noticia de NBA Maniacs agregada'
				}
			}
			
			to ManiacsRumoresPage
			news.each{
				if(!Noticia.findByUrl(it.@href) && !IgnoreURL.findByUrl(it.@href)) {

					Noticia noticia = new Noticia(url: it.@href, paginaWeb:'NbaManiacs', fechaDeteccion: new Date()).save(flush: true)
					log.info 'Noticia de NBA Maniacs agregada'
				}
			}
		}
	}
}
