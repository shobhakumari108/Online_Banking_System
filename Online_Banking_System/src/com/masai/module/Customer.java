package com.masai.module;

public class Customer {
  private int  CustomerID;
  private String Name;
  private String Username;
  private int password;
  private int AccountNO;
  private int Amount;
public Customer() {
	super();
	// TODO Auto-generated constructor stub
}
public Customer(int customerID, String name, String username, int password, int accountNO, int amount) {
	super();
	CustomerID = customerID;
	Name = name;
	Username = username;
	this.password = password;
	AccountNO = accountNO;
	Amount = amount;
}
@Override
public String toString() {
	return "Customer [CustomerID=" + CustomerID + ", Name=" + Name + ", Username=" + Username + ", password=" + password
			+ ", AccountNO=" + AccountNO + ", Amount=" + Amount + "]";
}
public int getCustomerID() {
	return CustomerID;
}
public void setCustomerID(int customerID) {
	CustomerID = customerID;
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
public int getPassword() {
	return password;
}
public void setPassword(int password) {
	this.password = password;
}
public int getAccountNO() {
	return AccountNO;
}
public void setAccountNO(int accountNO) {
	AccountNO = accountNO;
}
public int getAmount() {
	return Amount;
}
public void setAmount(int amount) {
	Amount = amount;
}
  

}
