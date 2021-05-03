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
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	function deleteCheck(){
		if(confirm("삭제하시겠습니까?")){
  			location.href="./delete?bid=${map.dto.bid}&page=${map.page}&search=${map.search}";
  		}else{
  			return false;
  		}//if 
		
		
	}//deleteCheck()
</script>
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
		
				
		
		
	<div style="position: absolute; top: 0px; left: 0px; width: 2000px; height: 342px; transform-origin: 0px 0px; transform: scale(0.674);"><div class="" style="position: relative; margin: 0px auto; top: 0px; left: 0px; width: 2000px; height: 342px; overflow: visible; visibility: visible; display: block;"><div class="imgs" data-u="slides" style="cursor: default; position: absolute; top: 0px; left: 0px; width: 2000px; height: 342px; overflow: hidden; z-index: 0;"><div style="position: absolute; z-index: 0; pointer-events: none;"></div></div><div class="imgs" data-u="slides" style="cursor: default; position: absolute; top: 0px; left: 0px; width: 2000px; height: 342px; overflow: hidden; z-index: 0;"><div style="top: 0px; left: 0px; width: 2000px; height: 342px; position: absolute; background-color: rgb(0, 0, 0); opacity: 0; display: none;"></div>
		<div class="sub_link_menu_wrap" style="top: 0px; left: 0px; width: 2000px; height: 342px; position: absolute; overflow: hidden;"><img class="bg_img" data-u="image" src="../images/story.jpg
		" border="0" style="top: 0px; left: 0px; width: 2000px; height: 342px; position: absolute;"><div style="top: 0px; left: 0px; width: 2000px; height: 342px; z-index: 1000; display: none;"></div></div>			
		</div><div data-u="navigator" class="jssorb05" style="bottom: 16px; right: 6px; width: 16px; height: 16px; left: 992px;" data-autocenter="1">			
			
		<div data-u="prototype" style="width: 16px; height: 16px; position: absolute; left: 0px; top: 0px;" class="av"></div></div><span data-u="arrowleft" class="jssora22l" style="top: 142px; left: 12px; width: 40px; height: 58px; display: none;" data-autocenter="2"></span><span data-u="arrowright" class="jssora22r" style="top: 142px; right: 12px; width: 40px; height: 58px; display: none;" data-autocenter="2"></span></div></div></div>

<div class="sub_link_box">
	<div class="sub_link_menu">
		<span id="sub_Color_f" class="sub_under_bar"><a href="/noticeboard/notice_list">지식인</a></span>
        <!-- <span id="sub_Color_f"><a href="/noticeboard/board_list">문의게시판</a></span>
		<span id="sub_Color_f"><a href="/noticeboard/after_list">웨딩후기</a></span> -->
    </div>
</div>
<div id="contain02">
	<div id="contain02_text">
		<span class="title_name">지식인</span>
        <span class="title_detail">결혼 준비와 관련된 질문과 답변을 자유롭게 올려주세요!</span>
    </div>
</div>



<div id="community_after_detail_wrap">
	<div id="after_detail_title">
		<span class="after_detail_title_txt">${map.dto.btitle}</span>
    </div>
    <div id="after_detail_date">
		<span id="after_detail_date_day" style="font-size:13px;color:#000000;">• 작성자</span>
        <span class="after_detail_date_day" style="font-size:13px;">${map.dto.userid}</span>
        <span id="after_detail_date_day" style="font-size:13px;color:#000000;">• 작성일</span>
        <span class="after_detail_date_day" style="font-size:13px;">${map.dto.bdate}</span>
        <span id="after_detail_date_day" style="font-size:13px;color:#000000;">• 조회수</span>
        <span class="after_detail_date_day" style="font-size:13px;">${map.dto.bhit}</span>
    </div>
    <div id="after_detail_img" style="font-size:14px;">        	
		${map.dto.bcontent}
		<c:choose>
			<c:when test="${map.dto.filename ne null}">
				<img alt="" src="/upload/${map.dto.filename}">
			</c:when>
		</c:choose>
    </div>
	
    <div id="after_detail_lotation">
		<div id="after_lotation_left">
			<div class="after_lotation_left01"><a><img src="../images/up.jpg" alt="up">이전글</a></div>
            <div class="after_lotation_left02">
				
					<a href="./inquiry_content_view?bid=${map.preDto.bid}&page=${map.page}&search=${map.search}">${map.preDto.btitle}</a> 
				
			</div>
        </div>
        <div id="after_lotation_right">
			<div class="after_lotation_right01"><a><img src="../images/down.jpg" alt="down">다음글</a></div>
            <div class="after_lotation_right02">
				
					<a href="./inquiry_content_view?bid=${map.nextDto.bid}&page=${map.page}&search=${map.search}">${map.nextDto.btitle}</a> 
				</div>
            </div>
        </div>     
		<div id="after_return">
			<c:choose>
				<c:when test="${session_userid eq map.dto.userid}">
					<span class="after_return_txt_list"><a href="./inquiry_main?page=${map.page}&search=${map.search}">목록으로</a></span>
					<span class="after_return_txt_edit"><a href="./inquiry_modify_view?bid=${map.dto.bid}&page=${map.page}&search=${map.search}" id="edit_btn" style="cursor:pointer;" data="18876" data2="pageNo=2&amp;search=&amp;keyword=" data3="pageNo=2&amp;search=&amp;keyword=" data4="유민지">수정</a></span>
					<span class="after_return_txt_del"><a id="del_btn" style="cursor:pointer;" data="18876" data2="pageNo=2&amp;search=&amp;keyword=" data3="pageNo=2&amp;search=&amp;keyword=" data4="유민지" onclick="deleteCheck()">삭제</a></span>
					<span class="after_return_txt_write"><a href="./inquiry_reply_view?page=${map.page}&search=${map.search}&bid=${map.dto.bid}" id="regist_btn" style="cursor:pointer;">답글달기</a></span>&nbsp;&nbsp;
				</c:when>
				<c:when test="${map.result_dto.userid eq session_userid && map.dto.replycheck eq 0}">
					<span class="after_return_txt_list"><a href="./inquiry_main?page=${map.page}&search=${map.search}">목록으로</a></span>
					<span class="after_return_txt_write"><a href="./inquiry_replyCheck?page=${map.page}&search=${map.search}&bid=${map.dto.bid}" id="regist_btn" style="cursor:pointer; background-color:#1a41af;">답변채택</a></span>
				</c:when>
				<c:otherwise>
					<span class="after_return_txt_list"><a href="./inquiry_main?page=${map.page}&search=${map.search}">목록으로</a></span>
					<span class="after_return_txt_write"><a href="./inquiry_reply_view?page=${map.page}&search=${map.search}&bid=${map.dto.bid}" id="regist_btn" style="cursor:pointer;">답글달기</a></span>&nbsp;&nbsp;
				</c:otherwise>
			</c:choose>
		</div>
		<div style="height:70px;">
			             		
		</div>
	</div>




<!--푸터 넣을거임  -->

<jsp:include page="../include/footer.jsp">
    <jsp:param name="category" value="product2" />
</jsp:include>



</div></div></body></html>