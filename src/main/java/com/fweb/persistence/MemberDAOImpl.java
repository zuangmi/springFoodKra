package com.fweb.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.fweb.domain.MemberVO;
import com.fweb.dto.LoginDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "com.fweb.mapper.memberMapper";

	@Override
	public MemberVO login(LoginDTO dto) throws Exception {

		return session.selectOne(namespace + ".login", dto);
	}
	
	@Override
	public void insertMember(MemberVO vo){
		session.insert(namespace+".insertMember",vo);
	}

	@Override
	public int checkMemberId(String mem_email) throws Exception{
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".checkMemberId", mem_email);
	}

	@Override
	public String forgotPwSearch(String mem_email) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".forgotPwSearch", mem_email);
	}
	
}
