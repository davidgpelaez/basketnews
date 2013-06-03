package basketnews

import es.kaylan.basket.ACBHomePage;
import es.kaylan.basket.TerraACBHomePage;
import es.kaylan.basket.TerraNBAHomePage;
import geb.Browser;

class TerraController {

	def index() {
		Browser.drive {
			to TerraACBHomePage
			news.each{
				if(!Noticia.findByUrl(it.@href)  && !IgnoreURL.findByUrl(it.@href)) {
					
					Noticia noticia = new Noticia(url: it.@href, paginaWeb:'Terra', fechaDeteccion: new Date()).save(flush: true)
					log.info 'Noticia de Terra ACB agregada'
				}
			}
			to TerraNBAHomePage
			news.each{
				if(!Noticia.findByUrl(it.@href)  && !IgnoreURL.findByUrl(it.@href)) {
					
					Noticia noticia = new Noticia(url: it.@href, paginaWeb:'Terra', fechaDeteccion: new Date()).save(flush: true)
					log.info 'Noticia de Terra NBA agregada'
				}
			}
		}
	}
}
