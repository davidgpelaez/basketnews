package basketnews

import org.apache.solr.client.solrj.SolrServer
import org.apache.solr.client.solrj.impl.HttpSolrServer
import org.apache.solr.common.SolrInputDocument

class HomeController {

	def mongo
	//def elasticSearchService
	
    def index() {
		def noticias
		def db = mongo.getDB('basketnews')
		def tagCloud = db.tagCloud.find([$and: [[repeticiones:[$gte:4]], [isLast:true]]])
		if(params.tag){
			noticias = Noticia.findAllWhere(tags: params.tag)
		}
		else{
			noticias = Noticia.list(max: 100)
		}
		
		[noticias: noticias, tagCloud: tagCloud]
		
	}
	
	def count(){
		def url = params.noticia
		def noticia = Noticia.findByUrl(url)
		if(noticia.hits){
			noticia.hits+=1
		}
		else{
			noticia.hits=1
		}
		noticia.save(flush:true)
		
		render "$noticia.hits"
	}
	
	def search(){
		SolrServer server = new HttpSolrServer("http://localhost:8983/solr/noticias")
	//	CommonsHttpSolrServer server = new CommonsHttpSolrServer("http://localhost:8983/solr")
		for(int i=0;i<1000;++i) {
		  SolrInputDocument doc = new SolrInputDocument();
		  doc.addField("titulo", "book");
		  doc.addField("id", "book-" + i);
		  doc.addField("texto", "The Legend of Po part " + i);
		  server.add(doc);
		  if(i%100==0) server.commit();  // periodically flush
		}
		server.commit();
		
	}
//		AsyncContext ctx = startAsync()
//		ctx.start {
//			GActionFuture<SearchResponse> results = elasticSearchService.search(params.search)
//			results.setSuccess {
//				
//				results.response.hits.each {hit ->
//					log.info hit.toString()
//					render "Got hit ${hit.id} from ${hit.index}/${hit.type}"
//					ctx.complete()
//				}
//				
//			}
//
//		}
		

}
