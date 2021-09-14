package com.GreatLearning.SurabiAssignment3.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GreatLearning.SurabiAssignment3.dao.UserDAO;
import com.GreatLearning.SurabiAssignment3.entity.Customer;
import com.GreatLearning.SurabiAssignment3.entity.User;
import com.GreatLearning.SurabiAssignment3.entity.FoodMenu;

@Service
public class UserServiceImplementation implements UserService{
	
	@Autowired
	UserDAO user ;
	
	@Override
	public boolean login(int id , String name , String password) {
		// TODO Auto-generated method stub
		return user.login(id,name,password);
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		user.logout();
	}

	@Override
	public List<FoodMenu> attendUser(Customer customer) {
		return user.attendUser(customer);
	}

	@Override
	public int userMenuSelect(int[] arr,String s) {
		// TODO Auto-generated method stub
		return user.userMenuSelect(arr,s);
	}

	@Override
	public String Createcus(Customer c) {
		// TODO Auto-generated method stub
		return user.Createcus(c);
	}

	@Override
	public String deletecus(Customer c) {
		// TODO Auto-generated method stub
		return user.deletecus(c);
	}

	@Override
	public String Updatecus(Customer c) {
		// TODO Auto-generated method stub
		return user.Updatecus(c);
	}

	@Override
	public String register(Customer c) {
		// TODO Auto-generated method stub
		return user.register(c);
	}
	

}
