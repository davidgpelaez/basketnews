package es.kaylan.basket

import geb.Page
import groovy.lang.MetaClass;

class TuBasketHomePage extends Page {

// pages can define their location, either absolutely or relative to a base
	static url = "http://www.tubasket.com/"
 
	static content = {
        news { $("a", href: startsWith('http://www.tubasket.com/noticia/')) }
		
 
       
	}
	

}
