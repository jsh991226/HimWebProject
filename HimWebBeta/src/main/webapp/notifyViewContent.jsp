<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="egovframework.user.service.UserVO" %>
<%@ page import="egovframework.notify.service.NotifyVO" %>
<%

String useridc = "";
String nicknamec = "";
UserVO userVOc;


if (session.getAttribute("userVO") == null) {
	
}else {
	userVOc = (UserVO)session.getAttribute("userVO");
	useridc = userVOc.getUserid();
	nicknamec = userVOc.getNickname();
}

String title = "";
String owner = "";
String content = "";
String regdate = "";
int id = -1;
NotifyVO notifyVO;

if (session.getAttribute("NotifyVO") == null) {
	
}else {
	notifyVO = (NotifyVO)session.getAttribute("NotifyVO");
	title = notifyVO.getTitle();
	owner = notifyVO.getOwner();
	content = notifyVO.getContent();
	regdate = notifyVO.getRegdate();
	id = notifyVO.getId();

}

%>

<script>
$(function(){
	refreshReply();
	
});


function showReReply(cardTarget, replyId){
	$(".rereplyForm").remove();
	$("#replyNum_"+cardTarget).after('<form class="comment_list_one rereplyForm"action="/reply/addReply.do" target="_self" accept-charset="utf-8"><div class="comment_box"><input type="hidden" name="owner" value="<%=nicknamec%>" /><input type="hidden" name="replygroup" value="'+replyId+'" /><input type="hidden" name="boardid" value="<%=id%>" /><textarea name ="content" cols="30" rows="10" class="txar"></textarea>    </div><div class="btnlist"><input class="regcancel_button"type="submit" value="등록" /><input class="regcancel_button"type="button" value="취소" onClick="removeRereply()"/></div></form>');
	
}
function removeRereply(){
	$(".rereplyForm").remove();
}

function refreshReply(){
	$.ajax({
		type:"POST",
		url:"/reply/getReplyList.do?boardid=<%=id%>",
		dataType:"json",
		success:function(data){
			console.log(data);
			$(".comment_list").empty();
			var i = 0;
			$(data).each(function(){
				if (this.replygroup == "0"){
					$(".comment_list").append(
					'<div class="comment_list_two replyTarget_'+this.id+'" id="replyNum_'+i+'"><div class="comment_top_info"><div class="cmt_info_face"><img class="cmt_info_faceimg" src="images/face.png"></div><div class="cmt_info_name"><p class="cmt_info_name1">'+this.owner+'</p></div><div class="cmt_info_date"><p class="cmt_info_date1">['+this.regdate+']</p></div></div><div class="comment_bottom_info"><div class="cmt_content"> <textarea name ="comment_textarea" class="reply_textarea" readonly>'+this.content+'</textarea></div><div class="reply_button2"><input class="reply_btn"type="button" onClick="showReReply('+i+','+this.id+');"id="reply_'+this.id+'"value="답글"/></div></div></div>'		
					);
				} else{
					$(".replyTarget_"+this.replygroup).after(
					'<div class="testbox"><p class="reply_giho">┗</p></div><form class="reply_comment_list_one"><div class="reply_comment_top_info"><div class="reply_cmt_info_face"><img class="reply_cmt_info_faceimg" src="images/face.png"></div><div class="reply_cmt_info_name"><p class="reply_cmt_info_name1">'+this.owner+'</p></div><div class="reply_cmt_info_date"><p class="reply_cmt_info_date1">['+this.regdate+']</p></div></div><div class="reply_comment_bottom_info"><div class="reply_cmt_content"><textarea name ="comment_textarea" class="reply_textarea2" readonly>'+this.content+'</textarea></div><div class="reply_button"></div></div></form>'
					);
					
					
				}
				i++;
			});
			
		},
		error:function(request, status, error){

			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);

		}
		
	});
	
	
}


</script>

<div class="board_wrap">
        <div class="board_wrap2">
            <div class="board_title">
                <img class="HIM2" src="images/board.png">
                <span class="rank">공지사항</span>
            </div>
            <div class="board_write_wrap">
                <div class="board_write">
                    <div class="title">
                        <dl>
                            <dt>제목</dt>
                            <dd><input type="text" value = "<%=title%>" readonly /></dd>
                        </dl>
                    </div>
                    <div class="info">
                        <dl>
                            <dt>닉네임</dt>
                            <dd><input type="text" value = "<%=owner%>" readonly/></dd>
                        </dl>
                    </div>
                    <div class="cont">
                        <textarea class="main_content_comment" readonly><%=content%></textarea>
                    </div>
                </div>

            </div>
        </div>
        <div class="comment">
            <div class="comment_list">
                <!-- 댓글 들어갈 곳 -->

                
            </div>
            <form class="bottom_txar" action="/reply/addReply.do" target="_self" accept-charset="utf-8">
            	<%if (nicknamec.equals("")) {%>
                <textarea name ="comment_textarea" cols="30" rows="10" class="txar" placeholder="로그인 후, 이용해주세요" readonly="readonly"></textarea>
                <div class="bottom_txar_btn">
                    <div class="txar_right_btn">
                            (0/200)
                        <input class="btn01_g"type="button" value="등록"/>
                    </div>
                </div>
                <%}else{ %>
                <input type="hidden" name="owner" value="<%=nicknamec %>" />
                <input type="hidden" name="boardid" value="<%=id%>" />
                <textarea name ="content" cols="30" rows="10" class="txar" placeholder="댓글 내용을 작성해주세요"></textarea>
                <div class="bottom_txar_btn">
                    <div class="txar_right_btn">
                            (0/200)
                        <input class="btn01_g"type="submit" value="등록"/>
                    </div>
                </div>                
                <%} %>
            </form>
        </div>
        <div class="bt_wrap">
            <a onClick="location.href='/notify/GetAllList.do'" class="on">목록</a>
        </div>
    </div>