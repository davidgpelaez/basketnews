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
		<div class="span6">
			<div class="searchMenu">
				<h2>Busca y filtra a tu gusto</h2>
				<div class="btn-group" id="filters">
					<button class="btn btn-filter" data-filter="*">Todas</button>
					<button class="btn btn-filter" data-filter=".ACB">ACB.com</button>
					<button class="btn btn-filter" data-filter=".TuBasket">TuBasket</button>
					<button class="btn btn-filter" data-filter=".Solobasket">Solobasket</button>
					<button class="btn btn-filter" data-filter=".Piratas">PiratasDelBasket</button>
					<button class="btn btn-filter" data-filter=".Marca">Marca</button>
				</div>
				<form class="form-search">
					<input type="text" class="input-medium search-query">
					<button type="submit" class="btn">Buscar</button>
				</form>
			</div>
		</div>
		<div class="span6">
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
				<div class="element ${it.paginaWeb}"  data-web="${it.paginaWeb}">
				<!-- <span><a class="btn btn-mini" href="#"><i class="icon-star"></i>Fav</a></span> -->	
					<span class="basket-ribbon ${it.paginaWeb}-ribbon"><a href="#">${it.paginaWeb}</a></span>
					<g:link url="${it.url}">
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

</body>
</html>
