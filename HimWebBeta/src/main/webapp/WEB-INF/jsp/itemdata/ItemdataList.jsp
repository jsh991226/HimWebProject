<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : ItemdataList.jsp
  * @Description : Itemdata List 화면
  * @Modification Information
  * 
  * @author coc
  * @since 20230614
  * @version 1.0
  * @see
  *  
  * Copyright (C) All right reserved.
  */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>목록</title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>
<script type="text/javaScript" language="javascript" defer="defer">
<!--
/* 글 수정 화면 function */


function fn_egov_select(id) {
    document.getElementById("listForm").id.value = id;
   	document.getElementById("listForm").action = "<c:url value='/itemdata/updateItemdataView.do'/>";
   	document.getElementById("listForm").submit();
}

/* 글 등록 화면 function */
function fn_egov_addView() {
   	document.getElementById("listForm").action = "<c:url value='/itemdata/addItemdataView.do'/>";
   	document.getElementById("listForm").submit();		
}

/* pagination 페이지 링크 function */
function fn_egov_link_page(pageNo){
	document.getElementById("listForm").pageIndex.value = pageNo;
	document.getElementById("listForm").action = "<c:url value='/itemdata/ItemdataList.do'/>";
   	document.getElementById("listForm").submit();
}

 // -->
</script>
</head>
<body>
<form:form commandName="searchVO" name="listForm" id="listForm" method="post">
    <input type="hidden" name="id" />
<div id="content_pop">
	<!-- 타이틀 -->
	<div id="title">
		<ul>
			<li><img src="<c:url value='/images/egovframework/example/title_dot.gif'/>" alt="title" /> List </li>
		</ul>
	</div>
	<!-- // 타이틀 -->
	<!-- List -->
	<div id="table">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<colgroup>
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
								<col/>				
							</colgroup>		  
			<tr>
								<th align="center">Id</th>
								<th align="center">Sprite</th>
								<th align="center">Positionx</th>
								<th align="center">Positiony</th>
								<th align="center">Width</th>
								<th align="center">Height</th>
								<th align="center">Ispartofshape</th>
								<th align="center">Candrop</th>
								<th align="center">Durability</th>
								<th align="center">Area</th>
								<th align="center">Code</th>
								<th align="center">Itemprefabname</th>
								<th align="center">Ownerid</th>
							</tr>
			<c:forEach var="result" items="${resultList}" varStatus="status">
			<tr>
		 				<td align="center" class="listtd"><a href="javascript:fn_egov_select('<c:out value="${result.id}"/>')"><c:out value="${result.id}"/></a>&nbsp;</td>
								<td align="center" class="listtd"><c:out value="${result.sprite}"/>&nbsp;</td>
								<td align="center" class="listtd"><c:out value="${result.positionx}"/>&nbsp;</td>
								<td align="center" class="listtd"><c:out value="${result.positiony}"/>&nbsp;</td>
								<td align="center" class="listtd"><c:out value="${result.width}"/>&nbsp;</td>
								<td align="center" class="listtd"><c:out value="${result.height}"/>&nbsp;</td>
								<td align="center" class="listtd"><c:out value="${result.ispartofshape}"/>&nbsp;</td>
								<td align="center" class="listtd"><c:out value="${result.candrop}"/>&nbsp;</td>
								<td align="center" class="listtd"><c:out value="${result.durability}"/>&nbsp;</td>
								<td align="center" class="listtd"><c:out value="${result.area}"/>&nbsp;</td>
								<td align="center" class="listtd"><c:out value="${result.code}"/>&nbsp;</td>
								<td align="center" class="listtd"><c:out value="${result.itemprefabname}"/>&nbsp;</td>
								<td align="center" class="listtd"><c:out value="${result.ownerid}"/>&nbsp;</td>
									</tr>
			</c:forEach>
		</table>
	</div>
	<!-- /List -->
	<div id="paging">
		<ui:pagination paginationInfo = "${paginationInfo}"
				   type="image"
				   jsFunction="fn_egov_link_page"
				   />
		<form:hidden path="pageIndex" />
	</div>
	<div id="sysbtn1">
		<ul>
			<li>
				<div id="sysbtn">
					<span class="btn_blue_l"><a href="javascript:fn_egov_addView();">등록</a><img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>" alt="" />
					</span>
				</div>
			</li>
		</ul>
	</div>
</div>
</form:form>
</body>
</html>
