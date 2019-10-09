package com.app.bv.serviceImpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.bv.daoI.ShoppingCartDaoI;
import com.app.bv.entity.Product;
import com.app.bv.entity.Register;
import com.app.bv.serviceI.ShoppingCartServiceI;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartServiceI{
    
	@Autowired
	private ShoppingCartDaoI daoi;
	
	/*
	 * This method is used to check whether user is valid or not
	 * @RequestParam username and password
	 * return boolean
	 * */
	@Transactional
	public boolean checkLogin(String username, String password) {
		
		return daoi.checkLogin(username,password);
	}
	/*
	 * This method is used to save the user record.
	 * @RequestParam Register object
	 * return boolean
	 * */
	@Transactional
	public boolean registerUser(Register register) {
		// TODO Auto-generated method stub
		return daoi.registerUser(register);
	}
	/*
	 * This method is used to getAllProduct
	 * return productList
	 * */
    @Transactional(propagation=Propagation.SUPPORTS,readOnly=false,rollbackFor=Exception.class)
	public List<Product> getAllProductList() {
		// TODO Auto-generated method stub
		return daoi.getAllProduct();
	}

}
