package basketnews

import org.apache.solr.client.solrj.SolrServer
import org.apache.solr.client.solrj.impl.HttpSolrServer
import org.apache.solr.common.SolrInputDocument

import es.kaylan.basket.ForoACBPage
import geb.Browser

class AcbElasticController {

//	def elasticSearchService
	
	def index() {
		
		Browser.drive {
			SolrServer server = new HttpSolrServer("http://localhost:8983/solr/noticias")
			def topicsUrls = []
			to ForoACBPage
			topics.each{
				topicsUrls << it.@href
				} 
			topicsUrls.each { topic ->
				go "${topic}"
				$('.post').each { post ->
					
					SolrInputDocument doc = new SolrInputDocument()
					doc.addField("titulo", post.find('h3 a').text())
					doc.addField("id", String.valueOf(post.hashCode()))
					doc.addField("texto", post.find('div.content').text())
					server.add(doc)
				}
				server.commit()  // periodically flush
			}
		}
	}
}
