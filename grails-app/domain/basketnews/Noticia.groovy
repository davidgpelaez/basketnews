package basketnews

class Noticia {

	static mapWith = "mongo"
	String id
	String url
	String titulo
	String paginaWeb
	String subtitulo
	String texto
	String[] tags
	String[] htmlTags
	Date fechaDeteccion
	Date fechaReal
	Integer hits
	Boolean indexed
	
    static constraints = {
		titulo nullable: true
		subtitulo nullable:true 
		tags nullable:true
		htmlTags nullable:true
		texto nullable:true
		hits nullable:true 
		fechaReal nullable:true
		indexed nullable:true
    }
	
	static mapping = {
		url index:true
		titulo index:true
		paginaWeb index:true
		tags index:true
		fechaReal index:true
		sort fechaReal: "desc"
	}
}
