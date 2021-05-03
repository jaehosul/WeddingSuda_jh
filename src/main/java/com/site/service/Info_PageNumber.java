package com.site.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.site.mapper.InfoMapper;

@Component
public class Info_PageNumber {
	
	@Autowired
	InfoMapper infoMapper;

	// 하단 넘버링 정보메소드
	public Map<String, Object> stuPageNumber(int page, int limit,String search) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		int listCount = 0;
		
		if(search == null || search.equals("")) {
			// 전체리스트 개수메소드
			listCount = infoMapper.StuListCount();
		}else {
			listCount = infoMapper.StuListCountSearch(search);
		}

		// 최대 페이지 수
		int maxPage = (int) ((double) listCount / limit + 0.95); // 34/10+0.95=4.35(int)4.35-> 4
		// 첫 페이지 번호 10페이지/10+0.9=1.9->1-1=0*10+1= 1
		int startPage = ((int) ((double) page / limit + 0.9) - 1) * limit + 1;
		System.out.println("startPage : "+startPage);
		// 마지막 페이지 번호
		int endPage = maxPage;
		if (endPage > (startPage + limit - 1)) endPage = startPage + limit - 1;

		map.put("page", page);
		map.put("listCount", listCount);
		map.put("maxPage", maxPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("search", search);
		
		return map;
	}

	public Map<String, Object> DrePageNumber(int page, int limit, String search) {
		Map<String, Object> map = new HashMap<String, Object>();
		int listCount = 0;
		
		if(search == null || search.equals("")) {
			// 전체리스트 개수메소드
			listCount = infoMapper.DreListCount();
		}else {
			listCount = infoMapper.DreListCountSearch(search);
		}

		// 최대 페이지 수
		int maxPage = (int) ((double) listCount / limit + 0.95); // 34/10+0.95=4.35(int)4.35-> 4
		// 첫 페이지 번호 10페이지/10+0.9=1.9->1-1=0*10+1= 1
		int startPage = ((int) ((double) page / limit + 0.9) - 1) * limit + 1;
		System.out.println("startPage : "+startPage);
		// 마지막 페이지 번호
		int endPage = maxPage;
		if (endPage > (startPage + limit - 1)) endPage = startPage + limit - 1;

		map.put("page", page);
		map.put("listCount", listCount);
		map.put("maxPage", maxPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("search", search);
		
		return map;
	}

	public Map<String, Object> HmPageNumber(int page, int limit, String search) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		int listCount = 0;
		
		if(search == null || search.equals("")) {
			// 전체리스트 개수메소드
			listCount = infoMapper.HmListCount();
		}else {
			listCount = infoMapper.HmListCountSearch(search);
		}

		// 최대 페이지 수
		int maxPage = (int) ((double) listCount / limit + 0.95); // 34/10+0.95=4.35(int)4.35-> 4
		// 첫 페이지 번호 10페이지/10+0.9=1.9->1-1=0*10+1= 1
		int startPage = ((int) ((double) page / limit + 0.9) - 1) * limit + 1;
		System.out.println("startPage : "+startPage);
		// 마지막 페이지 번호
		int endPage = maxPage;
		if (endPage > (startPage + limit - 1)) endPage = startPage + limit - 1;

		map.put("page", page);
		map.put("listCount", listCount);
		map.put("maxPage", maxPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("search", search);
		
		return map;
	}

	public Map<String, Object> travelPageNumber(int page, int limit) { 
		
		Map<String, Object> map = new HashMap<String, Object>();
		int listCount = 0;
		
		listCount = infoMapper.TravelListCount();
		

		// 최대 페이지 수
		int maxPage = (int) ((double) listCount / limit + 0.95); // 34/10+0.95=4.35(int)4.35-> 4
		// 첫 페이지 번호 10페이지/10+0.9=1.9->1-1=0*10+1= 1
		int startPage = ((int) ((double) page / limit + 0.9) - 1) * limit + 1;
		System.out.println("startPage : "+startPage);
		// 마지막 페이지 번호
		int endPage = maxPage;
		if (endPage > (startPage + limit - 1)) endPage = startPage + limit - 1;

		map.put("page", page);
		map.put("listCount", listCount);
		map.put("maxPage", maxPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		
		return map;
	}

	public Map<String, Object> QuestionPageNumber(int page, int limit, String search) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		int listCount = 0;
		
		if(search==null || search.equals("")) {
			listCount = infoMapper.QuestionListCount();
		}else {
			listCount = infoMapper.QuestionListCountSearch(search);
		}
		System.out.println("listCount : "+listCount);

		// 최대 페이지 수
		int maxPage = (int) ((double) listCount / limit + 0.95); // 34/10+0.95=4.35(int)4.35-> 4
		// 첫 페이지 번호 10페이지/10+0.9=1.9->1-1=0*10+1= 1
		int startPage = ((int) ((double) page / limit + 0.9) - 1) * limit + 1;
		System.out.println("page : "+page);
		System.out.println("limit : "+limit);
		System.out.println("startPage : "+startPage);
		// 마지막 페이지 번호
		int endPage = maxPage;
		if (endPage > (startPage + limit - 1)) endPage = startPage + limit - 1;

		map.put("page", page);
		map.put("listCount", listCount);
		map.put("maxPage", maxPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		
		return map;
	}

	

}
