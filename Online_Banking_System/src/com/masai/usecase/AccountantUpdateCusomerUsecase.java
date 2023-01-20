package com.masai.usecase;

import java.util.Scanner;

import com.masai.Dao.AccountantDao;
import com.masai.Dao.AccountantDaoImplement;
import com.masai.exception.CustomerException;

public class AccountantUpdateCusomerUsecase {

//	boolean flag = false;
	
	public void UpdateCusomer() throws CustomerException {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Customer name..");
		String name = scanner.nextLine();
	
		System.out.println("Enter Customer Username..");
		String Username = scanner.nextLine();

		System.out.println("Enter Customer password..");
		String password = scanner.nextLine();

		System.out.println("Enter Customer AccountNo..");
		int AccountNo = scanner.nextInt();

		System.out.println("Enter Customer Amount..");
		int Amount = scanner.nextInt();
		
		System.out.println("Enter Customer Trans_ID..");
		int Trans_ID = scanner.nextInt();

		AccountantDao dao = new AccountantDaoImplement();
		boolean res = dao.UpdateCusomer(name,Username,password,AccountNo, Amount,Trans_ID);	
		
		if(res ==true) {
			System.out.println("Update successfully..");
		}else {
			System.out.println("wrong information...");
		}
		}
	     }

