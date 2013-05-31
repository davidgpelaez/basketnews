 $(function(){
	 var ctx = $("#noticiasPorPagina").get(0).getContext("2d");
	 var ctx2 = $("#myChart2").get(0).getContext("2d");
     new Chart(ctx).Pie(dataNoticias);
     new Chart(ctx2).Bar(dataLeidas);
});      
       