package com.foreseers.tj.service;

import java.util.List;

import com.foreseers.tj.model.DtProduct;

public interface DtProductService {

	List getProduct();
	
	DtProduct selectByProductID(String googleid);

	List getIapList();

}
