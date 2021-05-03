package com.site.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.site.dto.inquiry_boardDto;
import com.site.mapper.Inquiry_mapper;

@Service
public class InquiryBoard_impl implements InquiryBoard {
	
	@Autowired
	Inquiry_mapper inquiry_mapper;
	@Autowired
	Inquiry_PageNumber pageNumber;
	
	//변수선언
	List<inquiry_boardDto> list;
	Map<String, Object> map;
	inquiry_boardDto preDto;
	inquiry_boardDto nextDto;
	inquiry_boardDto inqDto;

	@Override
	public Map<String, Object> boardListAll(String listPage, String search) {
		
		
		int page = 1;    //첫 페이지 초기화
		int limit = 15;  //1개 페이지에 노출되는 게시글 수(15개씩)
		
		// page 데이터가 있으면 데이터 적용
		if (listPage != null && listPage != "") {
			page = Integer.parseInt(listPage);
		}
		
		
		int startRow = (page-1)*limit+1;   //선택한 페이지의 첫번째 줄 => 1, 16, 31...
		int endRow = startRow+limit-1;   //선택한 페이지의 마지막 줄 => 15, 30, 45 ...
		
		
		//검색기능
		//검색기능 추가해야함(지금은 검색어 입력하지 않았을 때)
		if(search == null || search.equals("")) {   //검색어를 입력하지 않았을 떄
			list = inquiry_mapper.selectBoardListAll(startRow, endRow);
			
		}else if(search != null) {   //검색기능을 사용했을 때
			list = inquiry_mapper.selectBoardSearchList(startRow, endRow, search);
			
		}//if
		
		
		//user가 클릭한 튜플의 개수를 확인한다.(inquiry_main 헤더 새글 알림용)
		int clickCount = inquiry_mapper.selectBoardClickCount();
		
		
		//메소드 호출 - 페이지 넘버링 계산
		map = pageNumber.pageNumber(page, limit, search);
		
		
		//map에 답기
		map.put("clickCount", clickCount);
		map.put("list", list);
		
		
		return map;
	}

	@Override
	public Map<String, Object> boardContentView(String bid, String page, String search, HttpServletRequest request, HttpServletResponse response) {
		
		//새로고침 조회수 증가 막기 처리- 쿠키이용
		//https://syaku.tistory.com/275 참고
		//저장된 쿠키 불러오기
		Cookie cookies[] = request.getCookies();
		Map mapCookie = new HashMap<String, Object>();
		if(request.getCookies() != null) {
			for(int i=0; i<cookies.length; i++) {
				Cookie obj = cookies[i];
				mapCookie.put(obj.getName(), obj.getValue());
			}//for
		}//if
		
		
		//저장된 쿠키중에 read_count만 불러오기
		String cookie_read_count = (String) mapCookie.get("read_count");
		//저장될 새로운 쿠키값 생성
		String new_cookie_read_count = "|" + bid;
		
		//저장된 쿠키에 새로운 쿠키값이 존재하는지 검사
		if(StringUtils.indexOfIgnoreCase(cookie_read_count, new_cookie_read_count) == -1) {
			//없을 경우 쿠키 생성
			Cookie cookie = new Cookie("read_count", cookie_read_count+new_cookie_read_count);
			response.addCookie(cookie);
			
			//조회수 1증가 처리
			inquiry_mapper.updateUpHit(bid);
			
		}

		
		//검색기능 사용여부에 따른
		//이전글, 다음글 가져오기
		if(search == null || search.equals("")) {
			preDto = inquiry_mapper.selectBoard_pre(bid);
			nextDto = inquiry_mapper.selectBoard_next(bid);
			
		}else {
			preDto = inquiry_mapper.selectBoard_pre_withSearch(bid, search);
			nextDto = inquiry_mapper.selectBoard_next_withSearch(bid, search);
			
		}//if
		
		
		//DB에서 데이터 가져오기
		inquiry_boardDto dto = inquiry_mapper.selectBoardContentView(bid);
		
		
		//답변채택 버튼 노출을 위해서
		//현재의 contentView의 bgroup 값과 모두 같은 튜플중에서 bindent가 0인 튜플의 userid값을 찾는다.
		//찾은 그 값을 map에 담는다.
		inquiry_boardDto result_dto = inquiry_mapper.selectFindSameBgroup(dto.getBgroup());
		
		
		//새글 알림 처리
		//원글 작성자(즉, result_dto의 userid)의 bgroup 값이 같으면서 clickcheck=0이면(0의 의미는 클릭안함)
		//매개변수로 넘어온 bid의 clickcheck=1로 만든다.(1의 의미는 클릭함)
		int group_dto = dto.getBgroup();   //현재 글의 bgroup
		int group_resultDto = result_dto.getBgroup();   //원글의 bgroup
		
		
		if(group_dto == group_resultDto && dto.getClickcheck() == 0) {
			inquiry_mapper.updateBoardClickCheck(dto.getBid());
			dto.setClickcheck(1);
		}

		
		
		
		
		
		//table join을 이용하여 이름 확인하기
		//String name = inquiry_mapper.selectName(bid);
		
		
		//map.put("name", name);
		map.put("dto", dto);
		map.put("page", page);
		map.put("search", search);
		map.put("preDto", preDto);
		map.put("nextDto", nextDto);
		map.put("result_dto", result_dto);
		
		return map;
	}

