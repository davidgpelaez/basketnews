package es.kaylan.basket

import geb.Page
import groovy.lang.MetaClass;

class ManiacsHomePage extends Page {

// pages can define their location, either absolutely or relative to a base
	static url = "http://www.nbamaniacs.com/noticias/"
 
	static content = {
	
        news { $("h2.xlarge a") }
       
	}
	

}
