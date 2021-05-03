package com.site.Controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.site.dto.inquiry_boardDto;
import com.site.service.InquiryBoard;
import com.site.service.Inquiry_PageNumber;

@Controller
public class InquiryController {
	
	@Autowired
	InquiryBoard inquiryBoard;
	
	//변수선언
	Map<String, Object> map;

	@RequestMapping("/inquiry/inquiry_main")
	public String inquiry_main(@RequestParam @Nullable String page, 			
			@RequestParam @Nullable String search, Model model) {
		
		map = inquiryBoard.boardListAll(page, search);
		
		model.addAttribute("map", map);
		
		return "/inquiry/inquiry_main";
	}
	
	@RequestMapping("/inquiry/inquiry_write_view")
	public String inquiry_write_view() {
		return "/inquiry/inquiry_write_view";
	}
	
	@RequestMapping("/inquiry/inquiry_content_view")
	public String inquiry_content_view(@RequestParam String bid, @RequestParam @Nullable String page, 
			@RequestParam @Nullable String search, Model model, HttpServletRequest request, HttpServletResponse response) {
		
		map = inquiryBoard.boardContentView(bid, page, search, request, response);
		
		model.addAttribute("map", map);
		
		return "/inquiry/inquiry_content_view";
	}
	
	@RequestMapping("/inquiry/writeCheck")
	public String writeCheck(inquiry_boardDto inqDto, 
			@RequestPart MultipartFile file, Model model) {
		
		
		inquiryBoard.boardWrite(inqDto, file);
		model.addAttribute("map", map);
		
		return "redirect:/inquiry/inquiry_main";    //redirect는 컨트롤러를 거쳐서 가는 것!
	}
	
	@RequestMapping("/inquiry/delete")
	public String delete(@RequestParam String bid, @RequestParam @Nullable String page, 
			@RequestParam @Nullable String search, Model model) throws Exception {
		
		//URL을 통해서 보내는 검색어(search) 한글 깨짐 처리(return을 redirect로 보내기 때문)
		search = URLEncoder.encode(search, "utf-8");
		
		inquiryBoard.boardDelete(bid, page, search);
		model.addAttribute("map", map);
		
		return "redirect:/inquiry/inquiry_main?page="+page+"&search="+search;    //redirect는 컨트롤러를 거쳐서 가는 것!
	}
	
	@RequestMapping("/inquiry/inquiry_modify_view")
	public String inquiry_modify_view(@RequestParam String bid, @RequestParam @Nullable String page, 
			@RequestParam @Nullable String search, Model model) {
		
		map = inquiryBoard.boardModify_view(bid, page, search);
		model.addAttribute("map", map);
		
		return "/inquiry/inquiry_modify_view";
	}
	
	@RequestMapping("/inquiry/modify")
	public String inquiry_modify(inquiry_boardDto inqDto, @RequestPart MultipartFile file, 
			@RequestParam @Nullable String page, 
			@RequestParam @Nullable String search, Model model) throws Exception {
		
		//URL을 통해서 보내는 검색어(search) 한글 깨짐 처리(return을 redirect로 보내기 때문)
		search = URLEncoder.encode(search, "utf-8");
		
		inquiryBoard.boardModify(inqDto, file, page, search);
		model.addAttribute("map", map);
		
		return "redirect:/inquiry/inquiry_main?page="+page+"&search="+search;    //redirect는 컨트롤러를 거쳐서 가는 것!
	}
	
	@RequestMapping("/inquiry/inquiry_reply_view")
	public String inquiry_reply_view(@RequestParam String bid, @RequestParam @Nullable String page, 
			@RequestParam @Nullable String search, Model model) {
		
		map = inquiryBoard.boardModify_view(bid, page, search);
		model.addAttribute("map", map);
		
		return "/inquiry/inquiry_reply_view";
	}
	
	@RequestMapping("/inquiry/reply")
	public String inquiry_reply(inquiry_boardDto inqDto, 
			@RequestPart MultipartFile file, 
			@RequestParam @Nullable String page, 
			@RequestParam @Nullable String search, Model model) throws Exception {
		
		
		//URL을 통해서 보내는 검색어(search) 한글 깨짐 처리(return을 redirect로 보내기 때문)
		search = URLEncoder.encode(search, "utf-8");
		
		inquiryBoard.boardReply(inqDto, file, page, search);
		model.addAttribute("map", map);
		
		return "redirect:/inquiry/inquiry_main?page="+page+"&search="+search;    //redirect는 컨트롤러를 거쳐서 가는 것!
	}
	
	@RequestMapping("/inquiry/inquiry_replyCheck")
	public String inquiry_replyCheck(@RequestParam String bid, @RequestParam @Nullable String page, 
			@RequestParam @Nullable String search, Model model) throws Exception {
		
		//URL을 통해서 보내는 검색어(search) 한글 깨짐 처리(return을 redirect로 보내기 때문)
		search = URLEncoder.encode(search, "utf-8");

		
		inquiryBoard.boardReplyPointCheck(bid, page, search);
		model.addAttribute("map", map);
		
		return "/inquiry/replyPointComplete";
	}
	
	

	
}//class
