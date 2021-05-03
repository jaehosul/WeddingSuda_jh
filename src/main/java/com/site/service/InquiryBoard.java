package com.site.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.site.dto.inquiry_boardDto;

public interface InquiryBoard {

	Map<String, Object> boardListAll(String page, String search);
	Map<String, Object> boardContentView(String bid, String page, String search, HttpServletRequest request, HttpServletResponse response);
	void boardWrite(inquiry_boardDto inqDto, MultipartFile file);
	void boardDelete(String bid, String page, String search);
	Map<String, Object> boardModify_view(String bid, String page, String search);
	void boardModify(inquiry_boardDto inqDto, MultipartFile file, String page, String search);
	void boardReply(inquiry_boardDto inqDto, MultipartFile file, String page, String search);
	void boardReplyPointCheck(String bid, String page, String search);
	
	
	
	

}//interface
