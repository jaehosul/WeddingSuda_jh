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
<script type="text/javascript" src="/js/ckeditor/ckeditor.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	function writeCheck(){
		
		if($("#btitle").val() == ""){
			alert("제목을 입력하세요!");
			$("#btitle").focus();
			return false;
		}
		
		if($("#name").val() == ""){
			alert("이름을 입력하세요!");
			$("#name").focus();
			return false;
		}
		
		if(CKEDITOR.instances.bcontent1.getData() == '' || CKEDITOR.instances.bcontent1.getData().length == 0){
			alert("내용을 입력해 주세요!");
			$("#bcontent1").focus();
			return false;
		}
		
		var content_data = CKEDITOR.instances.bcontent1.getData(); 
		document.getElementById('bcontent').value = content_data;
				
		document.writeForm.submit();
		
	}//writeCheck()
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



<div id="online_write_wrap">    
	<form name="writeForm" id="writeForm" method="post" action="./writeCheck" enctype="multipart/form-data">
	<!-- 
	<input type="hidden" id="mode" name="mode" value="write">
	<input type="hidden" id="idx" name="idx" value="">
	<input type="hidden" id="pageNo" name="pageNo" value="">
	<input type="hidden" id="search" name="search" value="">
	<input type="hidden" id="keyword" name="keyword" value="">
	-->
	<div class="online_Awrite_form">
		<ul>
			<li class="box_li">
				<span class="online_write_title"><img src="../images/member_icon.png">&nbsp;&nbsp;&nbsp;제목</span>
                <div class="value"><input type="text" name="btitle" id="btitle" class="online_write_input" value="" style="padding-left:5px;color:#000000;"></div>
            </li>                
            <li class="box_li">
				<span class="online_write_title"><img src="../images/member_icon.png">&nbsp;&nbsp;&nbsp;이름</span>
                <div class="value"><input type="text" name="userid" id="userid" class="online_write_input02" value="${session_userid}" style="padding-left:5px;color:#000000;" readonly="readonly"></div>
            </li>	
            <li class="box_li line2">
				<span class="online_write_title"><img src="../images/member_icon.png">&nbsp;&nbsp;&nbsp;파일첨부</span>
                <div class="value"><input type="file" name="file" id="file" class="online_write_input02" value="" style="padding-left:5px;color:#000000;"></div>
            </li>	
            <li class="online_wirte_editor">				
                <div><table width="100%"><tbody><tr><td><link rel="stylesheet" href="/DaumEditor-master/daumeditor/css/editor.css" type="text/css" charset="utf-8">
<script src="/DaumEditor-master/daumeditor/js/editor_loader.js" type="text/javascript" charset="utf-8"></script><script type="text/javascript" src="http://verygoodwedding.co.kr/DaumEditor-master/daumeditor/js/editor.js" charset="utf-8"></script>
<script type="text/javascript">
<!--
//동영상기능추가
TrexConfig.addTool
(
    "cinema", // 마크업에 추가한 id(tx_cinema)에 "tx_"를 제외한 부분이 됩니다.
    {
        url: "/DaumEditor-master/daumeditor/pages/trex/movie.html", // 속성은 마음대로 추가 가능
        name: "editor_movie"
    }
);

Trex.Tool.Test = Trex.Class.create
(
	{
		$const: {__Identity: 'cinema' },
		$extend: Trex.Tool,
		oninitialized: function(config) 
		{ 
			var _editor = this.editor;
			var self = this;
			var _toolHandler = function()
			{
				// 정의된 속성을 이용해서 버튼 클릭시 새 창을 호출 
				//window.open( config.url, config.name );
				window.open(config.url, config.name, 'width=500, height=500, status=no scrollbars=yes, resizable=yes');
			};
			
			this.weave.bind(this)
			(
				new Trex.Button(this.buttonCfg), 
				null,
				_toolHandler
			);
		}
	}
);
//동영상기능추가
//-->
</script>
<input type="text" name="bcontent1" id="bcontent1" style="display:none;" row="100px">
<!-- <textarea name="bcontent" id="bcontent" style="display:none;" row="100px" value="안녕하세요"></textarea> -->
	<!-- 에디터 추가 -->
