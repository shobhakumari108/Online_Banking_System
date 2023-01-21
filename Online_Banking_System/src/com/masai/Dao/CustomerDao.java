package com.masai.Dao;

import java.util.List;

import com.masai.exception.CustomerException;
import com.masai.exception.TransactionException;
import com.masai.module.Transaction;

public interface CustomerDao {
	public boolean loginCustomer(String Username,int password) throws CustomerException;
	
	public String SenderUsername(String Username,int password) throws CustomerException;

	public int Moneytranfer(String SUsername,String RUsername,int Amount) throws CustomerException;
	
	public String ReciverUsername(int id)throws CustomerException;
	
	public int CheckSufficientAmount(String Username) throws CustomerException;

	public int SubtractSenderMoney(int Amount,String Username)throws CustomerException;
	
	public int AddReciverAmount(int Amount,String Username) throws CustomerException;
	
	public List<Transaction> checkTransfermationHistory(String Username)throws TransactionException;


	

	

	
}
