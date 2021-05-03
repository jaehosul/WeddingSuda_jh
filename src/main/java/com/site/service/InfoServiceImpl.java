package com.site.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.site.dto.DresscompanyInfoDto;
import com.site.dto.HMcompanyInfoDto;
import com.site.dto.MemberDto;
import com.site.dto.StudiocompanyInfoDto;
import com.site.dto.TravelcompanyInfoDto;
import com.site.dto.questionBoardDto;
import com.site.mapper.InfoMapper;

@Service
public class InfoServiceImpl implements InfoService {

	@Autowired
	InfoMapper infoMapper;
	@Autowired
	Map<String, Object> map;
	List<StudiocompanyInfoDto> list;
	List<DresscompanyInfoDto> list2;
	List<HMcompanyInfoDto> list3;
	List<TravelcompanyInfoDto> list4;
	List<questionBoardDto> q_list;
	StudiocompanyInfoDto stuDto;
	DresscompanyInfoDto dreDto;
	HMcompanyInfoDto hmDto;
	TravelcompanyInfoDto traDto;
	questionBoardDto queDto;
	questionBoardDto preDto;
	questionBoardDto nextDto;
	@Autowired
	Info_PageNumber pageNumber;

	@Override
	public Map<String, Object> StudioList(String listPage, String search) {

		list = new ArrayList<StudiocompanyInfoDto>();

		int page = 1; // 첫페이지 초기화
		int limit = 9; // 한 페이지에 나오는 게시글 수 : 9

		// page데이터가 있으면 데이터 값 적용
		if (listPage != null && listPage != "") {
			page = Integer.parseInt(listPage);
		}

		int startrow = (page - 1) * limit + 1; // 시작 게시글번호 1,11,21...
		int endrow = startrow + limit - 1; // 마지막 게시글번호 10,20,30...

		// 리스트 가져오기
		if (search == null || search.equals("")) {
			list = infoMapper.selectStudioListAll(startrow, endrow);
		} else {
			list = infoMapper.selectStudioListSearch(startrow, endrow, search);
		}

		map = pageNumber.stuPageNumber(page, limit, search);

		map.put("list", list);

		return map;
	}

	@Override
	public Map<String, Object> StudioContent_view(String infoId, String page, String search) {

		stuDto = infoMapper.selectStudioContent_view(infoId);

		map.put("stuDto", stuDto);
		map.put("page", page);
		map.put("search", search);

		return map;
	}

