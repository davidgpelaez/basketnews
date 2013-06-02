package basketnews

import es.kaylan.basket.ACBHomePage;
import es.kaylan.basket.TerraACBHomePage;
import es.kaylan.basket.TerraNBAHomePage;
import es.kaylan.basket.YahooACBHomePage;
import es.kaylan.basket.YahooNBAHomePage;
import geb.Browser;

class YahooController {

	def index() {
		Browser.drive {
			to YahooNBAHomePage
			news.each{
				if(!Noticia.findByUrl(it.@href)) {
					
					Noticia noticia = new Noticia(url: it.@href, paginaWeb:'Eurosport', fechaDeteccion: new Date()).save(flush: true)
					log.info 'Noticia de Eurosport NBA agregada'
				}
			}
			to YahooACBHomePage
			news.each{
				if(!Noticia.findByUrl(it.@href)) {
					
					Noticia noticia = new Noticia(url: it.@href, paginaWeb:'Eurosport', fechaDeteccion: new Date()).save(flush: true)
					log.info 'Noticia de Eurosport ACB agregada'
				}
			}
		
		}
	}
}
