package com.app.bv.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.bv.constant.ShoppingCartConstant;
import com.app.bv.daoI.ShoppingCartDaoI;
import com.app.bv.entity.Product;
import com.app.bv.entity.Register;

@Repository
public class ShoppingCartDaoImpl implements ShoppingCartDaoI {
	@Autowired
	private SessionFactory factory;

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}


	public boolean checkLogin(String username, String password) {
		// TODO Auto-generated method stub

		// open the session
		Session session = null;
		Transaction tx = null;
		Query query = null;
		int result = 0;
		// get the session object
		session = factory.openSession();
		// begin the transaction
		tx = session.beginTransaction();
		query = session.createQuery(ShoppingCartConstant.loginCredential);
		// set the parameter
		query.setParameter(0, username);
		query.setParameter(1, password);
		result = (Integer) query.uniqueResult();
		if (result == 1) {
			return true;
		} else {
			return false;
		}

	}

	public boolean registerUser(Register register) {
		// TODO Auto-generated method stub

		// open the session
		Session session = null;
		Transaction tx = null;

		session = factory.openSession();
		// open the transaction
		tx = session.beginTransaction();
		// save the data
		int registerCredentail = (Integer) session.save(register);
		
		//commit the transaction
		tx.commit();
		if (registerCredentail!=0) {
			return true;
		} else {
			return false;
		}
	}

	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		List<Product> productList=null;
		Criteria crit=null;
		session=factory.openSession();
		tx=session.beginTransaction();
		crit= session.createCriteria(Product.class);
		productList=crit.list();
		return productList;
	}

}
