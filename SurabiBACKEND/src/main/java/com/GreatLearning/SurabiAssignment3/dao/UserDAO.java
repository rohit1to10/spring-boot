package com.GreatLearning.SurabiAssignment3.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.data.util.Pair;

import com.GreatLearning.SurabiAssignment3.entity.Customer;
import com.GreatLearning.SurabiAssignment3.entity.User;
import com.GreatLearning.SurabiAssignment3.entity.FoodMenu;

public interface UserDAO {
	
	public boolean login(int id , String name , String password) ;
	public void logout() ;
	public List<FoodMenu> attendUser(Customer customer) ;
	public int userMenuSelect(int [] inputarrr,String s);
	public List<Customer>data();
	public List<FoodMenu>menudata();
	public void insertbill(String s,int n);
	
	
	public String Createcus(Customer c);
	public String deletecus(Customer c);
	public String Updatecus(Customer c);
	public String register(Customer c);
}
