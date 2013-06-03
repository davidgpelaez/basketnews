package basketnews

import es.kaylan.basket.SolobasketHomePage
import geb.Browser

class SolobasketController {

	def index() {
		Browser.drive {
			to SolobasketHomePage
			news.each{
				if(!Noticia.findByUrl(it.@href)  && !IgnoreURL.findByUrl(it.@hr)) {
					Noticia noticia = new Noticia(url: it.@href, paginaWeb:'Solobasket', fechaDeteccion: new Date()).save(flush: true)
					log.info 'Noticia de solobasket agregada'
				}
			}
		}
	}
}
