package es.kaylan.basket

import geb.Page
import groovy.lang.MetaClass;

class GigantesHomePage extends Page {

// pages can define their location, either absolutely or relative to a base
	static url = "http://www.gigantes.com/"
 
	static content = {

        news { $("h1.titulo a") }
		
 
       
	}
	

}
