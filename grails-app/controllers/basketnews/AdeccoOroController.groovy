package basketnews

import es.kaylan.basket.ACBHomePage;
import es.kaylan.basket.AdeccoOroHomePage;
import geb.Browser;

class AdeccoOroController {

	def index() {
		Browser.drive {
			to AdeccoOroHomePage
			news.each{
				if(!Noticia.findByUrl(it.@href) && !IgnoreURL.findByUrl(it.@href)) {

					Noticia noticia = new Noticia(url: it.@href, paginaWeb:'AdeccoOro', fechaDeteccion: new Date()).save(flush: true)
					log.info 'Noticia de Adecco Oro agregada'
				}
			}
		}
	}
}
