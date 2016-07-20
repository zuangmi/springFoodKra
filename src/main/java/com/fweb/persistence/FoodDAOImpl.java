package com.fweb.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.fweb.domain.FoodVO;
import com.fweb.domain.SearchCriteria;

@Repository
public class FoodDAOImpl implements FoodDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "com.fweb.mapper.FoodMapper";

	@Override
	public FoodVO selectDetail(String food_barcode) throws Exception {

		return session.selectOne(namespace + ".selectDetail", food_barcode);
	}

	@Override
	public List<FoodVO> listSearch(SearchCriteria cri) throws Exception {

		return session.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {

		return session.selectOne(namespace + ".listSearchCount", cri);
	}

}
