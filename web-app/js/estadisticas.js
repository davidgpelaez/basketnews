 $(function(){
	 var ctx = $("#noticiasPorPagina").get(0).getContext("2d");
	 var ctx2 = $("#myChart2").get(0).getContext("2d");
	 var ctx3 = $("#myChart3").get(0).getContext("2d");
	 var ctx4 = $("#myChart4").get(0).getContext("2d");
     new Chart(ctx).Bar(dataNumNotis);
     new Chart(ctx2).Bar(dataLeidas);
     new Chart(ctx3).Bar(dataLeidasPorNum);
     new Chart(ctx4).Bar(dataTags);
});      
       