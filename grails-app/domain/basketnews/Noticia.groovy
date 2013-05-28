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
	Date fechaDeteccion
	Integer hits
	
    static constraints = {
		titulo nullable: true
		subtitulo nullable:true 
		tags nullable:true
		texto nullable:true
		hits nullable:true 
    }
	
	static mapping = {
		url index:true
		titulo index:true
		paginaWeb index:true
		tags index:true
		sort fechaDeteccion: "desc"
	}
}
