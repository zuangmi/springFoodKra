package com.fweb.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.fweb.domain.MemberVO;
import com.fweb.dto.LoginDTO;
import com.fweb.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO dao;

	@Override
	public MemberVO login(LoginDTO dto) throws Exception {

		return dao.login(dto);
	}

	@Override
	public void insertMember(MemberVO vo) {
		dao.insertMember(vo);
	}

	@Override
	public int checkMemberId(String mem_email) throws Exception {
		return dao.checkMemberId(mem_email);
	}

	@Override
	public String forgotPwSearch(String mem_email) throws Exception {
		return dao.forgotPwSearch(mem_email);

	}
}
