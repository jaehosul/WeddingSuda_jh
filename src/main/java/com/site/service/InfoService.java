package com.site.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.site.dto.DresscompanyInfoDto;
import com.site.dto.HMcompanyInfoDto;
import com.site.dto.StudiocompanyInfoDto;
import com.site.dto.TravelcompanyInfoDto;
import com.site.dto.questionBoardDto;

public interface InfoService {

	Map<String, Object> StudioList(String page, String search);

	Map<String, Object> StudioContent_view(String infoId, String page, String search);

	Map<String, Object> StudioWrite(StudiocompanyInfoDto stuDto, MultipartFile file);

	Map<String, Object> StudioModifyView(String infoId, String page, String search);

	Map<String, Object> StudioDelete(String infoId, String page, String search);

	Map<String, Object> StudioModify(StudiocompanyInfoDto stuDto,MultipartFile file);

	Map<String, Object> DressList(String page, String search);

	Map<String, Object> StudioWrite_view(String userid);

	Map<String, Object> DressContent_view(String infoId, String page, String search);

	Map<String, Object> DressWrite_view(String userid);

	Map<String, Object> DressWrite(DresscompanyInfoDto dreDto, MultipartFile file);

	Map<String, Object> DressModifyView(String infoId, String page, String search);

	Map<String, Object> DressModify(DresscompanyInfoDto dreDto, MultipartFile file);

	Map<String, Object> DressDelete(String infoId, String page, String search);

	Map<String, Object> HmList(String page, String search);

	Map<String, Object> HmContent_view(String infoId, String page, String search);

	Map<String, Object> HmWrite_view(String userid);

	Map<String, Object> HmWrite(HMcompanyInfoDto hmDto, MultipartFile file);

	Map<String, Object> HmModifyView(String infoId, String page, String search);

	Map<String, Object> HmModify(HMcompanyInfoDto hmDto, MultipartFile file);

	Map<String, Object> HmDelete(String infoId, String page, String search);

	Map<String, Object> TravelList(String page);

	Map<String, Object> TravelWrite_view(String userid);

	Map<String, Object> TravelWrite(TravelcompanyInfoDto traDto, MultipartFile file1, MultipartFile file2);

	Map<String, Object> QuestionList(String page, String search);

	Map<String, Object> TravelModifyView(String infoId, String page, String search);

	Map<String, Object> TravelModify(TravelcompanyInfoDto traDto, MultipartFile file1, MultipartFile file2);

	void TravelDelete(String infoId);

	Map<String, Object> QuestionWrite_view(String userid);

	Map<String, Object> QuestionWrite(questionBoardDto queDto, MultipartFile file);

	Map<String, Object> QuestionContent_view(String bid, String page, String search);

	Map<String, Object> QuestionModifyView(String bid, String page, String search);

	Map<String, Object> QuestionModify(questionBoardDto queDto, MultipartFile file);

	Map<String, Object> QuestionDelete(String bid, String page, String search);

	Map<String, Object> QuestionReply(questionBoardDto queDto, String page, String search);                         
   

}
