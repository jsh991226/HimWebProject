<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="egovframework.shop.service.ShopVO" %>
<%@ page import="java.util.*" %>

<%
int idx = 0;

List<ShopVO> shopList = null;
if (session.getAttribute("shopList") != null) {
   shopList = (List<ShopVO>)session.getAttribute("shopList");
}



%>


<script>
var ClickedId = -1;
var ClickedName = "";
var ClickedCost = "";
var ClickedItemdataname = "";
var ClickedItemDesc = "";



</script>


   
   
      <div class="content">
         <div class="search_content">

                <% 
                if (shopList != null) {
                  for (ShopVO e : shopList) {%>
                     <div class="product_card" onClick="showModal('shopInfo','<%=e.getId()%>','<%=e.getItemname()%>','<%=e.getCost()%>','<%=e.getItemdataname()%>')">
                     <img class="weaponSlot" src="images/ShopItem/<%=e.getItemdataname()%>_Shop.png">
                     <div class="weapon_info">
                        <p class="weapon_name"><%=e.getItemname()%></p>
                        <p class="weapon_price"><%=e.getCost()%>원</p>
                        <hr>
                        <p class="love_product">상세보기 &#128269</p>
                        <input type="hidden" id="descLine_<%=e.getId()%>" value="<%=e.getItemdesc()%>"/>
                     </div>
                  </div>
                     
                     
                     
                  <%}
                   
                }else {
                %>등록된 상품이 없습니다<% 
                   
                }
               %>   
            
            
            
      
         </div>
      </div>