<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="egovframework.user.service.UserVO" %>
<%

String userid = "";
String nickname = "";
UserVO userVO;


if (session.getAttribute("userVO") == null) {
	
}else {
	userVO = (UserVO)session.getAttribute("userVO");
	userid = userVO.getUserid();
	nickname = userVO.getNickname();
}

%>
    
    <script>
    $(document).ready(function(){
		$(".itemimg").attr("src", "images/ShopItem/"+ClickedItemdataname+"_Shop.png");
		$(".item_name").text(ClickedName);
		$(".product_info").text(ClickedCost+"원");
		$(".item_spacing").text($("#descLine_"+ClickedId).val());
		

    	
    });
    
    function BuyItem(){
    	var _nick = "<%=userid%>";
    	if (_nick === "") {
    		alert("[알림]로그인 후 이용할 수 있습니다");
    		return;
    	}else {
    		$.ajax({
    			type:"POST",
    			url:"/user/getUserMoney.do",
    			data :{id : _nick, itemId : ClickedId, itemCost : ClickedCost, itemData : ClickedItemdataname},
    			dataType:"json",
    			success:function(data){
    				if (data == "1") {
    					alert("[알림] "+ClickedName+"을(를) 구매 하였습니다!");
    				}else{
    					alert("[알림] 잔액이 부족합니다.");
    				}

    			},
    			error:function(request, status, error){

    				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);

    			}
    			
    		});    		
    		
    	}
    	

    	
    }

	
    </script>

    
    <div class="entire_wrap">
        <div class="entire">
            <div class="item_img">
                <img class="itemimg" src="images/weapon3.png">
            </div>
            <div class="item_info"> 
                <div class="item_price">아이템 구매하기</div>
                <div class="item_name">메두사의,,,머시기한머리카락</div>
                <div class="item_exp">
                    <textarea readonly class="item_spacing"></textarea>
                </div>

                <div class="product_info_wrap">
                    <h4 class="info_title">정보</h4>
                    <div class="detail_product_wrap">
                        <dl class="detail_product">

                            <div class="detail_box">
                                <dt class="product_title">가격</dt>
                                <dd class="product_info">135</dd>
                            </div>
                        </dl>
                    </div>
                    <div class="btn-area inShop">
                        <button class="inShop" type="submit" onClick="BuyItem()">즉시 구매하기</button>
                    </div>
                </div>
            </div>
        </div>
    </div>