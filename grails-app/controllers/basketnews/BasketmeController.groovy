package basketnews

import es.kaylan.basket.ACBHomePage;
import es.kaylan.basket.BasketmeACBHomePage;
import es.kaylan.basket.BasketmeEuropaHomePage;
import es.kaylan.basket.BasketmeNBAHomePage;
import es.kaylan.basket.TerraACBHomePage;
import es.kaylan.basket.TerraNBAHomePage;
import geb.Browser;

class BasketmeController {

	def index() {
		Browser.drive {
			to BasketmeACBHomePage
			news.each{
				if(!Noticia.findByUrl(it.@href)) {
					
					Noticia noticia = new Noticia(url: it.@href,titulo:it.text(), paginaWeb:'Basketme', fechaDeteccion: new Date()).save(flush: true)
					log.info 'Noticia de Basketme ACB agregada'
				}
			}
			to BasketmeEuropaHomePage
			news.each{
				if(!Noticia.findByUrl(it.@href)) {
					
					Noticia noticia = new Noticia(url: it.@href,titulo:it.text(), paginaWeb:'Basketme', fechaDeteccion: new Date()).save(flush: true)
					log.info 'Noticia de Basketme Europa agregada'
				}
			}
			
			to BasketmeNBAHomePage
			news.each{
				if(!Noticia.findByUrl(it.@href)) {
					
					Noticia noticia = new Noticia(url: it.@href,titulo:it.text(), paginaWeb:'Basketme', fechaDeteccion: new Date()).save(flush: true)
					log.info 'Noticia de Basketme NBA agregada'
				}
			}
		}
	}
}
