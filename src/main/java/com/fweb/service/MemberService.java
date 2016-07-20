package com.fweb.service;

import com.fweb.domain.MemberVO;
import com.fweb.dto.LoginDTO;

public interface MemberService {

	public MemberVO login(LoginDTO dto) throws Exception;

	public void insertMember(MemberVO vo);
	
	public int checkMemberId(String mem_email) throws Exception;
	
	public String forgotPwSearch(String mem_email) throws Exception;
}
