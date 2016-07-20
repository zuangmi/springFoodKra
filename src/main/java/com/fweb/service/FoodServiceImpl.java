package com.fweb.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.fweb.domain.FoodVO;
import com.fweb.domain.SearchCriteria;
import com.fweb.persistence.FoodDAO;

@Service
public class FoodServiceImpl implements FoodService {

	@Inject
	private FoodDAO dao;
	
	@Override
	public FoodVO selectDetail(String food_barcode) throws Exception {
		
		return dao.selectDetail(food_barcode);
		
	}

	@Override
	public List<FoodVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		
		 return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {

		return dao.listSearchCount(cri);
	}

}
