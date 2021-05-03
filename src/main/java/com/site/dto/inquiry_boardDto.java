package com.site.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class inquiry_boardDto {

	private int bid;
	private int bgroup;
	private int bindent;
	private int bhit;
	private int bstep;
	private int replycheck;
	private int clickcheck;
	private String userid;  //ws_member 외래키로 처리 
	private String name;    //join, ws_member
	private String nickName;  //join, ws_member
	private String btitle;
	private String bcontent;
	private String bdate;
	private String filename;  
}
