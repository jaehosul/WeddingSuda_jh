package com.site.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import com.site.dto.DresscompanyInfoDto;
import com.site.dto.HMcompanyInfoDto;
import com.site.dto.MemberDto;
import com.site.dto.StudiocompanyInfoDto;
import com.site.dto.TravelcompanyInfoDto;
import com.site.dto.questionBoardDto;

@Mapper
public interface InfoMapper {

	//스튜디오 리스트 가져오기
	List<StudiocompanyInfoDto> selectStudioListAll(int startrow, int endrow);
	List<StudiocompanyInfoDto> selectStudioListSearch(int startrow, int endrow, String search);

	//스튜디오 리스트 개수 가져오기
	int StuListCount(); 
	int StuListCountSearch(String search);
	
	//스튜디오 컨텐츠보기
	StudiocompanyInfoDto selectStudioContent_view(String infoId);
	
	//스튜디오 리스트와 회원 테이블 조인하기
	MemberDto selectWriteView(String userid);
	
	//스튜디오 상품 게시글 등록(write)
	void insertStudioWrite(StudiocompanyInfoDto stuDto);
	
	//스튜디오 상품 게시글 수정(modify)
	StudiocompanyInfoDto selectStudioModifyView(String infoId);
	int updateStudioModify(StudiocompanyInfoDto stuDto);
	
	//스튜디오 상품 삭제
	void deleteStudioDelete(String infoId);
	
	//드레스 리스트 가져오기
	List<DresscompanyInfoDto> selectDressListAll(int startrow, int endrow);
	List<DresscompanyInfoDto> selectDressListSearch(int startrow, int endrow, String search);
	
	//드레스 리스트 개수 가져오기 
	int DreListCount();
	int DreListCountSearch(String search);
	
	//드레스 컨텐츠보기
	DresscompanyInfoDto selectDressContent_view(String infoId);
	
	//드레스 상품 게시글 등록(write)
	int insertDressWrite(DresscompanyInfoDto dreDto);
	
	//드레스 상품 수정(modify)
	DresscompanyInfoDto selectDressModifyView(String infoId);
	int updateDressModify(DresscompanyInfoDto dreDto);
	
	//드레스 상품 삭제
	void deleteDressDelete(String infoId);
	
	//헤어페이크업 리스트 가져오기
	List<HMcompanyInfoDto> selectHmListAll(int startrow, int endrow);
	List<HMcompanyInfoDto> selectHmListSearch(int startrow, int endrow, String search);
	
	//헤어페이크업 리스트 개수 가져오기
	int HmListCount();
	int HmListCountSearch(String search);
	
	//헤어메이크업 컨텐츠보기
	HMcompanyInfoDto selectHmContent_view(String infoId);
	
	//헤어메이크업 상품 게시글 등록(write)
	int insertHmWrite(HMcompanyInfoDto hmDto);
	
	//헤어메이크업 상품 수정(modify)
	HMcompanyInfoDto selectHmModifyView(String infoId);
	int updateHmModify(HMcompanyInfoDto hmDto);
	
	//헤어메이크업 상품 삭제
	void deleteHmDelete(String infoId);
	
	//신혼여행 리스트가져오기(허니문은 검색없음)
	List<TravelcompanyInfoDto> selectTravelListAll(int startrow, int endrow);
	
	//신혼여행 리스트 개수 가져오기
	int TravelListCount();
	
	//신혼여행 상품 게시글 등록(write)
	int insertTravelWrite(TravelcompanyInfoDto traDto);
	
	//신혼여행 상품 게시글 수정(modify)
	TravelcompanyInfoDto selectTravelModifyView(String infoId); 
	int updateTravelModify(TravelcompanyInfoDto traDto); 
	
	//신혼여행 상품 삭제
	void deleteTravelDelete(String infoId); 
	
	//신혼여행 문의게시판 리스트 가져오기
	List<questionBoardDto> selectQuestionListAll(int startrow, int endrow);
	List<questionBoardDto> selectQuestionListSearch(int startrow, int endrow, String search);
	
	
	//신혼여행 문의게시판 리스트 개수 가져오기(얘네는 pageNumber에서 들어옴)
	int QuestionListCount();
	int QuestionListCountSearch(String search);
	
	//문의게시판 컨텐츠보기 (컨텐츠 클릭할 경우 조회수 증가,이전글,다음글)
	void updateQuestionUpHit(String bid);   
	questionBoardDto selectQuestionContentView(String bid); 
	
	questionBoardDto selectQuestionPreView(String bid);  
	questionBoardDto selectQuestionNextView(String bid); 
	//문의게시판에서 검색하고 그 컨텐츠뷰를 들어온 경우
	questionBoardDto selectQuestionPreViewSearch(String bid, String search);
	questionBoardDto selectQuestionNextViewSearch(String bid, String search);
	
	//문의게시판 글쓰기(write)
	int insertQuestionWrite(questionBoardDto queDto);
	
	//문의게시판 글수정(modify)
	questionBoardDto selectQuestionModifyView(String bid);
	int updateQuestionModify(questionBoardDto queDto);
	
	//문의게시판 글삭제
	void deleteQuestionDelete(String bid);
	
	//문의게시판 답글달기
	int insertQuestionReply(questionBoardDto queDto);
	
	
	
	
	
	

}
