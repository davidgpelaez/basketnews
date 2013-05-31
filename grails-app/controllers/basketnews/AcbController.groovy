package basketnews

import es.kaylan.basket.ACBHomePage;
import geb.Browser;

class AcbController {

	def index() {
		Browser.drive {
			to ACBHomePage
			news.each{
				if(!Noticia.findByUrl(it.@href)) {
					
					Noticia noticia = new Noticia(url: it.@href, paginaWeb:'ACB', fechaDeteccion: new Date()).save(flush: true)
					log.info 'Noticia de ACB agregada'
				}
			}
		}
	}
}
