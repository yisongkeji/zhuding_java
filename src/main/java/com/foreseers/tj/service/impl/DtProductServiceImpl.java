package com.foreseers.tj.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foreseers.tj.mapper.DtProductMapper;
import com.foreseers.tj.model.DtProduct;
import com.foreseers.tj.model.DtProductExample;
import com.foreseers.tj.model.ReturnProduct;
import com.foreseers.tj.service.DtProductService;

@Service
public class DtProductServiceImpl implements DtProductService {

	private final static Logger log = LoggerFactory.getLogger(DtProductServiceImpl.class);
	
	@Autowired
	private DtProductMapper dtProductMapper;
	
	@Override
	public List getProduct() {
		// TODO Auto-generated method stub
		DtProductExample productExample = new DtProductExample();
		productExample.setDistinct(false);
		List<List> retuenlist = new ArrayList<>();
		 List<DtProduct>  list = dtProductMapper.selectByExample(productExample);
		log.info("商品信息列表："+list.toString());
		List<ReturnProduct> listitem = new ArrayList<>();
		List<ReturnProduct> listvip = new ArrayList<>();
		for(DtProduct dtProduct:list) {
		  if(dtProduct.getStatus().equals("Active")) {
			if(dtProduct.getType().equals("item") ) {
				ReturnProduct returnProduct = new ReturnProduct();
				returnProduct.setId(dtProduct.getId());
				returnProduct.setAppleID(dtProduct.getAppleid());
				returnProduct.setGoogleID(dtProduct.getGoogleid());
				returnProduct.setName(dtProduct.getAppname());
				returnProduct.setType(dtProduct.getType());
				listitem.add(returnProduct);
			}
			if(dtProduct.getType().equals("vip")) {
				ReturnProduct returnProduct = new ReturnProduct();
				returnProduct.setId(dtProduct.getId());
				returnProduct.setAppleID(dtProduct.getAppleid());
				returnProduct.setGoogleID(dtProduct.getGoogleid());
				returnProduct.setName(dtProduct.getAppname());
				returnProduct.setType(dtProduct.getType());
				listvip.add(returnProduct);
			}
		  }	
		}
		Collections.sort(listitem);
		Collections.sort(listvip);
		log.info("排序后的listitem"+listitem.toString());
		log.info("排序后的listvip"+listvip.toString());
		retuenlist.add(listitem);
		retuenlist.add(listvip);
		log.info("返回的参数："+retuenlist);
		return retuenlist;
		
	}

	
	
}
