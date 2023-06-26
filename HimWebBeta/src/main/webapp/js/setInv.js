function setInvList(){
		$(function(){
			$.ajax({
				type:"POST",
				url:"/itemdata/itemDataNameList.do?userid=" + $("#myPage_Userid").text(),
				dataType:"json",
				success:function(data){
					var i = 0;
					$(data).each(function(){
						$("#card_"+i).html('<img class="myp_weapon_img" src="images/ShopItem/'+data[i]+'_Shop.png">');
						i++;
					});
					
				},
				error:function(request, status, error){

					alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);

				}
				
			});
		});
		



}