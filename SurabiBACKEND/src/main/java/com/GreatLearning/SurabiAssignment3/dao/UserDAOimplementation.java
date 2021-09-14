package com.GreatLearning.SurabiAssignment3.dao;
import com.GreatLearning.SurabiAssignment3.entity.Bills;
import com.GreatLearning.SurabiAssignment3.entity.Customer;
import com.GreatLearning.SurabiAssignment3.entity.FoodMenu;


import java.util.List;

import javax.persistence.EntityManager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Repository;


@Repository
public class UserDAOimplementation implements UserDAO{
	
	private EntityManager entityManager;
	
	@Autowired
	public UserDAOimplementation(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	
	@Override
	public boolean login(int id, String name, String password) {
		Session currentSession = entityManager.unwrap(Session.class);
		Customer theUser = currentSession.get(Customer.class,id);
		if(theUser.getId()==id && theUser.getName().equals(name) && theUser.getPassword().equals(password)) {
			
			return true ;
		}
		return false;
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<FoodMenu> attendUser(Customer theUser) {
		
		boolean isValiduser = login(theUser.getId(),theUser.getName(),theUser.getPassword());
		
		if(isValiduser) {
			Session currentSession = entityManager.unwrap(Session.class);
			Query theQuery = currentSession.createQuery("from FoodMenu",FoodMenu.class);
			List<FoodMenu> foodmenulist = theQuery.getResultList();
			return foodmenulist;
		}
		return null;
	}

	@Override
	public int userMenuSelect(int [] inputarr,String s) {
		System.out.println("inside menu select");
		// TODO Auto-generated method stub
		int totalprice=0;
		for(int i:inputarr) {
			Session currentSession = entityManager.unwrap(Session.class);
			FoodMenu foo = currentSession.get(FoodMenu.class,i);
			totalprice+=foo.getPrice();
		}
		String date = java.time.LocalDate.now().toString();
	
		Bills bills=new Bills();
		bills.setUsername(s);
		bills.setDate(date);
		bills.setPrice(totalprice);
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(bills);
		
		return totalprice;
	}



	@Override
	public String Createcus(Customer c) {
		//System.out.println("inside createcus");
		Session currentSession = entityManager.unwrap(Session.class);
		Customer cus=new Customer();
		cus.setName(c.getName());
		cus.setPassword(c.getPassword());
		currentSession.save(cus);
		return "User is saved check the database";
	}
	
	
	
	
	
	//delete operation
	@Override
	public String deletecus(Customer c) {
		// TODO Auto-generated method stub
		System.out.println("inside del");
		Session currentSession = entityManager.unwrap(Session.class);
		int id=c.getId();
//		Query theQuery = currentSession.createQuery("delete from customer where userId = "+id+"");
//		//theQuery.setParameter("ids", id);
//		theQuery.executeUpdate();
		return "the user data with id ="+id+" is deleted";
	}


   //update operation
	@Override
	public String Updatecus(Customer c) {
		// TODO Auto-generated method stub
//		String s=deletecus(c);
//		String s1=Createcus(c);
		
		return "The user data is updated check the database";
	}



	@Override
	public String register(Customer c) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		Customer cus=new Customer();
		cus.setName(c.getName());
		cus.setPassword(c.getPassword());
		currentSession.save(cus);
		
		return "User is registered successfully";
	}



	@Override
	public List<Customer> data() {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		String hql = "from Customer";
		Query query = currentSession.createQuery(hql);
		//query.setString("price","");
		List results = query.list();
		return results;
	
	}



	@Override
	public List<FoodMenu> menudata() {
		Session currentSession = entityManager.unwrap(Session.class);
		String hql = "from FoodMenu";
		Query query = currentSession.createQuery(hql);
		//query.setString("price","");
		List results = query.list();
		return results;
	}



	@Override
	public void insertbill(String s, int n) {
		// TODO Auto-generated method stub
		String date = java.time.LocalDate.now().toString();
		
		Bills bills=new Bills();
		bills.setUsername(s);
		bills.setDate(date);
		bills.setPrice(n);
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(bills);
	    System.out.println("hello inserted");
		
	}

}
