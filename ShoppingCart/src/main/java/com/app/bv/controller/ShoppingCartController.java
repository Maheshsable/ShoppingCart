package com.app.bv.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.bv.entity.Product;
import com.app.bv.entity.Register;
import com.app.bv.serviceI.ShoppingCartServiceI;
import com.google.gson.Gson;

@RestController
public class ShoppingCartController {
	@Autowired
	ShoppingCartServiceI shoppingCartServiceI;
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public @ResponseBody String login(@RequestParam("username")String username, @RequestParam("password")String password){
		
		if(username.isEmpty()){
			String result=null;
			result="Please Enter userName First";
			return result;
		}
		if(password.isEmpty()){
			String result=null;
			result="Please Enter the Password";
			return result;
		}
		if(username!=null && password!=null){
			boolean loginCredentials=shoppingCartServiceI.checkLogin(username,password);
			if(loginCredentials){
				
				return "Login Success";
			}else{
				return "Login Failure";
			}
		}
		return"";
	}

	@RequestMapping(value="/register",method=RequestMethod.POST)
	public @ResponseBody String registerUser(@RequestBody Register register){
		
		boolean registerCredential=shoppingCartServiceI.registerUser(register);
		Gson gson=new Gson();
		String result=null;
		if(registerCredential){
			result="Registration Success";
			result=gson.toJson(result);
			return result;
		}else{
			result="Registration fail";
			result=gson.toJson(result);
			return result;
		}
	}
	@RequestMapping(value="/viewAllProduct",method=RequestMethod.POST)
	public @ResponseBody String viewAllProduct(HttpServletResponse res){
		 res.setHeader("Access-Control-Allow-Origin", "*");

		List<Product> productList=null;
		Gson gson=new Gson();
		String result=null;
		try{
			productList=shoppingCartServiceI.getAllProductList();
			result=gson.toJson(productList);
		}catch(Exception e){
			System.out.println(e);
		}
		return result;
	}
}
