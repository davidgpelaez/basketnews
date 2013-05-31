package es.kaylan.basket

import geb.Page
import groovy.lang.MetaClass;

class PiratasHomePage extends Page {

// pages can define their location, either absolutely or relative to a base
	static url = "http://www.piratasdelbasket.es/"
 
	static content = {
	
        news { $("h2.contentheading a") }
       
	}
	

}
