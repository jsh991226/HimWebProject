<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="egovframework.user.service.UserVO" %>

<%

String useridc = " ";
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
setInvList();
</script>

	<div class="mypage_wrap">
		<!-- <div class="myp_topcontent">
			<div class="name_bar">
				<p class="myp_nickname">내 정보</p>
			</div>
		</div> -->
		<div class="myp_bottomcontent">
			<div class="myp_info">
				<div class="myp_user_info">
					<div class="myp_user_face">
						<img class="user_faceimg" src="images/<%=userclassc%>_Icon.png">
					</div>
				</div>
				<div class="myp_user_reg">
					<div class="reg_user_info">
						<p class="dbwjwjdqh">유저 정보</p>
					</div>
					<div class="reg_user_reg">
						<div class="myp_class1"><p class="myp_class_p">닉네임</p></div>
						<div class="myp_class2"><p class="myp_class_p2"><%=nicknamec %></p></div>
						<div class="myp_class1"><p class="myp_class_p">아이디</p></div>
						<div class="myp_class2"><p class="myp_class_p2" id="myPage_Userid"><%=useridc %></p></div>
						<div class="myp_class1"><p class="myp_class_p">종족</p></div>
						<div class="myp_class2"><p class="myp_class_p2"><%=userclassc%></p></div>
						<div class="myp_class1"><p class="myp_class_p">생성 일자</p></div>
						<div class="myp_class2"><p class="myp_class_p2"><%=regdatec %></p></div>
						<div class="myp_class1"><p class="myp_class_p">이메일</p></div>
						<div class="myp_class2"><p class="myp_class_p2"><%=emailc%></p></div>
					</div>
					<div class="myp_user_rank">
						<div class="myp_moneyrank">
							<img class="money_exit_rankimg" src="images/rank3.png">
							<div class="exit_p">Exit</div>
							<div class="rank_p">3rd</div>
						</div>
						<div class="myp_exitrank">
							<img class="money_exit_rankimg" src="images/rank2.png">
							<div class="exit_p">Money</div>
							<div class="rank_p">2nd</div>
						</div>
					</div>
				</div>
			</div>
			<div class="myp_achieve">
				<div class="reg_user_inventory">
					<p class="dbwjwjdqh">내 기록</p>
				</div>
				<div class="reg_user_reg2">
					<div class="myp_class3"><p class="myp_class_p">보유 머니</p></div>
					<div class="myp_class4"><p class="myp_class_p2"><%=moneyc %>원</p></div>
					<div class="myp_class3"><p class="myp_class_p">탈출 횟수</p></div>
					<div class="myp_class4"><p class="myp_class_p2"><%=comexitc %>회</p></div>
					<div class="myp_class3"><p class="myp_class_p">K/D</p></div>
					<div class="myp_class4"><p class="myp_class_p2"><%=killhumanc %>킬 <%=deathc %>데스</p></div>
				</div>
				<div class="reg_user_inventory">
					<p class="dbwjwjdqh">인벤토리</p>
				</div>
				<div class="myp_product_card">
					<div class="myp_product_img" id="card_0">
					</div>
					<div class="myp_product_img" id="card_1">
					</div>
					<div class="myp_product_img" id="card_2">
					</div>
					<div class="myp_product_img" id="card_3">
					</div>
					<div class="myp_product_img" id="card_4">
					</div>
					<div class="myp_product_img" id="card_5">
					</div>
					<div class="myp_product_img" id="card_6">
						
					</div>
					<div class="myp_product_img" id="card_7">
						
					</div>
					<div class="myp_product_img" id="card_8">
						
					</div>
					<div class="myp_product_img" id="card_9">
						
					</div>
					<div class="myp_product_img" id="card_10">
						
					</div>
					<div class="myp_product_img" id="card_11">
						
					</div>
					<div class="myp_product_img" id="card_12">
						
					</div>
					<div class="myp_product_img" id="card_13">
						
					</div>
					<div class="myp_product_img" id="card_14">
						
					</div>
					<div class="myp_product_img" id="card_15">
						
					</div>
				

				</div>
			</div>
		</div>
	</div>