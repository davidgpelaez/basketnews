package basketnews

import geb.Browser



class NoticiasCrawlerJob {
	
	def concurrent = false
	
    static triggers = {
      simple  startDelay: 10000, repeatInterval: 900000 
    }

    def execute() {
        Browser.drive {
			   log.info 'Crawler - Escaneo iniciado'
			   go "http://localhost:8080/basketnews/acb"
			   go "http://localhost:8080/basketnews/tuBasket"
			   go "http://localhost:8080/basketnews/piratas"
			   go "http://localhost:8080/basketnews/solobasket"
			   go "http://localhost:8080/basketnews/marca"
			   go "http://localhost:8080/basketnews/adeccoOro"
			 //  go "http://localhost:8080/basketnews/terra"
			 //  go "http://localhost:8080/basketnews/yahoo"
			   go "http://localhost:8080/basketnews/basketme"
			   log.info 'Crawler - Escaneo completado'
		   }
    }
}
