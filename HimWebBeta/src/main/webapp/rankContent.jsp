<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="egovframework.user.service.UserVO" %>

<%
int idx = 0;

List<UserVO> rankList = null;
if (session.getAttribute("RankList") != null) {
   rankList = (List<UserVO>)session.getAttribute("RankList");
}



%>



        <div class="content">
            <div class="search">
                <img class="HIM2" src="/images/rank.png">
                <span class="rank">랭킹</span>
            </div>
            <div class="rank_info">
                <div class="top_info">
                    <ul class="side2">
                        <li>순위</li>
                        <li>캐릭터 정보</li>
                        <li class="money_and_clear1"><a href="">보유 금액</a></li>
                        <li class="money_and_clear2"><a href="">탈출 횟수</a></li>
                    </ul>
                </div>
                <div class="bottom_info">
                   <% 
               for (UserVO e : rankList) {
                  idx++;
                  %>
                       <div class="ranker">
                           <div class="user_info">
                               <div class="rank_wrap">
                                  <%if (idx <= 3) {%>
                                      <img class="gold" src="/images/rank<%=idx %>.png">
                                   <%}else {%>
                                      <p class="rankAnother"><%=idx %></p>
                                   <%} %>
                               </div>
                               <div class="facewrap">
                                  <img class="face" src="/images/face.png">
                               </div>
                               <span class="name"><%=e.getNickname() %>
                                   <br>
                                   <h3><%=e.getUserclass() %></h3>
                               </span>
                               <div class="money"><%=e.getMoney() %>원</div>
                           </div>
                       </div>
                  
                  
                  
               <%
               }
               %>   
                    
                    
                    
                 
            </div>
            <div class="slide_bar" style="display:none">
                <span class="button-prev">
                    <a><img src="https://ssl.nexon.com/s2/game/maplestory/renewal/common/cm_prev.png" alt="이전"></a>
                </span>
                <a class="active">1</a>
                <a class="active">2</a>
                <a class="active">3</a>
                <a class="active">4</a>
                <a class="active">5</a>
                <span class="button-next">
                    <a><img src="https://ssl.nexon.com/s2/game/maplestory/renewal/common/cm_next.png" alt="다음"></a>
                </span>
            </div>
        </div>
        
    </div>

    