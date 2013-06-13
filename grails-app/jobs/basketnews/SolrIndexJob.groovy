package basketnews

import geb.Browser

import org.apache.solr.client.solrj.SolrServer
import org.apache.solr.client.solrj.impl.HttpSolrServer
import org.apache.solr.common.SolrInputDocument



class SolrIndexJob {
    static triggers = {
      simple repeatInterval: 5000 // execute job once in 500 seconds
    }

    def execute() {
	//	def noticias = Noticia.findAllWhere(indexed:null, [max:10])
	//	noticias.each { noticia ->
			//index(noticia)
	//	}
       
    }


	def index(Noticia noticia){
		SolrServer server = new HttpSolrServer("http://localhost:8983/solr/noticias")
		SolrInputDocument doc = new SolrInputDocument()
		doc.addField("titulo", noticia.titulo)
		doc.addField("url", noticia.url)
		doc.addField("id", noticia.id)
		doc.addField("texto", noticia.texto)
		server.add(doc)
		server.commit()
		noticia.indexed=true
		noticia.save(flush:true)
	}
}
