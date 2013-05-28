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
        <div class="container-fluid">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href="#">BasketNews</a>
         	<div class="btn-group" id="filters">
					<button class="btn btn-filter" data-filter="*">Todas</button>
					<button class="btn btn-filter" data-filter=".ACB">ACB.com</button>
					<button class="btn btn-filter" data-filter=".TuBasket">TuBasket</button>
					<button class="btn btn-filter" data-filter=".Solobasket">Solobasket</button>
					<button class="btn btn-filter" data-filter=".Piratas">PiratasDelBasket</button>
					<button class="btn btn-filter" data-filter=".Marca">Marca</button>
				</div>
        </div>
      </div>
    </div>

    <div class="container">
		<g:layoutBody />
	
	</div>
	</body>
</html>
