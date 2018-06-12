$(function () {
    var textShort = $(".textAreaShot");
    var countShort = $(".counter1");

    textShort.on("input", function () {
        var lengthShort = textShort.val().length;
        countShort.html(lengthShort);
        
        if (lengthShort >=254) {
        	 textShort.val (textShort.val().substring(0,254));
 
        }
        
    });
    
    var textTitle = $(".textTitle");
    var countTitle = $(".counter2");

    textTitle.on("input", function () {
        var lengthTitle = textTitle.val().length;
        countTitle.html(lengthTitle);
        
        if (lengthTitle >=254) {
       	 textTitle.val (textTitle.val().substring(0,254));

       }
    });

});