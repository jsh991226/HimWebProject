<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   
   
<script>

function viewNotify(id){
	location.href = "/notify/selectNotify.do?notifyID=" + id;
	
	
}


$(function(){
	$.ajax({
		type:"POST",
		url:"/user/RankTop.do",
		dataType:"json",
		success:function(data){
			console.log(data);
			var i = 0;
			$(data).each(function(){
				$("#rankTopName_"+i).text(this.nickname);
				$("#rankTopMoney_"+i).text(this.money+"원");
				i++
				if (i > 4) return;
			});
			
		},
		error:function(request, status, error){

			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);

		}
		
	});
	$.ajax({
		type:"POST",
		url:"/notify/MainList.do",
		dataType:"json",
		success:function(data){
			$(data).each(function(){
				$(".noticelist").append('<div class="notice" onClick="viewNotify('+this.id+')"><p class="noticecontent">공지</p><div class="noticecontent2">'+this.title+'</div></div>');

			});
			
		},
		error:function(request, status, error){

			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);

		}
		
	});
	

	
});



</script>
   
<div class="content">
   <div class="banner">
      <div class="mySlides-fade">
         <img class="bannerimg" id="slideImg" src="images/banner.png">
      </div>

      <a class="prev" onclick="MoveRotate(-1)">&#10094;</a> <a class="next"
         onclick="MoveRotate(1)">&#10095;</a> <br>
      <div style="text-align: center">
         <span class="dot" onclick="SetRotate(1)"></span> <span class="dot"
            onclick="SetRotate(2)"></span> <span class="dot"
            onclick="SetRotate(3)"></span>
      </div>
   </div>
   <div class="freenotice">
      <div class="rankinglist">
         <div class="top_info">
            <div class="rank">등급</div>
            <div class="name">닉네임</div>
            <div class="reg">기록</div>
         </div>
         <div class="bottom_info">
            <div class="rank_info1">
               <div class="rank_wrap">
                  <img class="rankimg" src="images/rank1.png">
                  <p class="rank123">1</p>
               </div>
               <span class="rank_name" id="rankTopName_0"> 김오크최강
               </span>
               <div class="rank_reg" id="rankTopMoney_0">213200000원</div>
            </div>
            <div class="rank_info1">
               <div class="rank_wrap">
                  <img class="rankimg" src="images/rank2.png">
                  <p class="rank123">2</p>
               </div>
               <span class="rank_name" id="rankTopName_1"> 김오크최강
               </span>
               <div class="rank_reg" id="rankTopMoney_1">213200000원</div>
            </div>
            <div class="rank_info1">
               <div class="rank_wrap">
                  <img class="rankimg" src="images/rank3.png">
                  <p class="rank123">3</p>
               </div>
               <span class="rank_name" id="rankTopName_2"> 김오크최강
               </span>
               <div class="rank_reg" id="rankTopMoney_2">213200000원</div>
            </div>
            <div class="rank_info1">
               <div class="rank_wrap">
                  <img class="rankimg4" src="images/rank1.png">
                  <p class="rank45">4</p>
               </div>
               <span class="rank_name" id="rankTopName_3"> 김오크최강
               </span>
               <div class="rank_reg" id="rankTopMoney_3">213200000원</div>
            </div>
            <div class="rank_info1">
               <div class="rank_wrap">
                  <img class="rankimg4" src="images/rank1.png">
                  <p class="rank45">5</p>
               </div>
               <span class="rank_name" id="rankTopName_4"> 김오크최강
               </span>
               <div class="rank_reg" id="rankTopMoney_4">213200000원</div>
            </div>
         </div>
      </div>
      <div class="noticeboard">
         <div class="notice_title">
            공지사항
            <!-- notifyList.jsp  -->
            <div class="boardbutton"><a href="/notify/GetAllList.do"><img class="board_button" src="images/boardplus2.png"></a></div>
         </div>
         <div class="noticelist">

         </div>
      </div>
   </div>
   <div class="freeboard_wrap">
      <div class="freeboard_title_wrap">
         <div class="freeboard_title1">커뮤니티</div>
         <div class="boardbutton2"><a href="#"><img class="board_button" src="images/boardplus2.png"></a></div>
      </div>
      <div class="freeboard">
         <div class="freeboard1">
            <div class="board_content">
               <img class="userimg" src="images/monster2.png">
            </div>
            <div class="board_writing">
               <p class="writing_content1">
                  <u>스크린샷</u>
               </p>
               <span class="writing_content2">글 제목 입니다.</span>
            </div>
            <div class="user_info">
               <img class="user_img" src="images/pace.png">
               <div class="info_name">반짝검사</div>
            </div>
         </div>
         <div class="freeboard1">
            <div class="board_content">
               <img class="userimg" src="images/monster3.png">
            </div>
            <div class="board_writing">
               <p class="writing_content1">
                  <u>스크린샷</u>
               </p>
               <span class="writing_content2">글 제목 입니다.</span>
            </div>
            <div class="user_info">
               <img class="user_img" src="images/pace.png">
               <div class="info_name">반짝검사</div>
            </div>
         </div>
         <div class="freeboard1">
            <div class="board_content">
               <img class="userimg" src="images/monster4.png">
            </div>
            <div class="board_writing">
               <p class="writing_content1">
                  <u>스크린샷</u>
               </p>
               <span class="writing_content2">글 제목 입니다.</span>
            </div>
            <div class="user_info">
               <img class="user_img" src="images/pace.png">
               <div class="info_name">반짝검사</div>
            </div>
         </div>
         <div class="freeboard1">
            <div class="board_content">
               <img class="userimg" src="images/monster1.png">
            </div>
            <div class="board_writing">
               <p class="writing_content1">
                  <u>스크린샷</u>
               </p>
               <span class="writing_content2">글 제목 입니다.</span>
            </div>
            <div class="user_info">
               <img class="user_img" src="images/pace.png">
               <div class="info_name">반짝검사</div>
            </div>
         </div>
      </div>
   </div>
</div>