<script type="text/javascript">
 CKEDITOR.replace('bcontent1', {height: 500});
</script>
<input type="hidden" name="bcontent" id="bcontent" value="">
<div id="tx_trex_container" name="tx_trex_container">
<div class="body">


	
	
<script type="text/javascript">
	
	var config = {
		txHost: '', /* 런타임 시 리소스들을 로딩할 때 필요한 부분으로, 경로가 변경되면 이 부분 수정이 필요. ex) http://xxx.xxx.com */
		txPath: '/DaumEditor-master/daumeditor/', /* 런타임 시 리소스들을 로딩할 때 필요한 부분으로, 경로가 변경되면 이 부분 수정이 필요. ex) /xxx/xxx/ */
		txService: 'sample', /* 수정필요없음. */
		txProject: 'sample', /* 수정필요없음. 프로젝트가 여러개일 경우만 수정한다. */
		initializedId: "", /* 대부분의 경우에 빈문자열 */
		wrapper: "tx_trex_container", /* 에디터를 둘러싸고 있는 레이어 이름(에디터 컨테이너) */
		form: 'online_write_box'+"", /* 등록하기 위한 Form 이름 */
		txIconPath: "/DaumEditor-master/daumeditor/images/icon/editor/", /*에디터에 사용되는 이미지 디렉터리, 필요에 따라 수정한다. */
		txDecoPath: "/DaumEditor-master/daumeditor/images/deco/contents/", /*본문에 사용되는 이미지 디렉터리, 서비스에서 사용할 때는 완성된 컨텐츠로 배포되기 위해 절대경로로 수정한다. */
		canvas: {
			styles: {
				color: "#123456", /* 기본 글자색 */
				fontFamily: "굴림", /* 기본 글자체 */
				fontSize: "10pt", /* 기본 글자크기 */
				backgroundColor: "#fff", /*기본 배경색 */
				lineHeight: "1.5", /*기본 줄간격 */
				padding: "8px" /* 위지윅 영역의 여백 */
			},
			showGuideArea: false
		},
		events: {
			preventUnload: false
		},
		sidebar: {
			attachbox: {
				show: true,
				confirmForDeleteAll: true
			}
		}
		/* 지정된 넓이가 존재할경우에 설정
		,
		size: {
			contentWidth: 700 
		}
		*/
	};

	/* EditorJSLoader.ready
	(
		function(Editor) 
		{
			var editor = new Editor(config);
			
		}
	); */
	
</script>

<!-- Sample: Saving Contents -->
<script type="text/javascript">
	/* 예제용 함수 */
	function saveContent() 
	{
		Editor.save(); // 이 함수를 호출하여 글을 등록하면 된다.
	}

	/**
	 * Editor.save()를 호출한 경우 데이터가 유효한지 검사하기 위해 부르는 콜백함수로
	 * 상황에 맞게 수정하여 사용한다.
	 * 모든 데이터가 유효할 경우에 true를 리턴한다.
	 * @function
	 * @param {Object} editor - 에디터에서 넘겨주는 editor 객체
	 * @returns {Boolean} 모든 데이터가 유효할 경우에 true
	 */
	function validForm(editor) {
		// Place your validation logic here

		// sample : validate that content exists
		var validator = new Trex.Validator();
		var content = editor.getContent();
		if (!validator.exists(content)) {
			alert('내용을 입력하세요');
			return false;
		}

		return true;
	}

	/**
	 * Editor.save()를 호출한 경우 validForm callback 이 수행된 이후
	 * 실제 form submit을 위해 form 필드를 생성, 변경하기 위해 부르는 콜백함수로
	 * 각자 상황에 맞게 적절히 응용하여 사용한다.
	 * @function
	 * @param {Object} editor - 에디터에서 넘겨주는 editor 객체
	 * @returns {Boolean} 정상적인 경우에 true
	 */
	function setForm(editor) {
        var i, input;
        var form = editor.getForm();
        var content = editor.getContent();

        // 본문 내용을 필드를 생성하여 값을 할당하는 부분
        var textarea = document.createElement('textarea');
        textarea.name = 'content';
        textarea.value = content;
        form.createField(textarea);

        /* 아래의 코드는 첨부된 데이터를 필드를 생성하여 값을 할당하는 부분으로 상황에 맞게 수정하여 사용한다.
         첨부된 데이터 중에 주어진 종류(image,file..)에 해당하는 것만 배열로 넘겨준다. */
        var images = editor.getAttachments('image');
        for (i = 0; i < images.length; i++) {
            // existStage는 현재 본문에 존재하는지 여부
            if (images[i].existStage) {
                // data는 팝업에서 execAttach 등을 통해 넘긴 데이터
                alert('attachment information - image[' + i + '] \r\n' + JSON.stringify(images[i].data));
                input = document.createElement('input');
                input.type = 'hidden';
                input.name = 'attach_image';
                input.value = images[i].data.imageurl;  // 예에서는 이미지경로만 받아서 사용
                form.createField(input);
            }
        }

        var files = editor.getAttachments('file');
        for (i = 0; i < files.length; i++) {
            input = document.createElement('input');
            input.type = 'hidden';
            input.name = 'attach_file';
            input.value = files[i].data.attachurl;
            form.createField(input);
        }
        return true;
	}
