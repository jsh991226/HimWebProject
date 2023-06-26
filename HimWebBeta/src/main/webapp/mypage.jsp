<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="egovframework.user.service.UserVO" %>


<%-- <%

String useridc = " ";
String nicknamec = "";
String regdatec = "";
String emailc = "";
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
	emailc = userVOc.getRegdate();
	moneyc = userVOc.getMoney();
	comexitc = userVOc.getComexit();
	killhumanc = userVOc.getKillhuman();
	deathc = userVOc.getDeath();
}

%> --%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="/js/setInv.js"> </script>
    <script>
    if("check_1" == "check_"){
    	alert("[알림] 로그인 후 이용할 수 있습니다.");
    	window.history.back();
    	
    }
    
    
    </script>

</head>



<body>
	<div id="modalBg">
 		<div id="modal">
 		</div>	
	</div>
	

	<div id="wrap">
		<%@ include file="/header.jsp" %>
		<%@ include file="/mypageContent.jsp" %>
		<%@ include file="/footer.jsp" %>
    </div>

	
</body>




</html>