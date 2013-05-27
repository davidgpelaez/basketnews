package basketnews

import geb.Browser



class NoticiasCrawlerJob {
	
	def concurrent = false
	
    static triggers = {
      simple  startDelay: 10000, repeatInterval: 100000 // execute job once in 5 seconds
    }

    def execute() {
        Browser.drive {
			   log.info 'Crawler - Escaneo iniciado'
			   go "http://localhost:8080/basketnews/acb"
			   go "http://localhost:8080/basketnews/tuBasket"
			   go "http://localhost:8080/basketnews/solobasket"
			   go "http://localhost:8080/basketnews/gigantes"
			   log.info 'Crawler - Escaneo completado'
		   }
    }
}
