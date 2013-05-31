package es.kaylan.basket

import geb.Page
import groovy.lang.MetaClass;

class ForoACBTopicPage extends Page {
 
	static content = {
	
       posts { $(".post") }
       
	}
	

}
