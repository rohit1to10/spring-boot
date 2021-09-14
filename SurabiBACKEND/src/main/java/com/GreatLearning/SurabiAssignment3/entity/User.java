package com.GreatLearning.SurabiAssignment3.entity;

public interface User {
	
	public void setId(int id);
	
	public void setUserName(String userName);
	
	public void setUserPassword(String password);
	
	public int getId();
	
	public String getUserName();
	
	public String getUserPassword();

	public void login(User user);
	
	public void logout();

	public void startSession(User user);
	
}
