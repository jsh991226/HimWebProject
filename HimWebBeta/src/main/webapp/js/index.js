function showModal(target, val1, val2, val3, val4){
	$("#modalBg").css("display", "block");
	if (target == "login"){
		$("#modal").load("login.jsp");
	}
	if (target == "join"){
		$("#modal").load("join.jsp");
	}
	if (target == "shopInfo"){
		$("#modal").load("shopInfo.jsp?id=3");
		ClickedId = val1;
		ClickedName = val2;
		ClickedCost = val3;
		ClickedItemdataname = val4;
	}
	
}


$(document).keydown(function(event) {
    if ( event.keyCode == 27 || event.which == 27 ) {
        if ($("#modalBg").css("display") == "block"){
        	$("#modalBg").css("display", "none");
        }
    }
    
    
});

$(document).ready(function(){


	
	
});

