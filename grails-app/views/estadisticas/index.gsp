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
		var colors = new Array();
		colors['TuBasket']="#FFFF00";
		colors['Marca']="#FF6C6C";
		colors['Solobasket']="#6699FF";
		colors['ACB']="#FF9900";
		colors['AdeccoOro']="#CCFF99";
		colors['Piratas']="#CCD6CC";
		var leidas = new Array();
		<g:each in="${noticiasLeidas.results()}" var="leidas">
			leidas["${leidas['_id']}"] = ${leidas['leidas']};
		</g:each>
		var numNotis = new Array();
		<g:each in="${noticiasGroup.results()}" var="group">
		numNotis["${group['_id']}"] = ${group['noticias']};
		</g:each>
		

	var dataLeidas = {labels : ["TuBasket","BasketMe","Terra","Eurosport","ACB.com","Solobasket","Marca","Adecco Oro", "Piratas"],
		datasets : [
			{
				fillColor : "rgba(5,96,242,0.5)",
				strokeColor : "rgba(220,220,220,1)",
				data : [leidas['TuBasket'],leidas['Basketme'],leidas['Terra'],leidas['Eurosport'],leidas['ACB'],leidas['Solobasket'],leidas['Marca'],leidas['AdeccoOro'],leidas['Piratas']]
			}
		]
	}


	var dataNumNotis = {labels : ["TuBasket","BasketMe","Terra","Eurosport","ACB.com","Solobasket","Marca","Adecco Oro", "Piratas"],
		datasets : [
			{
				fillColor : "rgba(5,96,242,0.5)",
				strokeColor : "rgba(220,220,220,1)",
				data : [numNotis['TuBasket'],numNotis['Basketme'],numNotis['Terra'],numNotis['Eurosport'],numNotis['ACB'],numNotis['Solobasket'],numNotis['Marca'],numNotis['AdeccoOro'],numNotis['Piratas']]
			}
		]
	}

</script>
</head>
<body>
	<div class="row-fluid">
		<div class="hero-unit containerGrafico">
			<h1>Noticias por página</h1>
			<canvas id="noticiasPorPagina" width="800" height="400"></canvas>
		
		</div>
	</div>
	<div class="row-fluid">	
		<div class="hero-unit containerGrafico">
			<h1>Clicks por página</h1>
			<canvas id="myChart2" width="800" height="400"></canvas>
	
		</div>
	</div>
	
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" ></script>
		
	<script src="${resource(dir:'js',file:'jqcloud-1.0.4.min.js') }"></script>
	<script src="${resource(dir:'js',file:'jquery.isotope.min.js') }"></script>
	<script src="${resource(dir:'js',file:'Chart.min.js') }"></script>
	<script src="${resource(dir:'js',file:'application.js') }"></script>
		
	<script src="${resource(dir:'js',file:'bootstrap.min.js') }"></script>
	<script src="${resource(dir:'js',file:'estadisticas.js') }"></script>
</body>
</html>
