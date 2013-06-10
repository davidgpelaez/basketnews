<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />

<!--[if lt IE 9]><script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
<meta name="layout" content="main" />
<title>Welcome to BasketNews</title>
<link rel="stylesheet" href="${ grailsApplication.config.grails.serverURL}/css/jqcloud.css" />
<link rel="stylesheet" href="${ grailsApplication.config.grails.serverURL}/css/isotope.css" />
 <script type="text/javascript">
      /*!
       * Create an array of word objects, each representing a word in the cloud
       */
      var word_array = [
		<g:each in="${tagCloud}" var="tagCount">
		{text: "${tagCount['tag']}", weight: ${tagCount['repeticiones']}, link: urlPath+"/home/index?tag=${tagCount['tag']}"}, 
		</g:each>
      ];

    
    </script>
</head>
<body>
	<div class="row">
		<div class="span2">
		</div>
		<div class="span10">
		<div class="trendsMenu">
			<h2>Trending in the news</h2>
			<div id="tagCloud"
				style="width: 100%; height: 160px; text-align: center;"></div>
		</div>
		</div>
	</div>
	<div class="row center">
		<div class="span2">
		
		</div>
		<div class="span10">
		
		<g:paginate action="index" total="${noticiasCount}" next="Siguiente" prev="Anterior"/>
		</div>
	</div>
	<!-- <div class="form-search">
		  <input type="text" class="input-medium search-query"  id="search" name="search" placeholder="Busca noticias..." >
		   <button class="btn" id="searchButton" type="button">Buscar!</button>
		</div>
		 -->	
	<div class="row">
		<div class="span2">
			<div class="input-append">
			  <input class="span2" id="appendedInputButton" type="text">
			  <button class="btn" type="button"><i class="icon-search"></i></button>
			</div>
			<div class="well">
				<div id="filters" data-toggle="buttons-radio">
					<button type="button" class="btn btn-block btn-filter  btn-primary" data-filter="*">Todas</button>
					<button type="button" class="btn btn-block btn-filter btn-block btn-primary" data-filter=".ACB">ACB.com</button>
					<button type="button" class="btn btn-filter btn-block btn-primary" data-filter=".AdeccoOro">AdeccoOro</button>
					<button type="button" class="btn btn-filter btn-block btn-primary" data-filter=".Basketme">BasketMe</button>
					<button type="button" class="btn btn-filter btn-block btn-primary" data-filter=".Eurosport">Eurosport</button>
					<button type="button" class="btn btn-filter btn-block btn-primary" data-filter=".Marca">Marca</button>
					<button type="button" class="btn btn-filter btn-block btn-primary" data-filter=".Piratas">Piratas</button>
					<button type="button" class="btn btn-filter btn-block btn-primary"  data-filter=".Solobasket">Solobasket</button>
					<button type="button" class="btn btn-filter btn-block btn-primary" data-filter=".Terra">Terra</button>
					<button type="button" class="btn btn-filter btn-block btn-primary"  data-filter=".TuBasket">TuBasket</button>
				</div>
			</div>
		</div>
		<div class="span10">
		<div id="news">

			<g:each in="${noticias}">
				<div class="element ${it.paginaWeb}"  data-web="${it.paginaWeb}">
				<span class="favIcon"><a class="btn btn-mini" href="#"><i class="icon-star"></i></a></span>	
				<span class="leido">Leído ${it.hits?:0} veces</span>
				
					<span class="basket-ribbon ${it.paginaWeb}-ribbon"><a href="#">${it.paginaWeb}</a></span>
					<g:link url="${it.url}" class="enlaceNoticia" target="_blank"> 
						<h2 class="tituloNoticia">
							${it.titulo}
						</h2>
					</g:link>
				
				<small class="fechaNoticia"><g:formatDate format="dd-MM-yyyy HH:mm:ss" date="${it.fechaReal}"/></small>
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
	
	<script src="${ grailsApplication.config.grails.serverURL}/js/jqcloud-1.0.4.min.js"></script>
	<script src="${ grailsApplication.config.grails.serverURL}/js/jquery.isotope.min.js"></script>
	<script src="${ grailsApplication.config.grails.serverURL}/js/Chart.min.js"></script>
	<script src="${ grailsApplication.config.grails.serverURL}/js/application.js"></script>
		
	<script src="${ grailsApplication.config.grails.serverURL}/js/bootstrap.min.js"></script>
	<script src="${ grailsApplication.config.grails.serverURL}/js/home.js"></script>
</body>
</html>