	@Override
	public void boardWrite(inquiry_boardDto inqDto, MultipartFile file) {
		
		//첨부파일 처리
		String fileName = file.getOriginalFilename();  //원본파일 이름
		String filenameExtension = FilenameUtils.getExtension(fileName).toLowerCase();  //확장자명 가져오기
		
		if(filenameExtension != "") {
			String fileUrl = "C:/Users/User/git/new_wedding_suda/src/main/resources/static/upload/";  //파일저장위치(마지막에 반드시 슬래시(/))
			String uploadFileName = RandomStringUtils.randomAlphanumeric(32)+"."+filenameExtension;  //신규 파일 이름 - 32자리(중복방지)
			File f = new File(fileUrl+uploadFileName);
			try {
				file.transferTo(f);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//위에서 처리한 파일이름까지 inqDto에 담아서 DB로 보낸다.
			inqDto.setFilename(uploadFileName);
		}else {
			inqDto.setFilename("");
		}
		
		
		//DB로 전송
		inquiry_mapper.insertBoardWrite(inqDto);
		
	}

	@Override
	public void boardDelete(String bid, String page, String search) {
		
		inquiry_mapper.deleteBoardDelete(bid);
		
		map.put("page", page);
		map.put("search", search);
		
	}

	@Override
	public Map<String, Object> boardModify_view(String bid, String page, String search) {
		
		//1개 content 가져오기
		inqDto = inquiry_mapper.selectBoardContentView(bid);
		
		map.put("page", page);
		map.put("search", search);
		map.put("inqDto", inqDto);
		
		
		return map;
	}

	@Override
	public void boardModify(inquiry_boardDto inqDto, MultipartFile file, String page, String search) {
		
		//첨부파일 처리
		String fileName = file.getOriginalFilename();  //원본파일 이름
		String filenameExtension = FilenameUtils.getExtension(fileName).toLowerCase();  //확장자명 가져오기
		
		if(filenameExtension != "") {
			String fileUrl = "C:/Users/User/git/new_wedding_suda/src/main/resources/static/upload/";  //파일저장위치(마지막에 반드시 슬래시(/))
			String uploadFileName = RandomStringUtils.randomAlphanumeric(32)+"."+filenameExtension;  //신규 파일 이름 - 32자리(중복방지)
			File f = new File(fileUrl+uploadFileName);
			try {
				file.transferTo(f);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//위에서 처리한 파일이름까지 inqDto에 담아서 DB로 보낸다.
			inqDto.setFilename(uploadFileName);
		}else {
			//수정 단계이므로 기존 파일을 유지한다.(""처리하면 기존 파일이름을 덮어쓰기 함)
			//inqDto.setFilename("");
		}
		
		//DB로 전송
		inquiry_mapper.updateBoardModify(inqDto);
		
		map.put("search", search);
		map.put("page", page);
		
		
		
	}

	@Override
	public void boardReply(inquiry_boardDto inqDto, MultipartFile file, String page, String search) {
		
		//첨부파일 처리
		String fileName = file.getOriginalFilename();  //원본파일 이름
		String filenameExtension = FilenameUtils.getExtension(fileName).toLowerCase();  //확장자명 가져오기
		
		if(filenameExtension != "") {
			String fileUrl = "C:/Users/User/git/new_wedding_suda/src/main/resources/static/upload/";  //파일저장위치(마지막에 반드시 슬래시(/))
			String uploadFileName = RandomStringUtils.randomAlphanumeric(32)+"."+filenameExtension;  //신규 파일 이름 - 32자리(중복방지)
			File f = new File(fileUrl+uploadFileName);
			try {
				file.transferTo(f);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//위에서 처리한 파일이름까지 inqDto에 담아서 DB로 보낸다.
			inqDto.setFilename(uploadFileName);
		}else {
			inqDto.setFilename("");
		}
		
		//DB로 전송
		inquiry_mapper.insertBoardReply(inqDto);
		
		
		//댓글 처리이므로 
		//같은 그룹안에서 새로운 댓글 아래의 모든 글은 bstep+1 처리해야함
		inquiry_mapper.insertBoardReplyPlus(inqDto);
		
		
		map.put("search", search);
		map.put("page", page);
		
	}

	@Override
	public void boardReplyPointCheck(String bid, String page, String search) {
		
		System.out.println("impl, bid : "+bid);
		System.out.println("impl, page : "+page);
		System.out.println("impl, search : "+search);
		
		//답변 채택된 작성자의 포인트 +100 처리
		int check = inquiry_mapper.updateReplyPointPlus(bid);
		System.out.println("impl, +100 : "+check);
		
		//답변채택이 되고 포인트 지급이 완료되었으므로
		//ws_inquiry_board 테이블에 replycheck값을 1로 저장한다.
		inquiry_mapper.updateReplyCheck(bid);
		
		map.put("search", search);
		map.put("page", page);
	}

}//class
