$(function(){

	 $('#news').isotope({
        itemSelector: '.element'
      });
      
      $('#searchButton').click(function(){
    	  $.ajax({
    		  type: "GET",
    		  url: urlPath+"/home/search",
    		  data: { texto: $('#search').val()}
    		}).done(function( msg ) {
    		  alert(msg);
    		});
    	});

      
      $('.btn-filter').click(function(){
    	  var selector = $(this).attr('data-filter');
    	  $('#news').isotope({ filter: selector });

        });


    //$("#tagCloud").jQCloud(word_array,{afterCloudRender: makeTagFilters});
      $("#tagCloud").jQCloud(word_array);
    
    $(".enlaceNoticia").mousedown(function() {
    	$.ajax({
    		  type: "POST",
    		  url: urlPath+"/home/count",
    		  data: { noticia: $(this).attr('href')}
    		}).done(function( msg ) {
    		  //Actualizar el "leido $msg veces"
    		});
    	});
  
    
});

function makeTagFilters(){
	 $('span[id^="tagCloud_word"]').each(function() {
	    	$(this).addClass('tag-filter');
	    	$(this).attr('data-filter', '.'+$(this).text() );
	    });
	    
	    $('.tag-filter').click(function(){
	  	  var selector = $(this).attr('data-filter');
	  	  	$('#news').isotope({ filter: selector });
	      });
}