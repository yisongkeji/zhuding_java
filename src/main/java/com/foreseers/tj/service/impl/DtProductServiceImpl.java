package com.foreseers.tj.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
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

	/*
	 * 通过googleid查询商品
	 * @see com.foreseers.tj.service.DtProductService#selectByProductID()
	 */
	@Override
	public DtProduct selectByProductID(String googleid) {
		// TODO Auto-generated method stub
		//dtProductMapper.selectByProductID(googleid);
		return dtProductMapper.selectByProductID(googleid);
	}

	@Override
	@Transactional
	public List getIapList() {
		// TODO Auto-generated method stub
		DtProductExample productExample = new DtProductExample();
		productExample.setDistinct(false);
		List<DtProduct>  list = dtProductMapper.selectByExample(productExample);
	//	List<List> retuenlist = new ArrayList<>();
		List<ReturnProduct> retuenlist = new ArrayList<>();
		for(DtProduct dtProduct:list) {
			if(dtProduct.getStatus().equals("Active")) {
				//商品的信息是活动的
				if(dtProduct.getType().equals("iap")) {
					log.info("有命书的接口");
					
					ReturnProduct returnProduct = new ReturnProduct();
					returnProduct.setId(dtProduct.getId());
					returnProduct.setAppleID(dtProduct.getAppleid());
					returnProduct.setGoogleID(dtProduct.getGoogleid());
					returnProduct.setName(dtProduct.getAppname());
					returnProduct.setType(dtProduct.getType());
					retuenlist.add(returnProduct);
					
				/*	
					if(dtProduct.getSpareint() == null) {		
						log.info("不是");
						ReturnProduct returnProduct = new ReturnProduct();
						returnProduct.setId(dtProduct.getId());
						returnProduct.setAppleID(dtProduct.getAppleid());
						returnProduct.setGoogleID(dtProduct.getGoogleid());
						returnProduct.setName(dtProduct.getAppname());
						returnProduct.setType(dtProduct.getType());
						listiap.add(returnProduct);
					}else {
						LocalDate date = LocalDate.now();
						int year = date.getYear();
						if(dtProduct.getSpareint() == year) {
							ReturnProduct returnProduct = new ReturnProduct();
							returnProduct.setId(dtProduct.getId());
							returnProduct.setAppleID(dtProduct.getAppleid());
							returnProduct.setGoogleID(dtProduct.getGoogleid());
							returnProduct.setName(dtProduct.getAppname());
							returnProduct.setType(dtProduct.getType());
							listiap.add(returnProduct);
						}						
					}
				*/
					
				}
			}
		}
		
		//Collections.sort(listiap);
		
	
		log.info("返回的参数:"+retuenlist);
		return retuenlist;
	}

	
	
}
