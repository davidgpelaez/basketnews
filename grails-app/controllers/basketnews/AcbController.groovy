package basketnews

import es.kaylan.basket.ACBHomePage;
import geb.Browser;

class AcbController {

	def index() {
		Browser.drive {
			to ACBHomePage
			news.each{
				if(!Noticia.findByUrl(it.@href) && !IgnoreURL.findByUrl(it.@href)) {
					def linkText = it.text()
					def hour = linkText.substring(0, 2)
					def mins = linkText.substring(3, 5)
					Date fechaDeteccion = new Date()
					GregorianCalendar calendar = new GregorianCalendar()
					calendar.set(2011, Calendar.JANUARY, 1, Integer.valueOf(hour), Integer.valueOf(mins))
					Noticia noticia = new Noticia(url: it.@href, paginaWeb:'ACB', fechaDeteccion: fechaDeteccion, fechaReal: calendar.getTime()).save(flush: true)
					log.info 'Noticia de ACB agregada'
				}
			}
		}
	}
}
