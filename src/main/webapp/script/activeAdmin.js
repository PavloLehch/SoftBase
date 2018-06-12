//coloring active links - admin mode

$(document).ready(function(){

	$('.activelink > a').each(function () {
        var location = window.location.href;
        var link = this.href;
        if(location == link) {
            $(this).addClass('active');
        }
        
	});
});
