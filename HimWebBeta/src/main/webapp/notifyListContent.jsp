<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="egovframework.user.service.UserVO" %>
<%@ page import="egovframework.notify.service.NotifyVO" %>

<%
int idx = 0;

List<NotifyVO> notifyList = null;
if (session.getAttribute("notifyList") != null) {
	notifyList = (List<NotifyVO>)session.getAttribute("notifyList");
}

String useridc = "";
String nicknamec = "";
UserVO userVOc;


if (session.getAttribute("userVO") == null) {
	
}else {
	userVOc = (UserVO)session.getAttribute("userVO");
	useridc = userVOc.getUserid();
	nicknamec = userVOc.getNickname();
}




%>
<script>

function viewNotify(id){
	location.href = "/notify/selectNotify.do?notifyID=" + id;
	
	
}


</script>



		<div class="post_content">
            <div class="post_search">
                <img class="HIM2" src="images/board.png">
                <span class="post_rank">공지사항</span>
            </div>

            
        <div class="post_rank_info">
            <div class="post_top_info">
                <div class="post_title_big">
                    제목
                </div>
                <div class="post_user_big">
                    작성자
                </div>
                <div class="psot_reg_big">
                    등록일
                </div>
            </div>
            <div class="post_bottom_info">

               <% 
               for (NotifyVO e : notifyList) {
                  idx++;
                %>
                <div class="post1" onClick="viewNotify('<%=e.getId() %>')">
                    <div class="post_title"><%=e.getTitle() %></div>
                    <div class="post_name"><%=e.getOwner() %></div>
                    <div class="post_reg"><%=e.getRegdate() %></div>
                </div>                  
                  
                <%} %>
                

            </div>
            <div class="slide_bar">
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
            <%-- <%if (!nicknamec.equals("")){%>
            <div class="bt_wrap">
            	<a href="notify.jsp" class="on">글쓰기</a>
        	</div>
        	<%} %> --%>
        	<div class="bt_wrap">
            	<a href="notify.jsp" class="on">글쓰기</a>
        	</div>
            
        </div>