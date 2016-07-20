package com.fweb.controller;

import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fweb.domain.MemberVO;
import com.fweb.dto.LoginDTO;
import com.fweb.email.Email;
import com.fweb.email.EmailSender;
import com.fweb.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Inject
	private MemberService service;

	@Autowired
	private EmailSender emailSender;

	@Autowired
	private Email email;

	//로그인 폼
	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public String loginForm() {
		return "/member/loginForm";
	}

	// 로그인
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginSend(@ModelAttribute LoginDTO dto) throws Exception {
		System.out.println(dto.getMem_email()+" "+dto.getMem_pwd());
		MemberVO vo= service.login(dto);
		System.out.println(vo);
	//System.out.println(vo.getMem_email()+" "+vo.getMem_pwd());
		
		if(vo==null){
			String msg="회원정보가 일치하지 않습니다. 확인 후 다시 입력해주세요.";
			ModelAndView mav=new ModelAndView("/member/loginForm");
			mav.addObject("msg",msg);
			return mav;
		}

		return new ModelAndView("redirect:/food/listPage");
	}

	//회원가입 폼
	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public String registerForm() {
		return "/member/registerForm";
	}
	
	//회원가입-아이디 중복 체크
	@RequestMapping(value = "/idcheck", method = RequestMethod.POST)
	public void idcheck(@RequestParam String mem_email,HttpServletResponse resp) throws Exception{
		//System.out.println("왔다.");
		
		int resultCnt = service.checkMemberId(mem_email);
		String result="";
		
		if (resultCnt == 0) {
			result="true";
		} else {
			result="false";
		}
		
		JSONObject ob = new JSONObject();
		ob.put("result", result);
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print(ob.toString());

	}
	
	// 회원가입
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerSend(@ModelAttribute MemberVO vo) throws Exception {
		
		System.out.println("왔다.");
		service.insertMember(vo);
		ModelAndView mav=new ModelAndView("/member/loginForm");
		return mav;
	}
	
	//비밀번호 찾기 폼
	@RequestMapping(value = "/forgotPwForm", method = RequestMethod.GET)
	public String forgotPwForm() {
		return "/member/forgotPwForm";
	}

	// 비밀번호 찾기 메일
	@RequestMapping(value = "/forgotPw", method = RequestMethod.POST)
	public ModelAndView forgotPwPost(@RequestParam("mem_email") String mem_email) throws Exception {

		ModelAndView mav;
		String pw = service.forgotPwSearch(mem_email);
		//System.out.println(pw);

		if (pw != null) {
			email.setContent("비밀번호는 " + pw + " 입니다.");
			email.setReceiver(mem_email);
			email.setSubject("비밀번호 찾기 메일입니다.");
			emailSender.SendEmail(email);

			mav=new ModelAndView("redirect:/member/loginForm");
		}else{
			mav=new ModelAndView("redirect:/member/forgotPwForm");
		}
		
		return mav;
	}
	
}