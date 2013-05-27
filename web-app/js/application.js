$(function(){

	 $('#news').isotope({
        itemSelector: '.element'
      });
      
      
      $('.btn-filter').click(function(){
    	  var selector = $(this).attr('data-filter');
    	  $('#news').isotope({ filter: selector });

        });

          // When DOM is ready, select the container element and call the jQCloud method, passing the array of words as the first argument.
       $("#tagCloud").jQCloud(word_array);
     
    });