package com.masai.usecase;

import java.util.Scanner;

import com.masai.Dao.AccountantDao;
import com.masai.Dao.AccountantDaoImplement;
import com.masai.exception.CustomerException;

public class AccountantFindParticularAccountDetailUsecase {

	public void FindParticularAccountDetail() throws CustomerException {
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("Enter AccountNo...");
	int AccountNO = scanner.nextInt();
	
	AccountantDao dao = new AccountantDaoImplement();
	int res = dao.FindParticularAccountDetail(AccountNO);
	
	if(res==1) {
		System.out.println("print your AccountNO  "+AccountNO +"Detail");
	}else {
		System.out.println("Invalid AccountNO...");
	}
	}
}
