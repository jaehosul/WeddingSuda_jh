<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<html>
<head>
<meta charset="utf-8">
<title>웨딩수다</title>

<link rel="stylesheet" href="/css/reset.css" type="text/css">
<link rel="stylesheet" href="/css/main.css" type="text/css">
<link rel="stylesheet" href="/css/sub.css" type="text/css">
<link rel="stylesheet" href="/css/sub_detail.css" type="text/css">
<link rel="stylesheet" href="/fonts/NanumBarunGothic.css" type="text/css">
<link rel="stylesheet" type="text/css" href="/css/jquery-ui-1.10.4.custom.css">
<script type="text/javascript" src="/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="/js/document.on.js"></script>
<script type="text/javascript" src="/js/prog.js"></script>
<script language="javascript" src="/js/jquery-ui-1.10.4.custom.js"></script>
<script type="text/javascript" src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
</head>
<body>
<div class="wrap">
<!-- 헤더 너을거임  -->

<jsp:include page="../include/header.jsp">
    <jsp:param name="category" value="product1" />
</jsp:include>

<div class="m_bx_wrap">
     
	<script type="text/javascript" src="/js/jssor.slider.min.js"></script>
	<script type="text/javascript">
        jssor_1_slider_init = function() {            
            var jssor_1_SlideshowTransitions = [
              {$Duration:1200,$Opacity:2}
            ];
            
            var jssor_1_options = {
              $AutoPlay: true,
			  $SlideDuration: 800,			 
              $SlideshowOptions: {
                $Class: $JssorSlideshowRunner$,
                $Transitions: jssor_1_SlideshowTransitions,
                $TransitionsOrder: 1
              },			  

              $ArrowNavigatorOptions: {
                $Class: $JssorArrowNavigator$
              },
              $BulletNavigatorOptions: {
                $Class: $JssorBulletNavigator$
              }
            };
            
            var jssor_1_slider = new $JssorSlider$("jssor_1", jssor_1_options);            
            
            function ScaleSlider() {
                var refSize = jssor_1_slider.$Elmt.parentNode.clientWidth;
                if (refSize) {
                    refSize = Math.min(refSize, 1920);
                    jssor_1_slider.$ScaleWidth(refSize);
                }
                else {
                    window.setTimeout(ScaleSlider, 30);
                }
            }
            ScaleSlider();
            $Jssor$.$AddEvent(window, "load", ScaleSlider);
            $Jssor$.$AddEvent(window, "resize", ScaleSlider);
            $Jssor$.$AddEvent(window, "orientationchange", ScaleSlider);           
        };
    </script>	
	<style>		
		.jssorb05{position:absolute}.jssorb05 div,.jssorb05 div:hover,.jssorb05 
		
		no-repeat;overflow:hidden;cursor:pointer}.jssorb05 div{background-position:-7px -7px}.jssorb05 div:hover,.jssorb05 .av:hover{background-position:-37px -7px}.jssorb05 .av{background-position:-67px -7px}.jssorb05 .dn,.jssorb05 .dn:hover{background-position:-97px -7px}.jssora22l,.jssora22r{display:block;position:absolute;width:40px;height:58px;cursor:pointer;background:url('/images/a22.png') center center no-repeat;overflow:hidden}.jssora22l{background-position:-10px -31px}.jssora22r{background-position:-70px -31px}.jssora22l:hover{background-position:-130px -31px}.jssora22r:hover{background-position:-190px -31px}.jssora22l.jssora22ldn{background-position:-250px -31px}.jssora22r.jssora22rdn{background-position:-310px -31px}
	</style>
	<div id="jssor_1" style="position: relative; margin: 0px auto; top: 0px; left: 0px; width: 1348px; height: 230.508px; overflow: hidden; visibility: visible;" jssor-slider="true">			
		
				
		
		
	<div style="position: absolute; top: 0px; left: 0px; width: 2000px; height: 342px; transform-origin: 0px 0px; transform: scale(0.674);">
	<div class="" style="position: relative; margin: 0px auto; top: 0px; left: 0px; width: 2000px; height: 342px; overflow: visible; visibility: visible; display: block;"><div class="imgs" data-u="slides" style="cursor: default; position: absolute; top: 0px; left: 0px; width: 2000px; height: 342px; overflow: hidden; z-index: 0;"><div style="position: absolute; z-index: 0; pointer-events: none;"></div></div><div class="imgs" data-u="slides" style="cursor: default; position: absolute; top: 0px; left: 0px; width: 2000px; height: 342px; overflow: hidden; z-index: 0;"><div style="top: 0px; left: 0px; width: 2000px; height: 342px; position: absolute; background-color: rgb(0, 0, 0); opacity: 0; display: none;"></div>
		<div class="sub_link_menu_wrap" style="top: 0px; left: 0px; width: 2000px; height: 342px; position: absolute; overflow: hidden;"><img class="bg_img" data-u="image" src="../images/story.jpg
		" border="0" style="top: 0px; left: 0px; width: 2000px; height: 342px; position: absolute;"><div style="top: 0px; left: 0px; width: 2000px; height: 342px; z-index: 1000; display: none;"></div></div>			
		</div><div data-u="navigator" class="jssorb05" style="bottom: 16px; right: 6px; width: 16px; height: 16px; left: 992px;" data-autocenter="1">			
			
		<div data-u="prototype" style="width: 16px; height: 16px; position: absolute; left: 0px; top: 0px;" class="av"></div></div><span data-u="arrowleft" class="jssora22l" style="top: 142px; left: 12px; width: 40px; height: 58px; display: none;" data-autocenter="2"></span><span data-u="arrowright" class="jssora22r" style="top: 142px; right: 12px; width: 40px; height: 58px; display: none;" data-autocenter="2"></span></div></div></div>

