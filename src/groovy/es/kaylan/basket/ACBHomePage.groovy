package es.kaylan.basket

import geb.Page
import groovy.lang.MetaClass;

class ACBHomePage extends Page {

// pages can define their location, either absolutely or relative to a base
	static url = "http://www.acb.com/"
 
	static content = {
        news { $("div.ultimas_notis a") }
       
	}
	

}
