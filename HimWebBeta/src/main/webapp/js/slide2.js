var obTimeOut;
var ObjectArray = new Array ();
ObjectArray[1] = "banner.png";
ObjectArray[2] = "banner2.png";
ObjectArray[3] = "banner3.png";
var nObjectCnt = 0;	
function ShowDefaultRotate()
{
	nObjectCnt++;
	if( nObjectCnt < ObjectArray.length )
	{
		document.getElementById("slideImg").src = "images/" + ObjectArray[nObjectCnt];		 
    if (nObjectCnt == ObjectArray.length-1) nObjectCnt = 0;
		obTimeOut = setTimeout("ShowDefaultRotate()",2000);
	}
	else
	{
    clearTimeout(obTimeOut);
	}		
}

function SetRotate(idx){
  if (idx > ObjectArray.length) return;
  document.getElementById("slideImg").src = "images/" + ObjectArray[idx];		 
  nObjectCnt = idx;
}

function MoveRotate(num){
  if (nObjectCnt+num >= ObjectArray.length) nObjectCnt = 0;
  if (nObjectCnt+num < 1) nObjectCnt = ObjectArray.length-1;
  nObjectCnt+=num;
  console.log("cnt : " + nObjectCnt);
  document.getElementById("slideImg").src = "images/" + ObjectArray[nObjectCnt];		 


}



function startAnimation()
{
  obTimeOut = window.setTimeout(ShowDefaultRotate,100);
}

$(function(){
  startAnimation();


});