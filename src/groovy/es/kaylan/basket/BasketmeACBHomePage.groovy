package es.kaylan.basket

import geb.Page
import groovy.lang.MetaClass;

class BasketmeACBHomePage extends Page {

// pages can define their location, either absolutely or relative to a base
	static url = "http://www.basketme.com/noticias-acb"
 
	static content = {

        news { $("a", href: startsWith('http://www.basketme.com/noticia.php?id=')) }
		
 
       
	}
	

}
