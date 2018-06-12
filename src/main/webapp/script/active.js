//coloring active links - client

$(document).ready(function(){
	var category = document.querySelector('.categ').getAttribute('href');//when in /common/listprogramscategory - haven't link in menu
	var program = document.querySelector('.prog').getAttribute('href');//when in /common/findprog - haven't link in menu
	var programs = document.querySelector('.programs');//must be coloring

	var newss = document.querySelector('.new').getAttribute('href');//when in /common/news/id - haven't link in menu
	var newses = document.querySelector('.news');//must be coloring
	
	//length of href
    var categoryLength = category.length;
    var programLength = program.length;
    var newssLength = newss.length;
	
	//coloring active links - have in menu
	$('.activelink > a').each(function () {
        var location = window.location.pathname; //href - all link
        var link = this.pathname;//href - all link

        if(location == link) {
            $(this).addClass('active');
        }
       //coloring link 'program' when in categories
        if(location.substring(0, categoryLength) == category) {
        	programs.classList.add('active');
        }
      //coloring link 'program' when in details program
        if(location.substring(0, programLength) == program) {
        	programs.classList.add('active');
        }
      //coloring link 'news' when in details news
        if(location.substring(0, newssLength) == newss) {
        	newses.classList.add('active');
        }
        
	});
});
