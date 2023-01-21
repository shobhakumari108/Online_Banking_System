package com.masai.Dao;

import java.util.List;

import com.masai.exception.AccountntException;

//import javax.security.auth.login.AccountException;

import com.masai.exception.CustomerException;
import com.masai.exception.TransactionException;
import com.masai.module.Customer;
import com.masai.module.Transaction;

public interface AccountantDao {
	
	public boolean LoginAccountant(String Username,int Password ) throws AccountntException;
	
	public int InsertCustomer(String Name,String Username, int password,int AccountNo,int Amount) throws CustomerException;
	
	public int UpdateCusomer(String Name,String Username, int password,int AccountNo,int Amount, int Trans_ID)  throws CustomerException;
	
	public int delectCustomer(int AccountNo) throws CustomerException;
	
	public int FindParticularAccountDetail(int AccountNo) throws CustomerException;
	
	public List<Customer> FindAllCustomerDetail() throws CustomerException;
	
	public List<Transaction> FindTransactionList() throws TransactionException;
	
}
