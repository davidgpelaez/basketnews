package es.kaylan.basket

import geb.Page
import groovy.lang.MetaClass;

class TerraACBHomePage extends Page {

// pages can define their location, either absolutely or relative to a base
	static url = "http://deportes.terra.es/baloncesto/liga-acb/ultimas/"
 
	static content = {

        news { $("li a", href: startsWith('http://deportes.terra.es/baloncesto/liga-acb')) }
		
 
       
	}
	

}
