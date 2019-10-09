package com.app.bv.daoI;

import java.util.List;

import com.app.bv.entity.Product;
import com.app.bv.entity.Register;

public interface ShoppingCartDaoI {

	boolean checkLogin(String username, String password);

	boolean registerUser(Register register);

	List<Product> getAllProduct();

}
