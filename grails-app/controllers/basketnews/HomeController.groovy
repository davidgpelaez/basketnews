package basketnews

import org.apache.solr.client.solrj.SolrServer
import org.apache.solr.client.solrj.impl.HttpSolrServer
import org.apache.solr.common.SolrInputDocument

class HomeController {

	def mongo
	def noticiasService
	
    def index() {
		def noticias
		def db = mongo.getDB('basketnews')
		def tagCloud = db.tagCloud.find([$and: [[repeticiones:[$gte:6]], [isLast:true]]])
		if(params.tag){
			noticias = Noticia.findAllWhere(tags: params.tag)
		}
		else{
			params.max = Math.min(params.max ? params.int('max') : 50, 50)
			noticias = Noticia.list(params)
		}
		
		[noticias: noticias, noticiasCount: Noticia.count, tagCloud: tagCloud]
		
	}
	
	def count(){
		render noticiasService.countClick(params.noticia)

	}
	
	def search(){

		
	}


}