<div class="sub_link_box">
	<div class="sub_link_menu">
		<span id="sub_Color_f" ><a href="/noticeboard/notice_list">공지사항</a></span>
		<span id="sub_Color_f" class="sub_under_bar"><a href="/noticeboard/after_list">웨딩후기</a></span>
    </div>
</div>
<div id="contain02">
	<div id="contain02_text">
		<span class="title_name">웨딩후기</span>
        <span class="title_detail">결혼 준비의 새로운 기준 웨딩수다와 함께 하세요!</span>
    </div>
</div>
<script type="text/javascript">
$(document).ready(function() {	
	$('#title').focus();
	
	$('#regist_btn').click(function() {
		var title = $('#title').val();
		if (!title)
		{
			alert("제목을 입력하세요");
			$('#title').focus();
			return;
		}	
		var name = $('#name').val();
		if (!name)
		{
			alert("이름을 입력하세요");
			$('#name').focus();
			return;
		}
		var content = $('#content').val();
		if (!content)
		{
			alert("내용을 입력하세요");
			$('#content').focus();
			return;
		}
		
		var str = $('#content').val();
		str = str.replace(/(?:\r\n|\r|\n)/g, '<br>');
		$('#content').val(str);
		
		document.online_write_box.submit();		
	});
	$('#link_btn').click(function() {
		data = $(this).attr("data");
		top.location.href="./after_list";
	});
});

</script>

<div id="online_write_wrap">    
	<form name="online_write_box" id="online_write_box" method="post" action="./after_write" enctype="multipart/form-data">
	<input type="hidden" name="userid" id="userid" value="${session_userid }">
	<div class="online_Awrite_form">
		<ul>
			<li class="box_li">
				<span class="online_write_title"><img src="../images/member_icon.png">&nbsp;&nbsp;&nbsp;제목</span>
                <div class="value">
                <input type="text" name="btitle" id="title" class="online_write_input" value="" style="padding-left:5px;color:#000000;">
                </div>
            </li>                
            <li class="box_li">
				<span class="online_write_title"><img src="../images/member_icon.png">&nbsp;&nbsp;&nbsp;이름</span>
                <div class="value">
                <input type="text" name="nname" id="name" class="online_write_input02" value="${session_name}" style="padding-left:5px;color:#000000;" readonly="readonly">
                </div>
            </li>
            <li class="box_li" >
				<span class="online_write_title" style="font-size:14px;"><img src="../images/member_icon.png">&nbsp;&nbsp;&nbsp;파일첨가</span>
                <div class="value"> 
                <input type="file" name="file" id="file" style="margin-left: 10px; margin-top: 12px" >
            	</div>
            </li>
        	  <li class="online_wirte_editor" style="clear:both;">
				<span class="online_write_title02" style="font-size:14px;"><img src="../images/member_icon.png">&nbsp;&nbsp;&nbsp;내용</span>
                <div class="value">
                <div><textarea name="bcontent" id="content"></textarea></div></div>
            </li>


        </ul>
    </div>
    <div class="online_write_button">
		<span class="online_center">
			<span class="button_pack">
                <span class="btn_input"><button type="button" class="online_lg_color" id="regist_btn" style="cursor:pointer;font-family: NanumBarunGothic;">저장하기</button></span>
                <span class="btn_input"><button type="button" class="online_lg_color02" id="link_btn" data="pageNo=&amp;search=&amp;keyword=" style="cursor:pointer;font-family: NanumBarunGothic;">목록으로</button></span>
            </span>
        </span>
     </div>
</form>
</div>


<!--푸터 넣을거임  -->

<jsp:include page="../include/footer.jsp">
    <jsp:param name="category" value="product2" />
</jsp:include>



</div></div></body></html>