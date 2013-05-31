package es.kaylan.basket

import geb.Page
import groovy.lang.MetaClass;

class ForoACBPage extends Page {

// pages can define their location, either absolutely or relative to a base
	static url = "http://foros.acb.com/viewforum.php?f=1"
 
	static content = {
		topics { $(".topictitle") }
        
       
	}
	

}
