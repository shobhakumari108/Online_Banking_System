package com.masai.usecase;

import java.util.List;
import java.util.Scanner;

import com.masai.Dao.AccountantDao;
import com.masai.Dao.AccountantDaoImplement;
import com.masai.exception.AccountntException;
import com.masai.exception.CustomerException;
import com.masai.exception.TransactionException;
import com.masai.module.Customer;
import com.masai.module.Transaction;

public class AccountantMainUsecase {

	AccountantDao dao = new AccountantDaoImplement();
	public int StartFunction() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("+--------------+\n" + "| enter numer  |\n" + "+--------------+\n" + "| 1.Accountant |\n"
				+ "| 2.Customer   |\n" + "| 3.Exit       |\n" + "+--------------+");
		System.out.println("Enter your Number accoding Your Work");
		int n = scanner.nextInt();
		return n;

	}
//************************************************************************************************************************	
	public boolean LoginAccountant() throws AccountntException {
		boolean flag = false;
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Enter Username...");
			String username = scanner.next();

			System.out.println("Enter Password...");
			int password = scanner.nextInt();

//			AccountantDao dao = new AccountantDaoImplement();
			boolean res = dao.LoginAccountant(username, password);

			if (res == true) {
				System.out.println("login sucessfully..");
				flag = true;
				break;

			} else {
				System.out.println("wrong username and password ...");
			}

		}

		return flag;
	}
	
//*************************************************************************************************************************	
	public int AccoutentWorkModle() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("+-----------------------------------------------------------+\r\n"
				+ "|  ENTER YOUR NUMBER                            			|\r\n"
				+ "+-----------------------------------------------------------+			\r\n"
				+ "|                                               			| \r\n"
				+ "| 1. Add new account                      					|\r\n"
				+ "| 2.Editing account                       					|\r\n"
				+ "| 3.delect the account by using account number  			|\r\n"
				+ "| 4.Viewing particular account details account number   	|\r\n"
				+ "| 5.Viewing all the account details          				|\r\n"
				+ "| 6.Taking care of deposit and withdrawal operations 		|\r\n"
				+ "| 7.Exit                                    				|\r\n"
				+ "+-----------------------------------------------------------+" );
		System.out.println("Enter your Number accoding Your Work");
		int accWork = scanner.nextInt();
		return accWork;
	}
//**************************************************************************************************************************	
	
public void InsertCustomer() throws CustomerException {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter customer name...");
		String name = scanner.next();
		
		System.out.println("Enter customer username...");
		String username = scanner.next();

		
		System.out.println("Enter customer password...");
		int password = scanner.nextInt();

		
		System.out.println("Enter customer AccountNo...");
		int AccountNo = scanner.nextInt();

		
		System.out.println("Enter customer Amount...");
		int Amount = scanner.nextInt();

//		AccountantDao dao = new AccountantDaoImplement();
		int res = dao.InsertCustomer(name,username,password,AccountNo, Amount);
		
		if(res ==1) {
			System.out.println("inser your data successfully......");
		}else {
			System.out.println(" not insered ......");

		}
	}

//*************************************************************************************************************************

public void UpdateCusomer() throws CustomerException {
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("Enter Customer name..");
	String name = scanner.nextLine();

	System.out.println("Enter Customer Username..");
	String Username = scanner.nextLine();

	System.out.println("Enter Customer password..");
	int password = scanner.nextInt();

	System.out.println("Enter Customer AccountNo..");
	int AccountNo = scanner.nextInt();

	System.out.println("Enter Customer Amount..");
	int Amount = scanner.nextInt();
	
	System.out.println("Enter Customer Trans_ID..");
	int Trans_ID = scanner.nextInt();

//	AccountantDao dao = new AccountantDaoImplement();
	int res = dao.UpdateCusomer(name,Username,password,AccountNo, Amount,Trans_ID);	
	
	if(res ==1) {
		
		System.out.println("Update successfully..");
	}else {
		
		System.out.println("wrong information...");
	}
	}

//***********************************************************************************************************************



	
	public void deleteCustomer() throws CustomerException {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter your AccountNo..");
		int AccountNo = scanner.nextInt();
		
//		AccountantDao dao = new AccountantDaoImplement();
		int res = dao.delectCustomer(AccountNo);
		
		if(res == 1) {
			System.out.println("Delect your "+AccountNo);
		}else {
			System.out.println("Enter correct AccountNo...");
		}
	}
	
//*********************************************************************************************************************

	
	
	public void FindParticularAccountDetail() throws CustomerException {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter AccountNo...");
		int AccountNO = scanner.nextInt();
		
//		AccountantDao dao = new AccountantDaoImplement();
		int res = dao.FindParticularAccountDetail(AccountNO);
		
		if(res==1) {
			System.out.println("print your AccountNO  "+AccountNO +"Detail");
		}else {
			System.out.println("Invalid AccountNO...");
		}
		}
	
	

//	*************************************************************************************************************
	
	public void FindAllCustomerDtail() throws CustomerException {
//		AccountantDao dao = new AccountantDaoImplement();
		List<Customer> list = dao.FindAllCustomerDetail();
		list.forEach(dao-> System.out.println(dao));
		
	}
	
	
//	*****************************************************************************************************
	
	
	public void TransactionList() throws  TransactionException {
//		AccountantDao dao = new AccountantDaoImplement();
		
		List<Transaction> list = dao.FindTransactionList();
		list.forEach(dao->System.out.println(dao));
	}
	
	
	
}
