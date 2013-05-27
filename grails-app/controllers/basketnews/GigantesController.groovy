package basketnews

import es.kaylan.basket.GigantesHomePage;
import es.kaylan.basket.TuBasketHomePage
import geb.Browser

class GigantesController {

	def index() {
		Browser.drive {
			to GigantesHomePage
			news.each{
				if(!Noticia.findByUrl(it.@href)) {
					Noticia noticia = new Noticia(url: it.@href, , paginaWeb:'Gigantes',fechaDeteccion: new Date()).save(flush: true)
					log.info 'Noticia de gigantes agregada'
				}
			}
		}
	}
}