	@Override
	public Map<String, Object> StudioWrite(StudiocompanyInfoDto stuDto,@RequestPart MultipartFile file) {

		String orgfileName = file.getOriginalFilename();
		System.out.println("impl : " + orgfileName);
		if (file.getSize() != 0) { // 파일사이즈가 0이 아니면
			// 파일 저장 위치
			String fileUrl = "C:/Users/User/git/new_wedding_suda/src/main/resources/static/upload/"; // 끝에 /붙여주기 그래야 밑에
																										// 파일이
																										// 저장됨
			// 신규파일이름 ( 32자리이름생성.확장자명 )
			// 이름에 시간추가
			long time = System.currentTimeMillis();
			String uploadFileName = String.format("%d_%s", time, orgfileName);
			File f = new File(fileUrl + uploadFileName);
			try {
				file.transferTo(f);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 파일이름저장
			stuDto.setC_fileName(uploadFileName);
		} else {
			stuDto.setC_fileName("");
		}

		System.out.println("파일 : " + stuDto.getC_fileName());
		
		// mapper전달
		infoMapper.insertStudioWrite(stuDto);
		return map;
	}

	@Override
	public Map<String, Object> StudioModifyView(String infoId, String page, String search) {

		stuDto = infoMapper.selectStudioModifyView(infoId);
		System.out.println("파일이름 : " + stuDto.getC_fileName());

		map.put("stuDto", stuDto);
		map.put("page", page);
		map.put("search", search);

		return map;
	}

	@Override
	public Map<String, Object> StudioModify(StudiocompanyInfoDto stuDto, @RequestPart MultipartFile file) {

		System.out.println("파일 이름 impl : "+stuDto.getC_fileName());
		// 원본파일이름
		if (file.getSize() != 0) { // 파일사이즈가 0이 아니면
			String orgfileName = file.getOriginalFilename();
			System.out.println("impl : " + orgfileName);
			// 파일 저장 위치
			String fileUrl = "C:/Users/User/git/new_wedding_suda/src/main/resources/static/upload/"; // 끝에 /붙여주기 그래야 밑에
																										// 파일이
																										// 저장됨
			// 신규파일이름 ( 32자리이름생성.확장자명 )
			// 이름에 시간추가
			long time = System.currentTimeMillis();
			String uploadFileName = String.format("%d_%s", time, orgfileName);
			File f = new File(fileUrl + uploadFileName);
			try {
				file.transferTo(f);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 파일이름저장
			stuDto.setC_fileName(uploadFileName);
		} else {
			// 기존 파일이름을 그대로 저장시키면 됨.
		}

		int ModifyCheck = infoMapper.updateStudioModify(stuDto);
		System.out.println("스튜디오 infoId : "+stuDto.getInfoId());
		System.out.println("스튜디오 ModifyCheck : "+ModifyCheck);

		map.put("ModifyCheck", ModifyCheck);
		
		return map;
	}

	@Override
	public Map<String, Object> StudioDelete(String infoId, String page, String search) {

		infoMapper.deleteStudioDelete(infoId);
		map.put("page", page);
		map.put("search", search);

		return map;
	}

	@Override
	public Map<String, Object> DressList(String listPage, String search) {
		list2 = new ArrayList<DresscompanyInfoDto>();

		int page = 1; // 첫페이지 초기화
		int limit = 9; // 한 페이지에 나오는 게시글 수 : 9

		// page데이터가 있으면 데이터 값 적용
		if (listPage != null && listPage != "") {
			page = Integer.parseInt(listPage);
		}

		int startrow = (page - 1) * limit + 1; // 시작 게시글번호 1,11,21...
		int endrow = startrow + limit - 1; // 마지막 게시글번호 10,20,30...

		// 리스트 가져오기
		if (search == null || search.equals("")) {
			list2 = infoMapper.selectDressListAll(startrow, endrow);
		} else {
			list2 = infoMapper.selectDressListSearch(startrow, endrow, search);
		}

		map = pageNumber.DrePageNumber(page, limit, search);

		map.put("list", list2);
		return map;
	}

	@Override
	public Map<String, Object> StudioWrite_view(String userid) {
		map = new HashMap<String, Object>();
		MemberDto memberDto = infoMapper.selectWriteView(userid);

		map.put("memberDto", memberDto);

		return map;
	}

	@Override
	public Map<String, Object> DressContent_view(String infoId, String page, String search) {

		dreDto = infoMapper.selectDressContent_view(infoId);

		map.put("dreDto", dreDto);
		map.put("page", page);
		map.put("search", search);

		return map;
	}

	@Override
	public Map<String, Object> DressWrite_view(String userid) {

		map = new HashMap<String, Object>();
		MemberDto memberDto = infoMapper.selectWriteView(userid);

		map.put("memberDto", memberDto);
		return map;
	}

	@Override
	public Map<String, Object> DressWrite(DresscompanyInfoDto dreDto, MultipartFile file) {

		// 원본파일이름
		String fileName = file.getOriginalFilename();
		// 확장자명 가져오기
		String fileNameExtension = FilenameUtils.getExtension(fileName).toLowerCase();
		if (FilenameUtils.getExtension(fileName).toLowerCase() != "") {
			// 파일 저장 위치
			String fileUrl = "C:/Users/User/git/new_wedding_suda/src/main/resources/static/upload/"; // 끝에 /붙여주기 그래야 밑에
																										// 파일이 저장됨
			// 신규파일이름 ( 32자리이름생성.확장자명 )
			String uploadFileName = RandomStringUtils.randomAlphanumeric(32) + "." + fileNameExtension;
			File f = new File(fileUrl + uploadFileName);
			try {
				file.transferTo(f);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 파일이름저장
			dreDto.setC_fileName(uploadFileName);
			;
		} else {
			dreDto.setC_fileName("");
			;
		}

		int writeCheck = infoMapper.insertDressWrite(dreDto);

		map.put("writeCheck", writeCheck);

		return map;
	}

	@Override
	public Map<String, Object> DressModifyView(String infoId, String page, String search) {

		dreDto = infoMapper.selectDressModifyView(infoId);
		System.out.println("파일이름 : " + dreDto.getC_fileName());

		map.put("dreDto", dreDto);
		map.put("page", page);
		map.put("search", search);

		return map;
	}

	@Override
	public Map<String, Object> DressModify(DresscompanyInfoDto dreDto, MultipartFile file) {

		System.out.println("modify impl");
		System.out.println("modify impl infoId : "+dreDto.getInfoId());
		// 원본파일이름
		String orgfileName = file.getOriginalFilename();
		System.out.println("impl : " + orgfileName);
		if (file.getSize() != 0) { // 파일사이즈가 0이 아니면
			// 파일 저장 위치
			String fileUrl = "C:/Users/User/git/new_wedding_suda/src/main/resources/static/upload/"; // 끝에 /붙여주기 그래야 밑에
																									// 파일이
																									// 저장됨
			// 신규파일이름 ( 32자리이름생성.확장자명 )
			// 이름에 시간추가
			long time = System.currentTimeMillis();
			String uploadFileName = String.format("%d_%s", time, orgfileName);
			File f = new File(fileUrl + uploadFileName);
			try {
				file.transferTo(f);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 파일이름저장
			dreDto.setC_fileName(uploadFileName);
		} else {
			// 기존 파일이름을 그대로 저장시키면 됨.
		}

		int ModifyCheck = infoMapper.updateDressModify(dreDto);

		map.put("ModifyCheck", ModifyCheck);
		return map;
	}

	@Override
	public Map<String, Object> DressDelete(String infoId, String page, String search) {

		infoMapper.deleteDressDelete(infoId);
		map.put("page", page);
		map.put("search", search);

		return map;
	}

	@Override
	public Map<String, Object> HmList(String listPage, String search) {

		list3 = new ArrayList<HMcompanyInfoDto>();

		int page = 1; // 첫페이지 초기화
		int limit = 9; // 한 페이지에 나오는 게시글 수 : 9

		// page데이터가 있으면 데이터 값 적용
		if (listPage != null && listPage != "") {
			page = Integer.parseInt(listPage);
		}

		int startrow = (page - 1) * limit + 1; // 시작 게시글번호 1,11,21...
		int endrow = startrow + limit - 1; // 마지막 게시글번호 10,20,30...

		// 리스트 가져오기
		if (search == null || search.equals("")) {
			list3 = infoMapper.selectHmListAll(startrow, endrow);
		} else {
			list3 = infoMapper.selectHmListSearch(startrow, endrow, search);
		}

		map = pageNumber.HmPageNumber(page, limit, search);

		map.put("list", list3);

		return map;
	}

	@Override
	public Map<String, Object> HmContent_view(String infoId, String page, String search) {

		hmDto = infoMapper.selectHmContent_view(infoId);

		map.put("hmDto", hmDto);
		map.put("page", page);
		map.put("search", search);

		return map;
	}

	@Override
	public Map<String, Object> HmWrite_view(String userid) {

		map = new HashMap<String, Object>();
		MemberDto memberDto = infoMapper.selectWriteView(userid);

		map.put("memberDto", memberDto);

		return map;
	}

	@Override
	public Map<String, Object> HmWrite(HMcompanyInfoDto hmDto, MultipartFile file) {

		// 원본파일이름
		String fileName = file.getOriginalFilename();
		// 확장자명 가져오기
		String fileNameExtension = FilenameUtils.getExtension(fileName).toLowerCase();
		if (FilenameUtils.getExtension(fileName).toLowerCase() != "") {
			// 파일 저장 위치
			String fileUrl = "C:/Users/User/git/new_wedding_suda/src/main/resources/static/upload/"; // 끝에 /붙여주기 그래야 밑에
																									// 파일이 저장됨
			// 신규파일이름 ( 32자리이름생성.확장자명 )
			String uploadFileName = RandomStringUtils.randomAlphanumeric(32) + "." + fileNameExtension;
			File f = new File(fileUrl + uploadFileName);
			try {
				file.transferTo(f);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 파일이름저장
			hmDto.setC_fileName(uploadFileName);
			;
		} else {
			hmDto.setC_fileName("");
			;
		}

		int writeCheck = infoMapper.insertHmWrite(hmDto);

		map.put("writeCheck", writeCheck);
		return map;
	}

	@Override
	public Map<String, Object> HmModifyView(String infoId, String page, String search) {

		hmDto = infoMapper.selectHmModifyView(infoId);
		System.out.println("파일이름 : " + hmDto.getC_fileName());

		map.put("hmDto", hmDto);
		map.put("page", page);
		map.put("search", search);

		return map;
	}

	@Override
	public Map<String, Object> HmModify(HMcompanyInfoDto hmDto, MultipartFile file) {
		
		System.out.println("impl infoId : "+hmDto.getInfoId());
		// 원본파일이름
		if (file.getSize() != 0) { // 파일사이즈가 0이 아니면
			String orgfileName = file.getOriginalFilename();
			System.out.println("impl : " + orgfileName);
			// 파일 저장 위치
			String fileUrl = "C:/Users/User/git/new_wedding_suda/src/main/resources/static/upload/"; // 끝에 /붙여주기 그래야 밑에
																									// 저장됨
			// 신규파일이름 ( 32자리이름생성.확장자명 )
			// 이름에 시간추가
			long time = System.currentTimeMillis();
			String uploadFileName = String.format("%d_%s", time, orgfileName);
			File f = new File(fileUrl + uploadFileName);
			try {
				file.transferTo(f);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 파일이름저장
			hmDto.setC_fileName(uploadFileName);
		} else {
			// 기존 파일이름을 그대로 저장시키면 됨.
			
		}

		int ModifyCheck = infoMapper.updateHmModify(hmDto);

		map.put("ModifyCheck", ModifyCheck);

		return map;

	}

	@Override
	public Map<String, Object> HmDelete(String infoId, String page, String search) {

		infoMapper.deleteHmDelete(infoId);

		map.put("page", page);
		map.put("search", search);

		return map;
	}

	@Override
	public Map<String, Object> TravelList(String listPage) {

		list4 = new ArrayList<TravelcompanyInfoDto>();

		//이 글을 올린 사람의 아이디와 현재 세션에 저장된 아이디를 비교
		
		int page = 1; // 첫페이지 초기화
		int limit = 9; // 한 페이지에 나오는 게시글 수 : 9

		// page데이터가 있으면 데이터 값 적용
		if (listPage != null && listPage != "") {
			page = Integer.parseInt(listPage);
		}

		int startrow = (page - 1) * limit + 1; // 시작 게시글번호 1,11,21...
		int endrow = startrow + limit - 1; // 마지막 게시글번호 10,20,30...

		// 리스트 가져오기

		list4 = infoMapper.selectTravelListAll(startrow, endrow);

		map = pageNumber.travelPageNumber(page, limit);

		map.put("list", list4);

		
		return map;
	}

	@Override
	public Map<String, Object> TravelWrite_view(String userid) {

		map = new HashMap<String, Object>();
		
		MemberDto memberDto = infoMapper.selectWriteView(userid);
		System.out.println("작성자 이름 : "+memberDto.getCom_name());

		map.put("memberDto", memberDto);
		
		return map;
	}

	@Override
	public Map<String, Object> TravelWrite(TravelcompanyInfoDto traDto, MultipartFile file1, MultipartFile file2) {

		System.out.println("userid : "+traDto.getUserid());
		String fileUrl = "C:/Users/User/git/new_wedding_suda/src/main/resources/static/upload/"; // 끝에 /붙여주기 그래야 밑에

		// 원본파일이름
		String fileName1 = file1.getOriginalFilename();
		System.out.println("대표이미지 : " + fileName1);
		String fileName2 = file2.getOriginalFilename();
		System.out.println("로고 : " + fileName2);
		// 확장자명 가져오기
		String fileNameExtension1 = FilenameUtils.getExtension(fileName1).toLowerCase();
		String fileNameExtension2 = FilenameUtils.getExtension(fileName2).toLowerCase();

		if (FilenameUtils.getExtension(fileName1).toLowerCase() != "") {
			// 파일 저장 위치
			// 신규파일이름 ( 32자리이름생성.확장자명 )
			String uploadFileName1 = RandomStringUtils.randomAlphanumeric(32) + "." + fileNameExtension1;
			// 파일이 저장됨
			File f1 = new File(fileUrl + uploadFileName1);
			try {
				file1.transferTo(f1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			traDto.setC_image(uploadFileName1);

			if (FilenameUtils.getExtension(fileName2).toLowerCase() != "") {
				String uploadFileName2 = RandomStringUtils.randomAlphanumeric(32) + "." + fileNameExtension2;

				File f2 = new File(fileUrl + uploadFileName2);
				try {
					file2.transferTo(f2);
				} catch (Exception e) {
					e.printStackTrace();
				}
				// 파일이름저장
				traDto.setC_logo(uploadFileName2);
			} else {
				traDto.setC_logo("");
			}
		} else {
			traDto.setC_image("");
		}

		int writeCheck = infoMapper.insertTravelWrite(traDto);

		map.put("writeCheck", writeCheck);

		return map;
	}

	@Override
	public Map<String, Object> TravelModifyView(String infoId, String page, String search) {

		traDto = infoMapper.selectTravelModifyView(infoId);
		System.out.println("업체명 : "+traDto.getCom_name());
		System.out.println("대표이미지 : " + traDto.getC_image());

		map.put("traDto", traDto);
		map.put("page", page);
		map.put("search", search);

		return map;
	}

	@Override
	public Map<String, Object> TravelModify(TravelcompanyInfoDto traDto, MultipartFile file1, MultipartFile file2) {

		// 파일 저장 위치
		String fileUrl = "C:/Users/User/git/new_wedding_suda/src/main/resources/static/upload/"; // 끝에 /붙여주기 그래야 밑에
		long time = System.currentTimeMillis(); // (이름에 시간추가) 하기 위해 선언
		// 원본파일이름
		String orgfileName1 = file1.getOriginalFilename();
		String orgfileName2 = file2.getOriginalFilename();
		System.out.println("impl : " + orgfileName1);
		if (file1.getSize() != 0) { // 파일사이즈가 0이 아니면
			// 신규파일이름 ( 32자리이름생성.확장자명 ),(이름에 시간추가)
			String uploadFileName1 = String.format("%d_%s", time, orgfileName1);
			File f1 = new File(fileUrl + uploadFileName1);
			try {
				file1.transferTo(f1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 파일이름저장
			traDto.setC_image(uploadFileName1);

			if (file2.getSize() != 0) {
				String uploadFileName2 = String.format("%d_%s", time, orgfileName2);
				File f2 = new File(fileUrl + uploadFileName2);
				try {
					file2.transferTo(f2);
				} catch (Exception e) {
					e.printStackTrace();
				}
				traDto.setC_logo(uploadFileName2);
			}
		} else {
			// 기존 파일이름을 그대로 저장시키면 됨.
		}

		int modifyCheck = infoMapper.updateTravelModify(traDto);

		map.put("modifyCheck", modifyCheck);

		return map;
	}

	@Override
	public void TravelDelete(String infoId) {

		infoMapper.deleteTravelDelete(infoId);

	}

	@Override
	public Map<String, Object> QuestionList(String listPage, String search) {

		q_list = new ArrayList<questionBoardDto>();
		System.out.println("listPage : " + listPage);

		int page = 1; // 첫페이지 초기화
		int limit = 10; // 한 페이지에 나오는 게시글 수 : 15

		// page데이터가 있으면 데이터 값 적용
		if (listPage != null && listPage != "") {
			page = Integer.parseInt(listPage);
		}
		System.out.println("page : " + page);

		int startrow = (page - 1) * limit + 1; // 시작 게시글번호 1,11,21...
		int endrow = startrow + limit - 1; // 마지막 게시글번호 10,20,30...

		// 리스트 가져오기

		if (search == null || search.equals("")) {
			q_list = infoMapper.selectQuestionListAll(startrow, endrow);
		} else {
			q_list = infoMapper.selectQuestionListSearch(startrow, endrow, search);
		}

		map = pageNumber.QuestionPageNumber(page, limit, search);

		map.put("q_list", q_list);

		return map;

	}
	
	@Override
	public Map<String, Object> QuestionContent_view(String bid, String page, String search) {

		//컨텐츠뷰 클릭시 조회수 증가
		infoMapper.updateQuestionUpHit(bid);
		
		//이전글,다음글
		if(search == null || search == "") {
			preDto = infoMapper.selectQuestionPreView(bid);
			nextDto = infoMapper.selectQuestionNextView(bid); 
		}else {
			preDto = infoMapper.selectQuestionPreViewSearch(bid,search);
			nextDto = infoMapper.selectQuestionNextViewSearch(bid,search); 
		}
		
		queDto = infoMapper.selectQuestionContentView(bid);
		
		
		

		map.put("preDto", preDto);
		map.put("nextDto", nextDto);
		
		map.put("queDto", queDto);
		map.put("page", page);
		map.put("search", search);

		return map;
	}

	@Override
	public Map<String, Object> QuestionWrite_view(String userid) {
		map = new HashMap<String, Object>();
		MemberDto memberDto = infoMapper.selectWriteView(userid);

		map.put("memberDto", memberDto);
		
		return map;
	}

	@Override
	public Map<String, Object> QuestionWrite(questionBoardDto queDto, MultipartFile file) {

		// 파일 저장 위치
		String fileUrl = "C:/Users/User/git/new_wedding_suda/src/main/resources/static/upload/"; // 끝에 /붙여주기 그래야 밑에
		long time = System.currentTimeMillis(); // (이름에 시간추가) 하기 위해 선언
		// 원본파일이름
		String orgfileName = file.getOriginalFilename();
		System.out.println("impl : " + orgfileName);
		if (file.getSize() != 0) { // 파일사이즈가 0이 아니면
			// 신규파일이름 ( 32자리이름생성.확장자명 ),(이름에 시간추가)
			String uploadFileName = String.format("%d_%s", time, orgfileName);
			File f = new File(fileUrl + uploadFileName);
			try {
				file.transferTo(f);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 파일이름저장
			queDto.setFileName(uploadFileName);
		} else {
			queDto.setFileName("");
		}
		
		

		int writeCheck = infoMapper.insertQuestionWrite(queDto);

		map.put("writeCheck", writeCheck);

		return map;
	}


	@Override
	public Map<String, Object> QuestionModifyView(String bid, String page, String search) {

		queDto = infoMapper.selectQuestionModifyView(bid);

		map.put("queDto", queDto);
		map.put("page", page);
		map.put("search", search);
		
		System.out.println("bid : "+queDto.getBid());

		return map;
	}

	@Override
	public Map<String, Object> QuestionModify(questionBoardDto queDto, MultipartFile file) {

		// 파일 저장 위치
		String fileUrl = "C:/Users/User/git/new_wedding_suda/src/main/resources/static/upload/"; // 끝에 /붙여주기 그래야 밑에
		long time = System.currentTimeMillis(); // (이름에 시간추가) 하기 위해 선언
		// 원본파일이름
		String orgfileName = file.getOriginalFilename();
		System.out.println("impl : " + orgfileName);
		if (file.getSize() != 0) { // 파일사이즈가 0이 아니면
			// 신규파일이름 ( 32자리이름생성.확장자명 ),(이름에 시간추가)
			String uploadFileName = String.format("%d_%s", time, orgfileName);
			File f = new File(fileUrl + uploadFileName);
			try {
				file.transferTo(f);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 파일이름저장
			queDto.setFileName(uploadFileName);
		} else {
			queDto.setFileName("");
		}

		int modifyCheck = infoMapper.updateQuestionModify(queDto);
		map.put("modifyCheck", modifyCheck);

		return map;
	}

	@Override
	public Map<String, Object> QuestionDelete(String bid,String page,String search) {
		
		infoMapper.deleteQuestionDelete(bid);
		map.put("page", page);
		map.put("search", search);
		
		return map;
		
	}

	@Override
	public Map<String, Object> QuestionReply(questionBoardDto queDto, String page, String search) {
		
		int replyCheck = infoMapper.insertQuestionReply(queDto);
		map.put("replyCheck", replyCheck);
		
		return map;
	}

}
