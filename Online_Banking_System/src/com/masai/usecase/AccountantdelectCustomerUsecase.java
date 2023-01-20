package com.masai.usecase;

import java.util.Scanner;

import com.masai.Dao.AccountantDao;
import com.masai.Dao.AccountantDaoImplement;
import com.masai.exception.CustomerException;

public class AccountantdelectCustomerUsecase {

	
	public void deleteCustomer() throws CustomerException {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter your AccountNo..");
		int AccountNo = scanner.nextInt();
		
		AccountantDao dao = new AccountantDaoImplement();
		int res = dao.delectCustomer(AccountNo);
		
		if(res == 1) {
			System.out.println("Delect your "+AccountNo);
		}else {
			System.out.println("Enter correct AccountNo...");
		}
		
	}
}
