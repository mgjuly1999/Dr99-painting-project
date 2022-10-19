package com.coder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.dao.ProductOrderDao;

@Service
@Repository("productOrderService")
public class ProductOrderService {
	
	@Autowired
	private ProductOrderDao  productOrderDao;

}
