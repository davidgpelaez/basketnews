<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<link rel="shortcut icon"
		href="${resource(dir: 'images', file: 'favicon.ico')}"
		type="image/x-icon">
	
	
	<title>Basket News</title>
	<link href="${resource(dir:'css',file:'bootstrap.min.css') }" rel="stylesheet" media="screen">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<!-- Bootstrap -->
 	<style type="text/css">

      /* Sticky footer styles
      -------------------------------------------------- */

      html,
      body {
        height: 100%;
        /* The html and body elements cannot have any padding or margin. */
      }

      /* Wrapper for page content to push down footer */
      #wrap {
        min-height: 100%;
        height: auto !important;
        height: 100%;
      }

      /* Set the fixed height of the footer here */
      #push,
      #footer {
        height: 60px;
      }
      #footer {
        background-color: #f5f5f5;
      }

    </style>
    <script type="text/javascript">	
	var urlPath = "${ grailsApplication.config.grails.serverURL}"; 
	</script>
	<g:layoutHead />
	</head>
	<body>
	
	<div id="wrap">
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
				</div>
				
			
				
        </div>
      </div>
    </div>
	
    <div class="container">
		<g:layoutBody />
	
	</div>
	</div>
	  <div id="footer">
      <div class="container">
      	<p>
        <b>Powered By: </b>
        <a href="">Grails</a> /
        <a href="">MongoDB</a> /
        <a href="">Gebish</a> /
        <a href="">Bootstrap</a> /
        <a href="">Isotope</a> /
        <a href="">ChartJs</a> /
        <a href="">jQCloud</a>
        </p>
      </div>
    </div>

	</body>
</html>
