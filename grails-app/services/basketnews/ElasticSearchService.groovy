package basketnews
import static org.elasticsearch.groovy.node.GNodeBuilder.*

import org.elasticsearch.groovy.client.GClient
import org.elasticsearch.groovy.common.xcontent.GXContentBuilder
import org.elasticsearch.groovy.node.GNode
import org.elasticsearch.search.SearchHit;

class ElasticSearchService {

	GNode node
	GClient client
	
	ElasticSearchService(){
		GXContentBuilder.rootResolveStrategy = Closure.DELEGATE_FIRST;
		node = nodeBuilder().node()
		client = node.client
	}
	
    def indexarNoticia(def noticiaUrl, def noticiaPaginaWeb, def noticiaTitulo, def noticiaTexto) {
		def indexR = client.index {
			index "noticia"
			type "scrapping"
			source {
				url = noticiaUrl
				paginaWeb = noticiaPaginaWeb
				titulo = noticiaTitulo
				texto = noticiaTexto
			}
		}
		
		indexR.setSuccess {
			log.info "ok!"
		}
		
		indexR.setFailure {
			log.info "Fails...${it}"
		}
    }
	
	def indexarPost(def title, def user, def text){
		def indexR = client.index {
			index "foro"
			type "post"
			source {
				titulo = title
				usuario = user
				texto = text
			}
		}
		
		indexR.setSuccess {
			log.info "ok!"
		}
		
		indexR.setFailure {
			log.info "Fails...${it}"
		}
	}
	
	def search(def text){
		def result = client.search {
		    indices "noticia"
		    types "scrapping"
		    source {
		        query {
		            term(titulo: "nba")
		        }
		    }
		}
		result
		
	}
	
}