</script>

<!--<div><button onclick='saveContent()'>SAMPLE - submit contents</button></div>-->
<!-- End: Saving Contents -->

<!-- Sample: Loading Contents -->

<textarea id="sample_contents_source" style="display:none;"></textarea>

<script type="text/javascript">
	function loadContent() 
	{
		var http_url = "http://verygoodwedding.co.kr";

		var attachments = {};
		attachments['image'] = [];
		
		var editor_img_src = "";
		var editor_img_src_array = editor_img_src.split("|");

		for(var i=0;i<editor_img_src_array.length;i++)
		{
			var img_src = editor_img_src_array[i];
			var img_mi_name = img_src.substring(img_src.lastIndexOf("/")+1, img_src.length);
			if(img_mi_name!="")
			{
				attachments['image'].push
				(
					{
						'attacher': 'image',
						'data': 
						{
							'imageurl': img_src,
							'filename': img_mi_name,
							'filesize': 0,
							'originalurl': img_src,
							'thumburl': img_src
						}
					}
				);
			}
		}
		
		
			attachments['file'] = [];
			
			var editor_file_src = "";
			var editor_file_src_array = editor_file_src.split("|");
			
			for(var i=0;i<editor_file_src_array.length;i++)
			{
				var file_href = editor_file_src_array[i];
				var file_mi_name = file_href.substring(file_href.lastIndexOf("/")+1, file_href.length);

				if(file_mi_name != "") 
				{
					attachments['file'].push
					(
						{
							'attacher': 'file',
							'data': 
							{
								'attachurl': file_href,
								'filemime': file_mi_name,
								'filename': file_mi_name,
								'filesize': 0
							}
						}
					);
				}
				
			}
		
		
		/* 저장된 컨텐츠를 불러오기 위한 함수 호출 */
		Editor.modify
		(
			{
				"attachments": function () 
				{ /* 저장된 첨부가 있을 경우 배열로 넘김, 위의 부분을 수정하고 아래 부분은 수정없이 사용 */
					var allattachments = [];
					for (var i in attachments) 
					{
						allattachments = allattachments.concat(attachments[i]);
					}

					return allattachments;
				}(),
				"content": document.getElementById("sample_contents_source") /* 내용 문자열, 주어진 필드(textarea) 엘리먼트 */
			}
		);
	}
</script>
<!--<div><button onclick='loadContent()'>SAMPLE - load contents to editor</button></div>-->
<!-- End: Loading Contents -->
</div>
</td></tr></tbody></table></div>
            </li>
        </ul>
    </div>
    <div class="online_write_button">
		<span class="online_center">
			<span class="button_pack">
                <span class="btn_input"><button type="button" class="online_lg_color" id="regist_btn" style="cursor:pointer;font-family: NanumBarunGothic;" onclick="writeCheck()">저장하기</button></span>
                <span class="btn_input"><button type="button" class="online_lg_color02" id="link_btn" data="pageNo=&amp;search=&amp;keyword=" style="cursor:pointer;font-family: NanumBarunGothic;"><a href="./inquiry_main?page=${map.maxPage}&search=${map.search}">목록으로</a></button></span>
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