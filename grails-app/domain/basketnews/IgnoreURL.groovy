package basketnews

class IgnoreURL {

	static mapWith = "mongo"
	String id
	String url
	
	static mapping = {
		url index:true
	
	}
}
