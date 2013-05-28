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
		colors['TuBasket']="#F38630";
		colors['Marca']="red";
		colors['Solobasket']="blue";
		colors['ACB']="orange";
		colors['AdeccoOro']="yellow";
		var leidas = new Array();
		<g:each in="${noticiasLeidas.results()}" var="leidas">
			leidas["${leidas['_id']}"] = ${leidas['leidas']};
		</g:each>
		
       var dataNoticias = [
				<g:each in="${noticiasGroup.results()}" var="group">
				{
					value: ${group['noticias']}, 
					color: colors["${group['_id']}"]
				}, 
				</g:each>
               ]

	var dataLeidas = {labels : ["TuBasket","ACB.com","Solobasket","Marca","Adecco Oro"],
		datasets : [
			{
				fillColor : "rgba(220,220,220,0.5)",
				strokeColor : "rgba(220,220,220,1)",
				data : [leidas['TuBasket'],leidas['ACB'],leidas['Solobasket'],leidas['Marca'],leidas['AdeccoOro']]
			}
		]
	}

</script>
</head>
<body>
	<div class="row-fluid">
		<canvas id="myChart" width="400" height="400"></canvas>
		<ul>
		<li style="background-color:#F38630">TuBasket</li>
		<li style="background-color:orange">ACB</li>
		<li style="background-color:red">Marca</li>
		<li style="background-color:blue">Solobasket</li>
		<li style="background-color:yellow">AdeccoOro</li>
		</ul>
	</div>
	<div class="row-fluid">	
	<canvas id="myChart2" width="400" height="400"></canvas>
	
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
