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
				def cleanUrl = it.@href
				if(cleanUrl.indexOf(';_ylt')!=-1){
					cleanUrl = cleanUrl.substring(0, cleanUrl.indexOf(';_ylt'))
				}
				if(!Noticia.findByUrl(cleanUrl) && !IgnoreURL.findByUrl(cleanUrl)) {
					
					Noticia noticia = new Noticia(url: cleanUrl, paginaWeb:'Eurosport', fechaDeteccion: new Date()).save(flush: true)
					log.info 'Noticia de Eurosport NBA agregada'
				}
			}
			to YahooACBHomePage
			news.each{
				def cleanUrl = it.@href
				if(cleanUrl.indexOf(';_ylt')!=-1){
					cleanUrl = cleanUrl.substring(0, cleanUrl.indexOf(';_ylt'))
				}
				if(!Noticia.findByUrl(cleanUrl) && !IgnoreURL.findByUrl(cleanUrl)) {
					
					Noticia noticia = new Noticia(url: cleanUrl, paginaWeb:'Eurosport', fechaDeteccion: new Date()).save(flush: true)
					log.info 'Noticia de Eurosport ACB agregada'
				}
			}
		
		}
	}
}
