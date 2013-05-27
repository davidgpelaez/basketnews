package es.kaylan.basket

import geb.Page
import groovy.lang.MetaClass;

class SolobasketHomePage extends Page {

// pages can define their location, either absolutely or relative to a base
	static url = "http://www.solobasket.com/"
 
	static content = {

        news { $("h2.node-title a", href: startsWith('http://www.solobasket.com')) }
		
 
       
	}
	

}
