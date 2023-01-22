package com.masai.usecase;

import java.util.List;
import java.util.Scanner;

import com.masai.Dao.AccountantDao;
import com.masai.Dao.AccountantDaoImplement;
import com.masai.custom.consolecolor;
import com.masai.exception.AccountntException;
import com.masai.exception.CustomerException;
import com.masai.exception.TransactionException;
import com.masai.module.Customer;
import com.masai.module.Transaction;

public class AccountantMainUsecase {

	AccountantDao dao = new AccountantDaoImplement();
	public int StartFunction() {
		Scanner scanner = new Scanner(System.in);
		System.out.println(consolecolor. PURPLE+"+---------------------+\n" + "|      Enter numer    |\n" + "+---------------------+\n" + "| 1. Login Accountant |\n"
				+ "| 2. Login Customer   |\n" + "| 3. Exit             |\n" + "+---------------------+");
		System.out.println(consolecolor.TEAL+"Enter your Number accoding Your Work"+consolecolor.RESET);
		int n = scanner.nextInt();
		return n;

	}
//************************************************************************************************************************	
	public boolean LoginAccountant() throws AccountntException {
		boolean flag = false;
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println(consolecolor.ROSY_PINK+"Enter Username..."+consolecolor.RESET);
			String username = scanner.next();

			System.out.println(consolecolor.ROSY_PINK+"Enter Password..."+consolecolor.RESET);
			int password = scanner.nextInt();

//			AccountantDao dao = new AccountantDaoImplement();
			boolean res = dao.LoginAccountant(username, password);

			if (res == true) {
				System.out.println(consolecolor.GREEN+"login sucessfully.."+consolecolor.RESET);
				flag = true;
				break;

			} else {
				System.out.println(consolecolor.RED+"wrong username and password ..."+consolecolor.RESET);
			}

		}

		return flag;
	}
	
//*************************************************************************************************************************	
	public int AccoutentWorkModle() {

		Scanner scanner = new Scanner(System.in);
		System.out.println(consolecolor.PURPLE+"+-----------------------------------------------------------+\r\n"
				+ "|  ENTER YOUR NUMBER                                        |\r\n"
				+ "+-----------------------------------------------------------+			\r\n"
				+ "|                                               	    | \r\n"
				+ "| 1.Add new account                      		    |\r\n"
				+ "| 2.Editing account                       		    |\r\n"
				+ "| 3.delect the account by using account number  	    |\r\n"
				+ "| 4.Viewing particular account details account number       |\r\n"
				+ "| 5.Viewing all the account details          	            |\r\n"
				+ "| 6.Taking care of deposit and withdrawal operations        |\r\n"
				+ "| 7.Exit                                    		    |\r\n"
				+ "+-----------------------------------------------------------+"+consolecolor.RESET );
		System.out.println(consolecolor.TEAL+"Enter your Number accoding Your Work"+consolecolor.TEAL);
		int accWork = scanner.nextInt();
		return accWork;
	}
//**************************************************************************************************************************	
	
public void InsertCustomer() throws CustomerException {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(consolecolor.ROSY_PINK+"Enter customer name..."+consolecolor.RESET);
		String name = scanner.next();
		
		System.out.println(consolecolor.ROSY_PINK+"Enter customer username..."+consolecolor.RESET);
		String username = scanner.next();

		
		System.out.println(consolecolor.ROSY_PINK+"Enter customer password..."+consolecolor.RESET);
		int password = scanner.nextInt();

		
		System.out.println(consolecolor.ROSY_PINK+"Enter customer AccountNo..."+consolecolor.RESET);
		int AccountNo = scanner.nextInt();

		
		System.out.println(consolecolor.ROSY_PINK+"Enter customer Amount..."+consolecolor.RESET);
		int Amount = scanner.nextInt();

//		AccountantDao dao = new AccountantDaoImplement();
		int res = dao.InsertCustomer(name,username,password,AccountNo, Amount);
		
		if(res ==1) {
			System.out.println(consolecolor.GREEN+"inser your data successfully......"+consolecolor.RESET);
		}else {
			System.out.println(consolecolor.RED+"not insered ......"+consolecolor.RESET);

		}
	}

//*************************************************************************************************************************

public void UpdateCusomer() throws CustomerException {
	Scanner scanner = new Scanner(System.in);
	
	System.out.println(consolecolor.ROSY_PINK+"Enter Customer name.."+consolecolor.RESET);
	String name = scanner.nextLine();

	System.out.println(consolecolor.ROSY_PINK+"Enter Customer Username.."+consolecolor.RESET);
	String Username = scanner.nextLine();

	System.out.println(consolecolor.ROSY_PINK+"Enter Customer password.."+consolecolor.RESET);
	int password = scanner.nextInt();

	System.out.println(consolecolor.ROSY_PINK+"Enter Customer AccountNo.."+consolecolor.RESET);
	int AccountNo = scanner.nextInt();

	System.out.println(consolecolor.ROSY_PINK+"Enter Customer Amount.."+consolecolor.RESET);
	int Amount = scanner.nextInt();
	
	System.out.println(consolecolor.ROSY_PINK+"Enter Customer CustomerID.."+consolecolor.RESET);
	int CustomerID = scanner.nextInt();

//	AccountantDao dao = new AccountantDaoImplement();
	int res = dao.UpdateCusomer(name,Username,password,AccountNo, Amount,CustomerID);	
	
	if(res ==1) {
		
		System.out.println(consolecolor.GREEN+"Update successfully.."+consolecolor.RESET);
	}else {
		
		System.out.println(consolecolor.RED+"wrong information..."+consolecolor.RESET);
	}
	}

//***********************************************************************************************************************



	
	public void deleteCustomer() throws CustomerException {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(consolecolor.ROSY_PINK+"Enter your AccountNo.."+consolecolor.RESET);
		int AccountNo = scanner.nextInt();
		
//		AccountantDao dao = new AccountantDaoImplement();
		int res = dao.delectCustomer(AccountNo);
		
		if(res == 1) {
			System.out.println(consolecolor.GREEN+"Delect your AccountNo => "+AccountNo+consolecolor.RESET);
		}else {
			System.out.println(consolecolor.RED+"Enter correct AccountNo..."+consolecolor.RESET);
		}
	}
	
//*********************************************************************************************************************

	
	
	public void FindParticularAccountDetail() throws CustomerException {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(consolecolor.ROSY_PINK+"Enter AccountNo..."+consolecolor.RESET);
		int AccountNO = scanner.nextInt();
		
//		AccountantDao dao = new AccountantDaoImplement();
		int res = dao.FindParticularAccountDetail(AccountNO);
		
		if(res==1) {
			System.out.println(consolecolor.GREEN+"print your AccountNO  "+AccountNO +"Detail"+consolecolor.RESET);
		}else {
			System.out.println(consolecolor.RED+"Invalid AccountNO..."+consolecolor.RESET);
		}
		}
	
	

//	*************************************************************************************************************
	
	public void FindAllCustomerDtail() throws CustomerException {
//		AccountantDao dao = new AccountantDaoImplement();
		List<Customer> list = dao.FindAllCustomerDetail();
		list.forEach(dao-> System.out.println(consolecolor.YELLOW+dao+consolecolor.RESET));
		
	}
	
	
//	*****************************************************************************************************
	
	
	public void TransactionList() throws  TransactionException {
//		AccountantDao dao = new AccountantDaoImplement();
		
		List<Transaction> list = dao.FindTransactionList();
		list.forEach(dao->System.out.println(consolecolor.YELLOW+dao+consolecolor.RESET));
	}
	
	
	
}
