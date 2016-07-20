package com.fweb.service;

import java.util.List;

import com.fweb.domain.FoodVO;
import com.fweb.domain.SearchCriteria;

public interface FoodService {

	public FoodVO selectDetail(String food_barcode) throws Exception;

	public List<FoodVO> listSearchCriteria(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;
}
