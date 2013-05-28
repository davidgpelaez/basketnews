<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />

<!--[if lt IE 9]><script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
<meta name="layout" content="main" />
<title>Welcome to BasketNews</title>
<link rel="stylesheet" href="${resource(dir:'css',file:'jqcloud.css') }" />
<link rel="stylesheet" href="${resource(dir:'css',file:'isotope.css') }" />
 <script type="text/javascript">
      /*!
       * Create an array of word objects, each representing a word in the cloud
       */
      var word_array = [
		<g:each in="${tagCloud}" var="tagCount">
		{text: "${tagCount['tag']}", weight: ${tagCount['repeticiones']}}, 
		</g:each>
      ];

    
    </script>
</head>
<body>
	<div class="row-fluid">
		<div class="span12">
		<div class="trendsMenu">
			<h2>Trending in the news</h2>
			<div id="tagCloud"
				style="width: 100%; height: 180px; text-align: center;"></div>
		</div>
		</div>
	</div>
	<div class="row-fluid">	
	
		
		<div id="news">

			<g:each in="${noticias}">
				<div class="element ${it.paginaWeb}
				<g:each in="${it.tags}" var="tag"> ${tag}  </g:each>
				"  data-web="${it.paginaWeb}">
				<span class="favIcon"><a class="btn btn-mini" href="#"><i class="icon-star"></i></a></span>	
				<span class="leido">Leído ${it.hits?:0} veces</span>
				
					<span class="basket-ribbon ${it.paginaWeb}-ribbon"><a href="#">${it.paginaWeb}</a></span>
					<g:link url="${it.url}" class="enlaceNoticia" target="_blank"> 
						<h2 class="tituloNoticia">
							${it.titulo}
						</h2>
					</g:link>
				
				<small class="fechaNoticia"><g:formatDate format="dd-MM-yyyy HH:mm:ss" date="${it.fechaDeteccion}"/></small>
				<div class="tagsNoticia">
					Tags: 
					<g:each in="${it.tags}" var="tag">
					<g:link controller="home" params="[tag:tag]"><span class="label">${tag}</span></g:link> 
					</g:each>
				</div>
				</div>
			</g:each>
			
		</div>
	</div>
	
	<div class="modal hide fade" id="myModal" role="dialog">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">&times;</button>
			<h2>Noticias a la carta!</h2>
		</div>
		<div class="modal-body">
			<form>
				<fieldset>
					<h3>Selecciona tus fuentes</h3>
					<label class="checkbox"> <input type="checkbox"> TuBasket </label>
					<label class="checkbox"> <input type="checkbox"> ACB.com </label>
					<label class="checkbox"> <input type="checkbox"> Solobasket </label>
					<label class="checkbox"> <input type="checkbox"> Marca </label>
					<label class="checkbox"> <input type="checkbox"> AdeccoOro </label>
					<hr />
					<h3>Además de esto...¿algún tema en particular?</h3>
   					<input type="text" placeholder="Draft Navarro Lebron ...">
   					<label class="checkbox"> <input type="checkbox"> Enviarme email diario con estas noticias </label>
					
				</fieldset>
			</form>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn">Cancelar</a> <a href="#" class="btn btn-primary">Guardar</a>
		</div>
	</div>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" ></script>
	
	<script src="${resource(dir:'js',file:'jqcloud-1.0.4.min.js') }"></script>
	<script src="${resource(dir:'js',file:'jquery.isotope.min.js') }"></script>
	<script src="${resource(dir:'js',file:'Chart.min.js') }"></script>
	<script src="${resource(dir:'js',file:'application.js') }"></script>
		
	<script src="${resource(dir:'js',file:'bootstrap.min.js') }"></script>
	<script src="${resource(dir:'js',file:'home.js') }"></script>
</body>
</html>
