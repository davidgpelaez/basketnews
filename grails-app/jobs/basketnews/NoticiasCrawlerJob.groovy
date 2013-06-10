package basketnews

import geb.Browser



class NoticiasCrawlerJob {
	
	def concurrent = false
	def grailsApplication

    static triggers = {
      simple  startDelay: 10000, repeatInterval: 900000 
    }

	def execute() {
		Browser.drive {
			log.info 'Crawler - Escaneo iniciado'
			go grailsApplication.config.grails.serverURL+"/acb"
			go grailsApplication.config.grails.serverURL+"/tuBasket"
			go grailsApplication.config.grails.serverURL+"/piratas"
			go grailsApplication.config.grails.serverURL+"/solobasket"
			go grailsApplication.config.grails.serverURL+"/marca"
			go grailsApplication.config.grails.serverURL+"/adeccoOro"
			go grailsApplication.config.grails.serverURL+"/terra"
			go grailsApplication.config.grails.serverURL+"/yahoo"
			go grailsApplication.config.grails.serverURL+"/basketme"
			go grailsApplication.config.grails.serverURL+"/nbaManiacs"
			log.info 'Crawler - Escaneo completado'
		}
	}

}
