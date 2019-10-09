package com.app.bv.serviceI;

import java.util.List;

import com.app.bv.entity.Product;
import com.app.bv.entity.Register;

public interface ShoppingCartServiceI {

	boolean checkLogin(String username, String password);

	boolean registerUser(Register register);

	List<Product> getAllProductList();

}
