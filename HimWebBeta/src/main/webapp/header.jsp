<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="egovframework.user.service.UserVO" %>
<%

String userid = " ";
String nickname = "";
UserVO userVO;


if (session.getAttribute("userVO") == null) {
	
}else {
	userVO = (UserVO)session.getAttribute("userVO");
	userid = userVO.getUserid();
	nickname = userVO.getNickname();
}

%>

	<head>
	    <title>HIM</title>
	    <link rel="stylesheet" href="/css/header.css" type="text/css">
	    <link rel="stylesheet" href="/css/footer.css" type="text/css">
	    <link rel="stylesheet" href="/css/shop.css" type="text/css">
	    <link rel="stylesheet" href="/css/modal.css" type="text/css">
	    <link rel="stylesheet" href="/css/mypage.css" type="text/css">
        <link rel="stylesheet" href="/css/login.css" type="text/css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.css">
		<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.js"></script>
	    <!-- Google Font -->
	    <link href="https://fonts.googleapis.com/earlyaccess/notosanskr.css" rel="stylesheet">
	    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
	    <script src="/js/index.js"> </script>
	    <script src="/js/auth.js"> </script>
	    <script src="/js/slide.js"> </script>
	</head>
	
	<script>

	
	</script>

	

     <header>
         <div class="head">
             <div class="inner">
                 <img class="logo" src="images/HIM3.png" onClick="location.href='index.jsp'">
             </div>
             <div class="nav">
                 <ul class="menu_list">
                     <li class="menu" onClick="location.href='index.jsp'">홈</li>
                     <li class="menu">커뮤니티</li>
                     <li class="menu" onClick="location.href='/shop/ShopList.do'">상점</li>
                     <li class="menu" onClick="location.href='/user/Rank.do'">랭킹</li>
                     <li class="menu" onClick="location.href='mypage.jsp'">마이페이지</li>
                     <li class="menu" onClick="location.href='download.jsp'">다운로드</li>
                 </ul>
             </div>
             <div class="right-con">
                 <%if (session.getAttribute("userVO") != null) {%>
                 	<div class="login_out">
                 		<div class="logout">
                 			<img src="images/logout2.png" onClick="location.href='/user/logout.do'">
                 		</div>
                 	</div>
		<%}else {%>
                 	<div class="login_out">
                 		<div class="login">
                 			<img src="images/login4.png" onClick="showModal('login')">
                 		</div>
                 	</div>
		<%} %>
                 
             </div>
         </div>
	</header>
    