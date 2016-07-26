package com.fweb.controller;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fweb.domain.FoodVO;
import com.fweb.service.FoodService;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/")
public class HomeController  {
	@Inject
	private FoodService service;
	
	String uid;
	RestTemplate restTemplateService= new RestTemplate();
	RestTemplate restTemplate = new RestTemplate();

	JSONParser jsonparser = new JSONParser();
	JSONObject jsonobject;
	
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
	
		String uri = "http://api.dbstore.or.kr:8880/foodinfo/get_id.do?api_key=Mjg2LTE0NjkwMTcwODY0NzMtYWZiOTc0MzItODA5MC00ODA1LWI5NzQtMzI4MDkwZjgwNTJk&area=서울&sex="+sex+"&age="+age;

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
		uid=ans;
		
		return "";
	}

	@RequestMapping(value = "/food/selectFood", method = RequestMethod.GET)
	public ModelAndView selectDetail(@RequestParam("bcode") String food_barcode) throws Exception {
		System.out.println("foodbarcode : "+food_barcode);
	
		String search = "365 유기농아침 오렌지";
		
		String searchuri ="http://api.dbstore.or.kr:8880/foodinfo/search.do?uid=KICC6ZH2&w="+search;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		headers.add("x-waple-authorization", "Mjg2LTE0NjkwMTcwODY0NzMtYWZiOTc0MzItODA5MC00ODA1LWI5NzQtMzI4MDkwZjgwNTJk");
			
		HttpEntity<String> entity = new HttpEntity<String>("parameters",headers);
	
		ResponseEntity<String> searchresult =  restTemplate.exchange(searchuri,HttpMethod.GET,entity, String.class);
		
		jsonobject = (JSONObject) jsonparser.parse(searchresult.getBody());
		
		List<String> list= new ArrayList<String>();
		JSONArray array=(JSONArray) jsonobject.get("food_list");
		JSONObject ob;
		for(int i=0;i<array.size();i++){
			ob = (JSONObject)array.get(i);
			list.add(ob.toString());
		}
		
		ob=(JSONObject)jsonparser.parse(list.get(0));
		System.out.println(ob);
		String food_name=ob.get("food_name").toString();
		String code=ob.get("code").toString();
		String seq=ob.get("seq_code").toString();
		String food_image=ob.get("thumb_img").toString();
		System.out.println("foodname : "+food_name+" food_image :"+food_image);
		
		String detailSearchuri ="http://api.dbstore.or.kr:8880/foodinfo/food_detail.do?uid=KICC6ZH2&c="+code+"&s="+seq;
		ResponseEntity<String> detailSearchresult =  restTemplate.exchange(detailSearchuri,HttpMethod.GET,entity, String.class);
		jsonobject = (JSONObject) jsonparser.parse(detailSearchresult.getBody());
		List<String> detaillist= new ArrayList<String>();
		JSONArray detailarray = (JSONArray) jsonobject.get("ing_list");
	
		for(int i=0;i<detailarray.size();i++){
			ob=(JSONObject)detailarray.get(i);
			detaillist.add(ob.toString());
			System.out.println("detaillist"+i+" : "+ob);
		}

		ob=(JSONObject)jsonparser.parse(detaillist.get(0)); //열량
		String food_energys = ob.get("vol_str").toString();
		
		
		ob=(JSONObject)jsonparser.parse(detaillist.get(1)); //탄수화물
		String food_calbos = ob.get("vol_str").toString();
		
		ob=(JSONObject)jsonparser.parse(detaillist.get(3)); //단백질
		 String food_proteins = ob.get("vol_str").toString();
		 
		 ob=(JSONObject)jsonparser.parse(detaillist.get(4)); //지방
		 String food_fats = ob.get("vol_str").toString();
		 
		 ob=(JSONObject)jsonparser.parse(detaillist.get(5)); //콜레스테롤
		 String food_chols = ob.get("vol_str").toString();
	
		 ob=(JSONObject)jsonparser.parse(detaillist.get(6)); //나트륨
		 String food_nas = ob.get("vol_str").toString();
		 
		 System.out.println("열량:"+food_energys+" 탄수화물 : "+food_calbos+" 단백질 : "+food_proteins+" 지방 : "+food_fats+" 콜레스테롤 : "+food_chols+" 나트륨 : "+food_nas);
		 FoodVO vo = new FoodVO();
		
		 vo.setFood_calbos(food_calbos);
		 vo.setFood_chols(food_chols);
		 vo.setFood_energys(food_energys);
		 vo.setFood_nas(food_nas);
		 vo.setFood_proteins(food_proteins);
		 vo.setFood_fats(food_fats);
		 vo.setFood_image(food_image);
		 vo.setFood_name(food_name);
		 
		 
		//FoodVO vo = service.selectDetail(food_barcode);
		
		ModelAndView mav = new ModelAndView("/food/selectDetail");
		mav.addObject("FoodVO", vo);
		return mav;

	}
}



