package com.masai.usecase;

import java.util.List;
import java.util.Scanner;

import com.masai.Dao.CustomerDao;
import com.masai.Dao.CustomerDaoImplement;
import com.masai.exception.CustomerException;
import com.masai.exception.TransactionException;
import com.masai.module.Transaction;

public class CustomerMainUsecase {

	
	private String Username;
	private int password;
	private String name;

	public String getUsername() {
		return Username;
	}

	public int getPassword() {
		return password;
	}

	CustomerDao dao = new CustomerDaoImplement();

	public boolean CheckLoginCustomer() throws CustomerException {
		
		boolean flag = false;
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println( "enter Your Username");
			String Username = scanner.next();
			
			System.out.println( "enter Your Password");
			int Password = scanner.nextInt();
			
			boolean res = dao.loginCustomer(Username, password);
			if (res == true) {
				
				this.Username = Username;
				this.password = password;
				this.name = dao.SenderUsername(Username, password);//************************
				
				System.out.println("login Sucessfully");
				flag = true;
				break;
			} else {
				System.out.println("wrong your username and password");
			}
		}

		return flag;
	}
	
//**************************************************************************************************
	public int CustomerWorkType() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(
				          "+-----------------------------------------------------------+			\r\n"
						+ "|  ENTER YOUR NUMBER                            			|\r\n"
						+ "+-----------------------------------------------------------+			\r\n"
						+ "|                                               			| \r\n"
						+ "| 1.Transfer the money from his account to other account    |\r\n"
						+ "| 2.Checking the transaction history                      	|\r\n"
						+ "| 3. Exit  													|\r\n"
						+ "+-----------------------------------------------------------+");
		System.out.println("Enter your Number accoding Your Work");
		int accordingWork = scanner.nextInt();
		return accordingWork;
	}

//	******************************************************************
	public void MoneySender() throws CustomerException {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Reciver ID");
		int id = scanner.nextInt();
		
		String rUsername = dao.ReciverUsername(id);
		
		if (rUsername == null) {
			System.out.println("Enter correcet reciver id or this person not any account");
			return;
		}
		System.out.println("Enter Amount");
		int Amount = scanner.nextInt();
		
		int AmountCheck = dao.CheckSufficientAmount(this.Username);
		
		if (AmountCheck < Amount) {
			System.out.println(" your amount is not Sufficeent");
			return;
		}
		
		int i = dao.Moneytranfer(this.Username, rUsername, Amount);
		if (i == 1) {
			System.out.println(" send your money SuccessFully");
			
			int subM = dao.SubtractSenderMoney(Amount, this.Username);
			
			int reciM = dao.AddReciverAmount(Amount, rUsername);
			
			if (subM == 1 && reciM == 1) {
				System.out.println("process is complete...");
			}

		} else {
			System.out.println("no send money");
		}

	}
	public void transactionhistory () throws TransactionException {
		
	List<Transaction> list=dao.checkTransfermationHistory(this.Username);
	
	list.forEach(dao->System.out.println(dao));
	}

}
