$(function(){

	 $('#news').isotope({
        itemSelector: '.element'
      });
      
      
      $('.btn-filter').click(function(){
    	  var selector = $(this).attr('data-filter');
    	  $('#news').isotope({ filter: selector });

        });


    $("#tagCloud").jQCloud(word_array);
    
      
});