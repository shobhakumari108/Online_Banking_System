package com.masai.usecase;

import java.util.Scanner;

import com.masai.exception.AccountntException;
import com.masai.exception.CustomerException;
import com.masai.exception.TransactionException;

public class Main {

	public static void main(String[] args) throws AccountntException, CustomerException, TransactionException {

		Scanner scanner = new Scanner(System.in);
				AccountantMainUsecase Acc = new AccountantMainUsecase();
		CustomerMainUsecase Cust = new CustomerMainUsecase();
		while (true) {
			int num = Acc.StartFunction();
			if (num == 1) {
				boolean LogA = Acc.LoginAccountant();
				if (LogA == true) {
					while (true) {
						int AccM = Acc.AccoutentWorkModle();
						if (AccM == 1) {
							Acc.InsertCustomer();
						} else if (AccM == 2) {
							Acc.UpdateCusomer();
						} else if (AccM == 3) {
							Acc.deleteCustomer();
						} else if (AccM == 4) {
							Acc.FindParticularAccountDetail();
						} else if (AccM == 5) {
							Acc.FindAllCustomerDtail();
						} else if (AccM == 6) {
							Acc.TransactionList();
						} else {
							break;
						}

					}
				}
			} else if (num == 2) {
				boolean LogC = Cust.CheckLoginCustomer();
				if (LogC == true) {
					while (true) {
						int Cwork = Cust.CustomerWorkType();
						if (Cwork == 1) {
							Cust.MoneySender();
						} else if (Cwork == 2) {
							Cust.transactionhistory();
						} else {
							break;
						}
					}
				}
			} else if (num == 3) {
				break;
			}
		}

	}
}
