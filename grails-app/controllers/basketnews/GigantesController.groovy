package basketnews

import es.kaylan.basket.GigantesHomePage;
import es.kaylan.basket.TuBasketHomePage
import geb.Browser

class GigantesController {

	def index() {
		Browser.drive {
			go "http://www.gigantes.com"
			$('h1.titulo').each {
				log.info "${it.html()}"
			}
			news.each{
				if(!Noticia.findByUrl(it.@href) && !IgnoreURL.findByUrl(it.@href)) {
					Noticia noticia = new Noticia(url: it.@href, , paginaWeb:'Gigantes',fechaDeteccion: new Date()).save(flush: true)
					log.info 'Noticia de gigantes agregada'
				}
			}
		}
	}
}
