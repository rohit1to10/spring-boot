package com.GreatLearning.SurabiAssignment3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.GreatLearning.SurabiAssignment3.dao.UserDAO;
import com.GreatLearning.SurabiAssignment3.entity.Admin;
import com.GreatLearning.SurabiAssignment3.entity.Bills;
//import com.GreatLearning.SurabiAssignment3.entity.Admin;
import com.GreatLearning.SurabiAssignment3.entity.Customer;

import com.GreatLearning.SurabiAssignment3.entity.FoodMenu;
import com.GreatLearning.SurabiAssignment3.service.AdminService;
import com.GreatLearning.SurabiAssignment3.service.UserService;

import ch.qos.logback.core.net.SyslogOutputStream;


@RestController
@RequestMapping("/surabi")
//@CrossOrigin(origins="http://localhost:4200")
@CrossOrigin(origins={"http://localhost:3000","http://localhost:4200"})
public class UserController {
//	@Autowired
	UserService user;
	
	@Autowired
	public UserController(UserService theUser) {
		user = theUser;
	}
	
	Boolean check=false;
	  
	
	@Autowired
	UserDAO us;
	
	 @GetMapping("/Customerdata")
	 public List<Customer> data() {
		 return us.data();
	 }
	 @GetMapping("/FoodMenu")
	 public List<FoodMenu> menudata() {
		 return us.menudata();
	 }
	
	@PostMapping("/customer")
	public List<FoodMenu> attendCustomer(@RequestBody Customer customer) {
		//return user.attendUser(cust);
		if(user.attendUser(customer)!=null) {
			check=true;
			return user.attendUser(customer);
		}
		else {
			System.out.println("Didn't logged in");
		return null;
		}
		
	}
	
	
    @PostMapping("/customer/selectmenu/{name}")
    public int menuprice(@RequestBody int[] arr,@PathVariable String name ) {
    	
   // return 	user.userMenuSelect(arr,name);
    	if(check)return user.userMenuSelect(arr,name);
    	return 0;
    }
    
    @PostMapping("/customer/billinsert/{name}/{billp}")
    public void billinsert(@PathVariable String name,@PathVariable int billp ) {
    	
   // return 	user.userMenuSelect(arr,name);
    	us.insertbill(name,billp);
    }
    
    
    
    @GetMapping("/customer/logout")
    public String logoutfun() {
    	check=false;
    	return "YOU HAVE LOGGED OUT";
    }
    
//	@PostMapping("/customer/create")
//	public String create(@RequestBody Customer c) {
//		System.out.println("hello mojonvdvid");
//		return user.Createcus(c);
//	}
//	
	
	@PutMapping("/admin/customer/update")
	public String update(@RequestBody Customer c) {
		return user.Updatecus(c);
	}
	
	@DeleteMapping("/admin/customer/delete")
	public String delete(@RequestBody Customer c) {
		return user.deletecus(c);
	}
	
	@PostMapping("/customer/register")
	public void register(@RequestBody Customer c) {
		String s=user.register(c);
	}
	
	
    
}
