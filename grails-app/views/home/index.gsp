<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />

<!--[if lt IE 9]><script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
<meta name="layout" content="main" />
<title>Welcome to BasketNews</title>
<link rel="stylesheet" href="${resource(dir:'css',file:'isotope.css') }" />
</head>
<body>
	<div class="row-fluid">

		<div class="btn-group" id="filters">
			<button class="btn btn-filter" data-filter="*">Todas</button>
			<button class="btn btn-filter" data-filter=".ACB">ACB.com</button>
			<button class="btn btn-filter" data-filter=".TuBasket">TuBasket.com</button>
			<button class="btn btn-filter" data-filter=".Solobasket">Solobasket.com</button>
		</div>

		<div id="news">

			<g:each in="${noticias}">
				<div class="element ${it.paginaWeb}"  data-web="${it.paginaWeb}">
					<span><a class="btn btn-mini" href="#"><i class="icon-star"></i>Fav</a></span>
					<p>
						${it.paginaWeb}
					</p>
					<g:link url="${it.url}">
						<h2>
							${it.titulo}
						</h2>
					</g:link>
			
				</div>
			</g:each>
			
		</div>
	</div>
	<script src="js/jquery-1.7.1.min.js"></script>
	<script src="js/jquery.isotope.min.js"></script>
	<script src="js/application.js"></script>
</body>
</html>
