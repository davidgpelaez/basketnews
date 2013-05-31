<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<link rel="shortcut icon"
		href="${resource(dir: 'images', file: 'favicon.ico')}"
		type="image/x-icon">
	
	
	<title>Basket News</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- Bootstrap -->
	<link href="${resource(dir:'css',file:'bootstrap.min.css') }" rel="stylesheet" media="screen">
	<g:layoutHead />
	</head>
	<body>
	<div class="navbar navbar-inverse navbar-fixed-top navbar-basketnews">
      <div class="navbar-inner">
        <div class="container" >
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <g:link class="brand" controller="home">BasketNews</g:link>
         

				<div class="btn-group ">
				   <g:link class="btn btn-primary" controller="home">Noticias</g:link>
					<button class="btn dropdown-toggle btn-primary" data-toggle="dropdown">
						<span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li><a href="#myModal" role="button" data-toggle="modal">Personalizar</a></li>
					</ul>
				</div>

				<div class="btn-group">
					 <g:link class="btn btn-primary" controller="estadisticas">Estadísticas</g:link>
					<button class="btn dropdown-toggle btn-primary" data-toggle="dropdown">
						<span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li><a href="#">Noticias por página</a></li>
						<li><a href="#">Noticias más visitadas</a></li>
						<li><a href="#">Trendings</a></li>
					</ul>
				</div>
				
			
				
        </div>
      </div>
    </div>

    <div class="container">
		<g:layoutBody />
	
	</div>
	</body>
</html>
