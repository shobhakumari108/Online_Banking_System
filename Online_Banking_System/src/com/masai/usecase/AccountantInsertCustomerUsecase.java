package com.masai.usecase;

import java.util.Scanner;

import com.masai.Dao.AccountantDao;
import com.masai.Dao.AccountantDaoImplement;
import com.masai.exception.CustomerException;

public class AccountantInsertCustomerUsecase {

	public void InsertCustomer() throws CustomerException {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter customer name...");
		String name = scanner.next();
		
		System.out.println("Enter customer username...");
		String username = scanner.next();

		
		System.out.println("Enter customer password...");
		String password = scanner.next();

		
		System.out.println("Enter customer AccountNo...");
		int AccountNo = scanner.nextInt();

		
		System.out.println("Enter customer Amount...");
		int Amount = scanner.nextInt();

		AccountantDao dao = new AccountantDaoImplement();
		boolean res = dao.InsertCustomer(name,username,password,AccountNo, Amount);
		
		if(res == true) {
			System.out.println("inser your data successfully......");
		}else {
			System.out.println(" not insered ......");

		}
	}
}





















