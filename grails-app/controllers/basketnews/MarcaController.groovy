package basketnews

import es.kaylan.basket.MarcaHomePage
import geb.Browser

class MarcaController {

	def index() {
		Browser.drive {
			to MarcaHomePage
			news.each{
				if(!Noticia.findByUrl(it.@href) && !IgnoreURL.findByUrl(it.@href) && (!it.@href.contains("blogs") && !it.@href.contains("albumes"))) {
					Noticia noticia = new Noticia(url: it.@href, paginaWeb:'Marca', fechaDeteccion: new Date()).save(flush: true)
					log.info 'Noticia de marca agregada'
				}
			}
			secondaryNews.each{
				if(!Noticia.findByUrl(it.@href) && !IgnoreURL.findByUrl(it.@href) && (!it.@href.contains("blogs") && !it.@href.contains("albumes"))) {
					Noticia noticia = new Noticia(url: it.@href, paginaWeb:'Marca', fechaDeteccion: new Date()).save(flush: true)
					log.info 'Noticia de marca agregada'
				}
			}
			otherNewsh3?.each{
				if(!Noticia.findByUrl(it.@href) && !IgnoreURL.findByUrl(it.@href) && (!it.@href.contains("blogs") && !it.@href.contains("albumes"))) {
					Noticia noticia = new Noticia(url: it.@href, paginaWeb:'Marca', fechaDeteccion: new Date()).save(flush: true)
					log.info 'Noticia de marca agregada'
				}
			}

			otherNewsh5?.each{
				if(!Noticia.findByUrl(it.@href) && !IgnoreURL.findByUrl(it.@href) && (!it.@href.contains("blogs") && !it.@href.contains("albumes"))) {
					Noticia noticia = new Noticia(url: it.@href, paginaWeb:'Marca', fechaDeteccion: new Date()).save(flush: true)
					log.info 'Noticia de marca agregada'
				}
			}
		}
	}
}
