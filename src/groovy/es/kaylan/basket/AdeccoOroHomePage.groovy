package es.kaylan.basket

import geb.Page
import groovy.lang.MetaClass;

class AdeccoOroHomePage extends Page {

// pages can define their location, either absolutely or relative to a base
	static url = "http://www.adeccooro.es/noticias.aspx"
 
	static content = {
	
        news { $("h2.titulo a") }
       
	}
	

}
