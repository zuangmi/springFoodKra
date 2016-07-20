package com.fweb.controller;


import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.fweb.dto.apiDTO;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/")
public class HomeController  {
	
	RestTemplate restTemplateService= new RestTemplate();
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value ={"/" , "index"}, method = RequestMethod.GET)
	public String home() throws Exception{
	
		return "index";
	}
	
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String test() throws Exception{
		
		test1();
		
		return "index";
	}
	
	public String test1() throws Exception{
		String age="26";
		String sex="m";
		JSONParser jsonparser = new JSONParser();
		JSONObject jsonobject;
		String uri = "http://api.dbstore.or.kr:8880/foodinfo/get_id.do?api_key=Mjg2LTE0NjkwMTcwODY0NzMtYWZiOTc0MzItODA5MC00ODA1LWI5NzQtMzI4MDkwZjgwNTJk&area=����&sex="+sex+"&age="+age;

		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		headers.add("x-waple-authorization", "Mjg2LTE0NjkwMTcwODY0NzMtYWZiOTc0MzItODA5MC00ODA1LWI5NzQtMzI4MDkwZjgwNTJk");
			
		HttpEntity<String> entity = new HttpEntity<String>("parameters",headers);
		ResponseEntity<String> result =  restTemplate.exchange(uri,HttpMethod.GET,entity, String.class);
		System.out.println("restlt: "+result);
		System.out.println("please : "+result.getBody());
		jsonobject = (JSONObject) jsonparser.parse(result.getBody());
		
		String ans =  jsonobject.get("uid").toString();
		
		System.out.println("uid : "+ans);
		return "";
	}

}



