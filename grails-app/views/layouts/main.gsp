<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<link rel="shortcut icon"
		href="${grailsApplication.config.grails.serverURL}/images/favicon.ico"
		type="image/x-icon">
	
	
	<title>NoticiasDeBasket.com</title>
	<link href="${ grailsApplication.config.grails.serverURL}/css/bootstrap.min.css" rel="stylesheet" media="screen">
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
	<script type="text/javascript">var switchTo5x=true;</script>
	<script type="text/javascript" src="http://w.sharethis.com/button/buttons.js"></script>
	<script type="text/javascript">stLight.options({publisher: "5e0b4b18-ff95-49d6-ac73-c470948646ed", doNotHash: false, doNotCopy: false, hashAddressBar: true});</script>
	</head>
	<body>
	<script>
	  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
	
	  ga('create', 'UA-42268512-1', 'noticiasdebasket.com');
	  ga('send', 'pageview');
	
	</script>
	<div id="wrap">
	<div class="navbar navbar-inverse navbar-fixed-top navbar-basketnews">
      <div class="navbar-inner">
        <div class="container" >
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <g:link class="brand"  absolute="true" controller="home">NoticiasDeBasket.com</g:link>
         
	<!-- 
				<div class="btn-group ">
				   <g:link class="btn btn-primary" absolute="true" controller="home">Noticias</g:link>
					<button class="btn dropdown-toggle btn-primary" data-toggle="dropdown">
						<span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li><a href="#myModal" role="button" data-toggle="modal">Personalizar</a></li>
					</ul>
				</div>
	 -->
				<div class="btn-group">
					 <g:link class="btn btn-primary" absolute="true" controller="estadisticas">Estadísticas</g:link>
				</div>
				<div class="btn-group">
					 <g:link class="btn btn-primary" absolute="true" controller="home" action="aboutus">Quienes somos</g:link>
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
