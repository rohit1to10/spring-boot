package com.GreatLearning.SurabiAssignment3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.GreatLearning.SurabiAssignment3.entity.Customer;
import com.GreatLearning.SurabiAssignment3.entity.User;
import com.GreatLearning.SurabiAssignment3.entity.FoodMenu;

public interface UserService {
	
	public boolean login(int id , String name , String password) ;
	public void logout() ;
	public List<FoodMenu> attendUser(Customer customer) ;
	public int  userMenuSelect(int []arr,String s);
	
	
	public String Createcus(Customer c);
	public String deletecus(Customer c);
	public String Updatecus(Customer c);
	public String register(Customer c);
}
