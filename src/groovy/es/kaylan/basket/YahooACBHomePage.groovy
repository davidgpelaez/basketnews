package es.kaylan.basket

import geb.Page
import groovy.lang.MetaClass;

class YahooACBHomePage extends Page {

// pages can define their location, either absolutely or relative to a base
	static url = "http://es.eurosport.yahoo.com/eurosport.com--baloncesto/acb/archivo/1.html"
 
	static content = {

         news { $("h4 a", href: startsWith('http://es.eurosport.yahoo.com/noticias/')) }
		
 
       
	}
	

}