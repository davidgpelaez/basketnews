package basketnews

import groovy.transform.Synchronized;

class NoticiasService {

	@Synchronized
    def countClick(def url) {
		def noticia = Noticia.findByUrl(url)
		if(noticia.hits){
			noticia.hits+=1
		}
		else{
			noticia.hits=1
		}
		noticia.save(flush:true)
		noticia.hits
    }
}
