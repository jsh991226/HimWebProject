function ActionLogin(){
		$(function(){
		
			$.ajax({
				type:"POST",
				url:"/user/checkUserLoginAjax.do?userid=" + $('.loginUserID').val() + "&userpw=" + $('.loginUserPW').val(),
				dataType:"text",
				success:function(data){
					console.log(data);
					if ( data == "1") {
					    alert("[알림] 로그인 성공");
						location.href = "./index.jsp";
					}else{
					    alert("[알림] 회원정보가 일치하지 않습니다");
					}
					
				},
				error:function(request, status, error){

					alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);

				}
				
			});
		});
		



}