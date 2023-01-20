package com.masai.usecase;

import java.util.Scanner;

import com.masai.Dao.AccountantDao;
import com.masai.Dao.AccountantDaoImplement;
import com.masai.exception.AccountntException;

public class AccountantLoginUsecases {

	public boolean LoginAccountant() throws AccountntException {
		boolean flag = false;
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Enter Username...");
			String username = scanner.next();

			System.out.println("Enter Password...");
			String password = scanner.next();

			AccountantDao dao = new AccountantDaoImplement();
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

}
