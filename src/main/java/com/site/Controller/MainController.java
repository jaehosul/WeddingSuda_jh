package com.site.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.site.service.InquiryBoard;

@Controller
public class MainController {
	
	@Autowired
	InquiryBoard inquiryBoard;
	
	//변수선언
	Map<String, Object> map;

	@RequestMapping("/main/main")
	public String main(@RequestParam @Nullable String page, 			
			@RequestParam @Nullable String search, Model model) {
		
		
		map = inquiryBoard.boardListAll(page, search);
		
		model.addAttribute("map", map);
		
		return "/main/main";
	}
	
	
	
	
}//class
