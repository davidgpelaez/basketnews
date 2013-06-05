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
		var leidas = new Array();
		<g:each in="${noticiasLeidas.results()}" var="leidas">
			leidas["${leidas['_id']}"] = ${leidas['leidas']};
		</g:each>
		var numNotis = new Array();
		<g:each in="${noticiasGroup.results()}" var="group">
		numNotis["${group['_id']}"] = ${group['noticias']};
		</g:each>
		var lediasPorNumero = new Array();
		<g:each in="${noticiasGroup.results()}" var="group">
		lediasPorNumero["${group['_id']}"] = leidas["${group['_id']}"]/${group['noticias']};
		</g:each>
		var tagCloud = new Array(10);
		<g:each in="${tags}" var="tag" status="i" >
		tagCloud[${i}]=new Array(2);
		tagCloud[${i}]['name']="${tag['tag']}";
		tagCloud[${i}]['num']= ${tag['repeticiones']};
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

	var dataLeidasPorNum = {labels : ["TuBasket","BasketMe","Terra","Eurosport","ACB.com","Solobasket","Marca","Adecco Oro", "Piratas"],
			datasets : [
				{
					fillColor : "rgba(5,96,242,0.5)",
					strokeColor : "rgba(220,220,220,1)",
					data : [lediasPorNumero['TuBasket'],lediasPorNumero['Basketme'],lediasPorNumero['Terra'],lediasPorNumero['Eurosport'],lediasPorNumero['ACB'],lediasPorNumero['Solobasket'],lediasPorNumero['Marca'],lediasPorNumero['AdeccoOro'],lediasPorNumero['Piratas']]
				}
			]
		}
	var dataTags = {labels : [tagCloud[0]['name'],tagCloud[1]['name'],tagCloud[2]['name'],tagCloud[3]['name'],tagCloud[4]['name'],tagCloud[5]['name'],tagCloud[6]['name'],tagCloud[7]['name'],tagCloud[8]['name'],tagCloud[9]['name']],
			datasets : [
				{
					fillColor : "rgba(5,96,242,0.5)",
					strokeColor : "rgba(220,220,220,1)",
					data : [tagCloud[0]['num'],tagCloud[1]['num'],tagCloud[2]['num'],tagCloud[3]['num'],tagCloud[4]['num'],tagCloud[5]['num'],tagCloud[6]['num'],tagCloud[7]['num'],tagCloud[8]['num'],tagCloud[9]['num']]
				}
			]
		}

</script>
</head>
<body>
	<div class="row-fluid">
		<div class="hero-unit containerGrafico">
			<h1>Noticias por medio de comunicación</h1>
			<canvas id="noticiasPorPagina" width="800" height="400"></canvas>
		
		</div>
	</div>
	<div class="row-fluid">	
		<div class="hero-unit containerGrafico">
			<h1>Clicks por medio de comunicación</h1>
			<canvas id="myChart2" width="800" height="400"></canvas>
	
		</div>
	</div>
	<div class="row-fluid">	
		<div class="hero-unit containerGrafico">
			<h1>Clicks / Número noticias</h1>
			<canvas id="myChart3" width="800" height="400"></canvas>
	
		</div>
	</div>
	<div class="row-fluid">	
		<div class="hero-unit containerGrafico">
			<h1>Tags últimos dos días</h1>
			<canvas id="myChart4" width="800" height="400"></canvas>
	
		</div>
	</div>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" ></script>
		
	<script src="${ grailsApplication.config.grails.serverURL}/js/jqcloud-1.0.4.min.js"></script>
	<script src="${ grailsApplication.config.grails.serverURL}/js/jquery.isotope.min.js"></script>
	<script src="${ grailsApplication.config.grails.serverURL}/js/Chart.min.js"></script>
	<script src="${ grailsApplication.config.grails.serverURL}/js/application.js"></script>
		
	<script src="${ grailsApplication.config.grails.serverURL}/js/bootstrap.min.js"></script>
	<script src="${ grailsApplication.config.grails.serverURL}/js/estadisticas.js"></script>
		
</body>
</html>
