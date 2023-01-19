package com.masai.module;

public class Accountant {
   private int AccountNo;
   private String Name;
   private String Username;
   private String password;
public Accountant() {
	super();
	// TODO Auto-generated constructor stub
}
public Accountant(int accountNo, String name, String username, String password) {
	super();
	AccountNo = accountNo;
	Name = name;
	Username = username;
	this.password = password;
}
@Override
public String toString() {
	return "Accountant [AccountNo=" + AccountNo + ", Name=" + Name + ", Username=" + Username + ", password=" + password
			+ "]";
}
public int getAccountNo() {
	return AccountNo;
}
public void setAccountNo(int accountNo) {
	AccountNo = accountNo;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getUsername() {
	return Username;
}
public void setUsername(String username) {
	Username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

   
}
