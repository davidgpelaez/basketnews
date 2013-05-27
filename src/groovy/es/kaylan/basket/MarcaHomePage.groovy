package es.kaylan.basket

import geb.Page
import groovy.lang.MetaClass;

class MarcaHomePage extends Page {

// pages can define their location, either absolutely or relative to a base
	static url = "http://www.marca.com/baloncesto.html"
 
	static content = {

        news { $("div.principal h2 a") }
		secondaryNews { $("div.secundaria h2 a") }
		otherNewsh3 { $("div.secundaria h3 a") }

		otherNewsh5 { $("div.secundaria h5 a") }
		
		
 
       
	}
	

}
