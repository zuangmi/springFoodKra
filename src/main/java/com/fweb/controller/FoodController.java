package com.fweb.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fweb.domain.FoodVO;
import com.fweb.domain.PageMaker;
import com.fweb.domain.SearchCriteria;
import com.fweb.service.FoodService;

@Controller
@RequestMapping("/food")
public class FoodController {
 
	@Inject
	private FoodService service;

	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		model.addAttribute("list", service.listSearchCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(cri));

		model.addAttribute("pageMaker", pageMaker);
	}

	@RequestMapping(value = "/selectFood", method = RequestMethod.GET)
	public ModelAndView selectDetail(@RequestParam("bcode") String food_barcode) throws Exception {

		FoodVO vo = service.selectDetail(food_barcode);

		ModelAndView mav = new ModelAndView("/food/selectDetail");
		mav.addObject("FoodVO", vo);
		return mav;

	}
}