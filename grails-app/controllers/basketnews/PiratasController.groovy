package basketnews

import es.kaylan.basket.ACBHomePage;
import es.kaylan.basket.PiratasHomePage;
import geb.Browser;

class PiratasController {

	def index() {
		Browser.drive {
			to PiratasHomePage
			news.each{
				if(!Noticia.findByUrl(it.@href)) {
					
					Noticia noticia = new Noticia(url: it.@href, paginaWeb:'Piratas', fechaDeteccion: new Date()).save(flush: true)
					log.info 'Noticia de Piratas agregada'
				}
			}
		}
	}
}
