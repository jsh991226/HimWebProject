<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="egovframework.user.service.UserVO" %>
<%@ page import="egovframework.notify.service.NotifyVO" %>

<%

String useridc = "";
String nicknamec = "";
String regdatec = "";
String emailc = "";
String userclassc = "";
int moneyc =  0 ;
int comexitc =  0 ;
int killhumanc =  0 ;
int deathc =  0 ;
UserVO userVOc;


if (session.getAttribute("userVO") == null) {
	
}else {
	userVOc = (UserVO)session.getAttribute("userVO");
	useridc = userVOc.getUserid();
	nicknamec = userVOc.getNickname();
	regdatec = userVOc.getRegdate();
	emailc = userVOc.getEmail();
	userclassc = userVOc.getUserclass();
	moneyc = userVOc.getMoney();
	comexitc = userVOc.getComexit();
	killhumanc = userVOc.getKillhuman();
	deathc = userVOc.getDeath();
}
%>
<script>
function chk_form() {
	if(document.getElementById("boardTitle").value==''){
		alert("[경고] 제목을 입력해주세요.");
		return false;
	}
	if(document.getElementById("boardContent").value==''){
		alert("[경고] 내용을 입력해주세요.");
		return false;
	}
	
	
	document.getElementById('boardAction').submit();
}


</script>


        <div class="board_wrap2">
            <div class="board_title">
                <img class="HIM2" src="images/board.png">
                <span class="rank">공지사항</span>
            </div>
            <div class="board_write_wrap">
                <div class="board_write">
                <form id="boardAction" action="/notify/addNotify.do" target="_self" accept-charset="utf-8">
                   <div class="title">
                        <dl>
                            <dt>제목</dt>
                            <dd><input type="text" name="title" id="boardTitle" placeholder="제목을 입력하세요"></dd>
                        </dl>
                    </div>
                    <div class="info">
                        <dl>
                            <dt>닉네임</dt>
                            <dd><input type="text" name="owner" value="<%=nicknamec%>" readonly></dd>
                        </dl>
                    </div>
                    <div class="cont">
                        <textarea name="content" id="boardContent" placeholder="내용을 입력하세요"></textarea>
                    </div>
                </div>
                <div class="bt_wrap">
                    <a class="on" onclick="return chk_form()" >등록</a>
                    <a href="javascript:history.back();">취소</a>
                </div>
                </form>
            </div>
        </div>