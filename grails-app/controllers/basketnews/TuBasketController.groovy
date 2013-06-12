package basketnews

import es.kaylan.basket.TuBasketHomePage
import geb.Browser

class TuBasketController {

	def index() {
		Browser.drive {
			to TuBasketHomePage
			news.each{
				if(!Noticia.findByUrl(it.@href) && !IgnoreURL.findByUrl(it.@hr)) {
					Noticia noticia = new Noticia(url: it.@href, paginaWeb:'TuBasket', fechaDeteccion: new Date()).save(flush: true)
					log.info 'Noticia de TuBasket agregada'
				}
			}
		}
	}
}
