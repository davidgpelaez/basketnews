$(function(){

	 $('#news').isotope({
        itemSelector: '.element'
      });
      
      
      $('.btn-filter').click(function(){
    	  var selector = $(this).attr('data-filter');
    	  $('#news').isotope({ filter: selector });

        });


    $("#tagCloud").jQCloud(word_array,{afterCloudRender: makeTagFilters});
    
    $(".enlaceNoticia").click(function() {
    	$.ajax({
    		  type: "POST",
    		  url: "http://localhost:8080/basketnews/home/count",
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