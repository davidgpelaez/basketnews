package basketnews

import geb.Browser

import java.text.SimpleDateFormat

import org.apache.solr.client.solrj.SolrServer
import org.apache.solr.client.solrj.impl.HttpSolrServer
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument



class NoticiasScraperJob {

	SolrServer server = new HttpSolrServer("http://localhost:8983/solr/news")
	
	def concurrent = false
	//	def elasticSearchService

	static boolean isFirst = true
	
	static triggers = {
      simple  startDelay: 240000, repeatInterval: 60000 
	 // simple  repeatInterval: 60000
    }

	
	def execute() {
		log.info 'Scrapper - Iniciado'
		def noticiasNuevasACB = Noticia.findAllWhere(paginaWeb:'ACB', titulo:null)
		noticiasNuevasACB.each { noticia ->

			Browser.drive {
				SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM. yyyy")
				GregorianCalendar calendar = new GregorianCalendar()
				go "${noticia.url}"
				noticia.titulo = $('div.tituloreal').text()
				noticia.subtitulo = $('div.entradillaarticulo').text()
				noticia.htmlTags = $('meta', 'http-equiv': 'keywords').@content.split(",")
				noticia.texto = $('.cuerpoarticulo').text()
				def textoFecha = $(".cuerpoarticulo b").text()
				try{
					Date fecha = dateFormat.parse(textoFecha.substring(textoFecha.indexOf(", ")+2, textoFecha.length()-2))
					calendar.setTime(fecha)
					calendar.set(Calendar.HOUR, noticia.fechaReal.hours)
					calendar.set(Calendar.MINUTE, noticia.fechaReal.minutes)
					noticia.fechaReal = calendar.getTime()
				}catch(Exception ex){
					log.warn 'No hemos podido obtener la fecha de la noticia: '+noticia.url
					noticia.fechaReal = noticia.fechaDeteccion
				}
				if(noticia.titulo)
				{
					noticia.save(flush:true)
					log.info "Noticia ${noticia.url} actualizada"
					indexarNoticia(noticia)
				}
				else{
					noticia.delete(flush:true)
					IgnoreURL ignore = new IgnoreURL(url: noticia.url).save(flush:true)
					log.info "Noticia ${noticia.url} eliminada, parece que ya no existe o no es una noticia. La metemos en Ignores"
				}

			}
		}

		def noticiasNuevasTuBasket = Noticia.findAllWhere(paginaWeb:'TuBasket', titulo:null)
		noticiasNuevasTuBasket.each { noticia ->
			Browser.drive {
				SimpleDateFormat dateFormat = new SimpleDateFormat('dd/MM/yyyy - HH:mm')

				go "${noticia.url}"
				noticia.titulo = $('article.new-body h1').text()
				noticia.subtitulo = $('article.new-body div.body').text()
			    noticia.texto = $('.body').text()

				try{
					noticia.fechaReal = dateFormat.parse($('.author span')[0].text()+' - '+$('.author span')[1].text())
				}catch(Exception ex){
					log.warn 'No hemos podido obtener la fecha de la noticia: '+noticia.url
						if(isFirst){
							noticia.fechaReal = noticia.fechaDeteccion-1
						}
						else{
							noticia.fechaReal = noticia.fechaDeteccion
						}
				
				}

				if(noticia.titulo && !Noticia.findByTitulo(noticia.titulo))
				{
					noticia.save(flush:true)
					log.info "Noticia ${noticia.url} actualizada"
					indexarNoticia(noticia)
				}
				else{
					noticia.delete(flush:true)
					IgnoreURL ignore = new IgnoreURL(url: noticia.url).save(flush:true)
					log.info "Noticia ${noticia.url} eliminada, parece que ya no existe o no es una noticia. La metemos en Ignores"
				}
			}
		}


		def noticiasNuevasSolobasket = Noticia.findAllWhere(paginaWeb:'Solobasket', titulo:null)
		noticiasNuevasSolobasket.each { noticia ->
			Browser.drive {
				SimpleDateFormat dateFormat = new SimpleDateFormat('dd/MM/yyyy - HH:mm')
				go "${noticia.url}"
				noticia.titulo = $('h1.title').text()
				noticia.subtitulo = $('.content-summary li').text()
				noticia.texto = $('.story-content').text()
				try{
					noticia.fechaReal = dateFormat.parse($('.date-display-single').text())
				}catch(Exception ex){
					log.warn 'No hemos podido obtener la fecha de la noticia: '+noticia.url
					noticia.fechaReal = noticia.fechaDeteccion
				}
				if(noticia.titulo)
				{
					noticia.save(flush:true)
					log.info "Noticia ${noticia.url} actualizada"
					indexarNoticia(noticia)
				}
				else{
					noticia.delete(flush:true)
					IgnoreURL ignore = new IgnoreURL(url: noticia.url).save(flush:true)
					log.info "Noticia ${noticia.url} eliminada, parece que ya no existe o no es una noticia. La metemos en Ignores"
				}
			}
		}


		def noticiasNuevasMarca = Noticia.findAllWhere(paginaWeb:'Marca', titulo:null)
		noticiasNuevasMarca.each { noticia ->
			Browser.drive {
				SimpleDateFormat dateFormatNBAes = new SimpleDateFormat('dd/MM/yy HH:mm')
				SimpleDateFormat dateFormat = new SimpleDateFormat('dd/MM/yy - HH:mm.')
				go "${noticia.url}"
				noticia.titulo = $('div.cab_articulo h1').text()
				noticia.subtitulo = $('li h4').text()
				noticia.texto = $('.cuerpo_articulo').text()
				try{
					noticia.fechaReal = dateFormat.parse($('.fecha').text())
				}catch(Exception exc){
					try{
						noticia.fechaReal = dateFormatNBAes.parse($('.fecha').text())
					}catch(Exception ex){
						noticia.fechaReal=noticia.fechaDeteccion
					}
				}
				if(noticia.titulo)
				{
					noticia.save(flush:true)
					log.info "Noticia ${noticia.url} actualizada"
					indexarNoticia(noticia)
				}
				else{
					noticia.delete(flush:true)
					IgnoreURL ignore = new IgnoreURL(url: noticia.url).save(flush:true)
					log.info "Noticia ${noticia.url} eliminada, parece que ya no existe o no es una noticia. La metemos en Ignores"
				}
			}
		}

		def noticiasNuevasAdeccoOro = Noticia.findAllWhere(paginaWeb:'AdeccoOro', titulo:null)
		noticiasNuevasAdeccoOro.each { noticia ->
			Browser.drive {

				go "${noticia.url}"
				noticia.titulo = $('h1.titulo').text()
				noticia.subtitulo = $('div.entradilla').text()
				noticia.texto = $('.cuerpo').text()
				//TODO solo tenemos día, no hora...
				if(isFirst){
					noticia.fechaReal = noticia.fechaDeteccion-1
				}
				else{
					noticia.fechaReal = noticia.fechaDeteccion
				}
				
				if(noticia.titulo)
				{
					noticia.save(flush:true)
					log.info "Noticia ${noticia.url} actualizada"
					indexarNoticia(noticia)
				}
				else{
					noticia.delete(flush:true)
					IgnoreURL ignore = new IgnoreURL(url: noticia.url).save(flush:true)
					log.info "Noticia ${noticia.url} eliminada, parece que ya no existe o no es una noticia. La metemos en Ignores"
				}

			}
		}

		def noticiasNuevasPiratas = Noticia.findAllWhere(paginaWeb:'Piratas', titulo:null)
		noticiasNuevasPiratas.each { noticia ->
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd 'de' MMMMM 'de' yyyy HH:mm", new Locale("es", "ES"))
			Browser.drive {
				go "${noticia.url}"
				def textoFecha = $('span.createdate').text()
				noticia.titulo = $('h2.contentheading a').text().toLowerCase().capitalize()
				noticia.subtitulo = $('div.article-content b').text()
				noticia.texto = $('.article-content').text()
				try{
					noticia.fechaReal = dateFormat.parse(textoFecha.substring(textoFecha.indexOf(", ")+2, textoFecha.length()))
				}catch(Exception ex){
					log.warn 'No hemos podido obtener la fecha de la noticia: '+noticia.url
					noticia.fechaReal = noticia.fechaDeteccion
				}
				if(noticia.titulo)
				{
					noticia.save(flush:true)
					log.info "Noticia ${noticia.url} actualizada"
					indexarNoticia(noticia)
				}
				else{
					noticia.delete(flush:true)
					IgnoreURL ignore = new IgnoreURL(url: noticia.url).save(flush:true)
					log.info "Noticia ${noticia.url} eliminada, parece que ya no existe o no es una noticia. La metemos en Ignores"
				}
			}
		}

		def noticiasNuevasTerra = Noticia.findAllWhere(paginaWeb:'Terra', titulo:null)
		noticiasNuevasTerra.each { noticia ->
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd 'de' MMMMM 'de' yyyy - HH:mm", new Locale("ES","es"))
			Browser.drive {

				go "${noticia.url}"
				noticia.titulo = $('h2.ttl-main').text()
				noticia.subtitulo = $('h2.description').text()
				noticia.texto = $('#news-container').text()
				try{
					def fecha = $('time')[0].text()+' - '+$('time')[1].text()
					noticia.fechaReal = dateFormat.parse(fecha)
				}catch(Exception ex){
					log.warn 'No hemos podido obtener la fecha de la noticia: '+noticia.url
					noticia.fechaReal = noticia.fechaDeteccion

				}
				if(noticia.titulo)
				{
					noticia.save(flush:true)
					log.info "Noticia ${noticia.url} actualizada"
					indexarNoticia(noticia)
				}
				else{
					noticia.delete(flush:true)
					IgnoreURL ignore = new IgnoreURL(url: noticia.url).save(flush:true)
					log.info "Noticia ${noticia.url} eliminada, parece que ya no existe o no es una noticia. La metemos en Ignores"
				}
			}
		}

		def noticiasYahooNuevas = Noticia.findAllWhere(paginaWeb:'Eurosport', titulo:null)
		noticiasYahooNuevas.each { noticia ->
			Browser.drive {
				SimpleDateFormat dateFormat = new SimpleDateFormat('EEE, dd MMM yyyy HH:mm z', new Locale("ES","es"))
				go "${noticia.url}"
				noticia.titulo = $('h1.headline').text()
				noticia.subtitulo = $('h2.subheadline').text()
				noticia.texto = $('#mediaarticlebody').text()
				try{
					log.info $('abbr')
					noticia.fechaReal = dateFormat.parse($('abbr').text())
				}catch(Exception exp){
					log.warn 'No hemos podido obtener la fecha de la noticia: '+noticia.url
					log.info 'Lo intentamos con abbr[1]'
					try{
						noticia.fechaReal = dateFormat.parse($('abbr')[1].text())
					}catch(Exception ex){
						log.warn 'Imposible tampoco con: '+$('abbr')[1].text()
						noticia.fechaReal = noticia.fechaDeteccion
					}

				}
				if(noticia.titulo)
				{
					noticia.save(flush:true)
					log.info "Noticia ${noticia.url} actualizada"
					indexarNoticia(noticia)
				}
				else{
					noticia.delete(flush:true)
					IgnoreURL ignore = new IgnoreURL(url: noticia.url).save(flush:true)
					log.info "Noticia ${noticia.url} eliminada, parece que ya no existe o no es una noticia. La metemos en Ignores"
				}
			}
		}
		def noticiasNuevasBasketme = Noticia.findAllWhere(paginaWeb:'Basketme', fechaReal:null)
		noticiasNuevasBasketme.each { noticia ->
			Browser.drive {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy - HH:mm'h'.")
				go "${noticia.url}"
				
				noticia.subtitulo = $('h2.subheadline').text()
				noticia.texto = $('.noticia').text()
				//Infierno de html...
				def fecha = $('span', style: 'color: #CC0000;')
					try{				
						noticia.fechaReal = dateFormat.parse(fecha.text())
					}catch(Exception ex){
						log.info 'No hemos podido obtener la fecha para la noticia de basketme: '+noticia.url
						noticia.fechaReal = noticia.fechaDeteccion
					}
		
				if(noticia.titulo)
				{
					noticia.save(flush:true)
					log.info "Noticia ${noticia.url} actualizada"
					indexarNoticia(noticia)
				}
				else{
					noticia.delete(flush:true)
					IgnoreURL ignore = new IgnoreURL(url: noticia.url).save(flush:true)
					log.info "Noticia ${noticia.url} eliminada, parece que ya no existe o no es una noticia. La metemos en Ignores"
				}
			}
		}
		
		def noticiasNuevasNbaManiacs = Noticia.findAllWhere(paginaWeb:'NbaManiacs', fechaReal:null)
		noticiasNuevasNbaManiacs.each { noticia ->
			Browser.drive {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMMM yyyy - HH:mm", new Locale("ES","es"))
				go "${noticia.url}"
				noticia.titulo = $('h1.xxlarge').text()
		
		
				def postmetadata = $('.postmetadata').text().split('/')
					try{
						noticia.fechaReal = dateFormat.parse(postmetadata[1].trim())
					}catch(Exception ex){
						log.info 'No hemos podido obtener la fecha para la noticia de nba maniacs: '+noticia.url
						log.info 'Fecha: '+postmetadata[1]
						noticia.fechaReal = noticia.fechaDeteccion
					}
		
				if(noticia.titulo)
				{
					noticia.save(flush:true)
					log.info "Noticia ${noticia.url} actualizada"
					indexarNoticia(noticia)
				}
				else{
					noticia.delete(flush:true)
					IgnoreURL ignore = new IgnoreURL(url: noticia.url).save(flush:true)
					log.info "Noticia ${noticia.url} eliminada, parece que ya no existe o no es una noticia. La metemos en Ignores"
				}
			}
		}

	
		isFirst = false
		log.info 'Scraper - Escaneo finalizado'
	}
	
	
	def indexarNoticia = { Noticia noticia ->
		try{
			SolrInputDocument doc = new SolrInputDocument()
			doc.addField("titulo", noticia.titulo)
			doc.addField("url", noticia.url)
			doc.addField("id", noticia.id)
			doc.addField("texto", noticia.texto)
			UpdateResponse resp = server.add(doc)
			
			server.commit()
			noticia.indexed=true
			noticia.save(flush:true)
			log.info "Noticia indexada en Solr, respuesta: ${resp.status}"
		}
		catch(Exception ex){
			log.error "Error indexando en Solr!!!", ex
		}
	}
}
