<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게임 설치</title>
    <link rel="stylesheet" href="css/gamedownload.css" type="text/css">
    <link rel="stylesheet" href="css/footer.css" type="text/css">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <!-- <script src="./js/slide2.js"></script> -->
    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/earlyaccess/notosanskr.css" rel="stylesheet">
</head>
<script>

function ShowMob(_name){
	document.getElementById('BigIcon').src = "images/"+_name+"_Icon.png";
	document.getElementById('StatIcon').src = "images/Stat_"+_name+".png";
	
}



</script>



<body>
    <div class="gamedownload_wrap">
        <div class="gamedownload_img">
            <div class="titleBox">
                <img class="gamedownload_logoimg" src="images/HIM3.png">
                <div class="titlebox_title">안녕? 나는 몬스터야 :D</div>
                <div class="titlebox_title2">타르코프 라이크 - 무료 플레이</div>
                <div class="download_button">지금 플레이</div>
            </div>
            <div class="logobox">
                <img class="title_logo" src="images/logo1.png">
                <img class="title_logo" src="images/logo2.png">
                <img class="title_logo" src="images/logo3.png">
                <img class="title_logo" src="images/logo4.png">
            </div>
        </div>
       
        <div class="game_guide">
        	<div class="game_guide_wrap">
	            <div class="game_guide_content">
	                <div class="game_guide_bigtitle">뒤바뀐 세계관</div>
	                <div class="game_guide_smalltitle">
	                    <p>마을을 지키는 용사가 아닌, 마을을 파괴하고
						약탈하는 몬스터가 되어 선량한 시민을 살해하고
						물건을 약탈하세요!
						</p>
	                </div>
	            </div>
                <img class="game_guide_img" src="images/banner4.png">
	        </div>
        </div>
        <div class="game_event">
            <div class="game_event_bg">
            	<div class="game_event_wrap">
	                <div class="event_img">
	                    <img class="game_event_img" src="images/banner.png">
	                </div>
	                <div class="game_event_content">
	                    <div class="game_event_bigtitle">개발진 </div>
	                    <div class="game_event_smalltitle">	
	                        <p>HIM은 영진전문대학교 컴퓨터 정보계열의
							졸업 작품전 용도로 개발 되었습니다</p>
								<div class="gamemaker_name">
								개발 총괄 - 주승환
								<br>
								게임 개발 - 권성우, 이유진
								<br>
								웹 개발 - 김수용	
								</div>				
	                    </div>
	                    <div class="gameplay_button1">홈페이지</div>
	                </div>
                </div>
            </div>
        </div>
        <div class="game_issue">
            <div class="game_issue_wrap">
                <div class="game_issue_bigtitle">이야기는 스토리모드에서 계속됩니다</div>
                <div class="game_issue_smalltitle">원래 이 게임은 스토리와 시나리오가 매우 많은 게임입니다
				하지만 유저들의 플레이 시간과 발표 시간의 한계로
				시나리오를 많이 줄여 여러명이 플레이 할 수 있게 개발 되었습니다
				조금 더 세부적인 시나리오와 스토리를 겪으며 다양한 결과를 볼 수 있게
				시나리오 모드를 출시 할 예정입니다
				</div>
            </div> 
            <div class="game_image_wrap">
                 <img class="himchar_img" src="images/himchar.png">
            </div>
        </div>
        <div class="game_map">
            <img class="game_map_bg" src="images/banner6.png">
            <div class="game_map_title">
                <div class="game_big_title">종족</div>
                <div class="game_small_title">종족별로 다양한 능력치가 존재합니다! 원하는 종족을 선택해 시민을 좀더 효율적으로 살해하세요!</div>
            </div>
            <div class="game_map_icon">
                <div class="game_mapicon1" onClick="ShowMob('Ork')">
                    <img class="game_monster" src="images/Ork_Icon.png">	
                    <div class="game_mapcontent1">오크</div>
                </div>
                <div class="game_mapicon1" onClick="ShowMob('Golem')">
                	<img class="game_monster" src="images/Golem_Icon.png">	
                    <div class="game_mapcontent1">골렘</div>
                </div>
                <div class="game_mapicon1" onClick="ShowMob('Goblin')">
                	<img class="game_monster" src="images/Goblin_Icon.png">
                    <div class="game_mapcontent1">고블린</div>
                </div>
                <div class="game_mapicon1" onClick="ShowMob('Skeleton')">
                	<img class="game_monster" src="images/Skeleton_Icon.png">
                    <div class="game_mapcontent1">스켈레톤</div>
                </div>
                 <div class="game_mapicon1" onClick="ShowMob('Ogre')">
                 	<img class="game_monster" src="images/Ogre_Icon.png">
                    <div class="game_mapcontent1">오우거</div>
                </div>  
            </div>
            <div class="game_map_img">
                <div class="game_map_bannerslide">
	                <div class="game_map_banner_wrap">
	                    <img class="game_map_banner" id="BigIcon" src="images/Ork_Icon.png">
	                </div> 
	                <div class="game_map_banner_wrap2">
	                	<img class="game_map_banner2" id="StatIcon" src="images/Stat_Ork.png">
	                </div>                    
                </div>

            </div>
        </div>
    </div>
</body>


</html>
