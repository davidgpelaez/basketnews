package basketnews

import geb.Browser
import basketnews.Noticia



class NoticiasScraperJob {
	
	def concurrent = false
	
    static triggers = {
      simple repeatInterval: 60000 // execute job once in 5 seconds
    }

    def execute() {
	log.info 'Scrapper - Iniciado'
       def noticiasNuevasACB = Noticia.findAllWhere(paginaWeb:'ACB', titulo:null)
	   noticiasNuevasACB.each { noticia ->
		   Browser.drive {
			   
			   go "${noticia.url}"
			   noticia.titulo = $('div.tituloreal').text()
			   noticia.subtitulo = $('div.entradillaarticulo').text()
			//   noticia.tags = $('meta', 'http-equiv': 'keywords').@content.split(",")
			   noticia.save(flush:true)
			   log.info 'Noticia ${noticia.url} actualizada'
		   }
	   }
	   
	   def noticiasNuevasTuBasket = Noticia.findAllWhere(paginaWeb:'TuBasket', titulo:null)
	   noticiasNuevasTuBasket.each { noticia ->
		   Browser.drive {
			   
			   go "${noticia.url}"
			   noticia.titulo = $('article.new-body h1').text()
			   noticia.subtitulo = $('article.new-body div.body').text()
			  // noticia.tags = $('meta', 'http-equiv': 'keywords').@content.split(",")
			   noticia.save(flush:true)
			   log.info 'Noticia ${noticia.url} actualizada'
		   }
	   }
	   
	   def noticiasNuevasGigantes = Noticia.findAllWhere(paginaWeb:'Gigantes', titulo:null)
	   noticiasNuevasGigantes.each { noticia ->
		   Browser.drive {
			   
			   go "${noticia.url}"
			   noticia.titulo = $('h1.titulo a').text()
			//   noticia.subtitulo = $('div.new-body div.body').text()
			 //  noticia.tags = $('meta', 'http-equiv': 'keywords').@content.split(",")
			   noticia.save(flush:true)
			   log.info "Noticia ${noticia.url} actualizada"
		   }
	   }
	   
	   def noticiasNuevasSolobasket = Noticia.findAllWhere(paginaWeb:'Solobasket', titulo:null)
	   noticiasNuevasSolobasket.each { noticia ->
		   Browser.drive {
			   
			   go "${noticia.url}"
			   noticia.titulo = $('h1.title').text()
			//   noticia.subtitulo = $('div.new-body div.body').text()
			//   noticia.tags = $('li.tag a').text()
			   noticia.save(flush:true)
			   log.info "Noticia ${noticia.url} actualizada"
		   }
	   }
	   
	   log.info 'Scraper - Escaneo finalizado'
    }
}
