package com.fweb.persistence;

import java.util.List;

import com.fweb.domain.FoodVO;
import com.fweb.domain.SearchCriteria;

public interface FoodDAO {

	public FoodVO selectDetail(String food_barcode) throws Exception;
	
	public List<FoodVO> listSearch(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;

}
