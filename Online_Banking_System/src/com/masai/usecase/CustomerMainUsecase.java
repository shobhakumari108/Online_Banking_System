package com.masai.usecase;

import java.util.List;
import java.util.Scanner;

import com.masai.Dao.CustomerDao;
import com.masai.Dao.CustomerDaoImplement;
import com.masai.custom.consolecolor;
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
			System.out.println(consolecolor.ROSY_PINK+ "enter Your Username"+consolecolor.RESET);
			String Username = scanner.next();
			
			System.out.println(consolecolor.ROSY_PINK+ "enter Your Password"+consolecolor.RESET);
			int Password = scanner.nextInt();
			
			boolean res = dao.loginCustomer(Username, Password);
			if (res == true) {
				
				this.Username = Username;
				this.password = Password;
				this.name = dao.SenderUsername(Username, Password);//************************
				
				System.out.println(consolecolor.GREEN+"login Sucessfully"+consolecolor.RESET);
				flag = true;
				break;
			} else {
				System.out.println(consolecolor.RED+"Wrong your username and password"+consolecolor.RESET);
			}
		}

		return flag;
	}
	
//**************************************************************************************************
	public int CustomerWorkType() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(
				consolecolor.PURPLE+"+-----------------------------------------------------------+			\r\n"
						+ "|                   ENTER YOUR NUMBER           	    |\r\n"
						+ "+-----------------------------------------------------------+			\r\n"
						+ "|                                               	    | \r\n"
						+ "| 1. Transfer the money from his account to another account |\r\n"
						+ "| 2. Checking the transaction history                       |\r\n"
						+ "| 3. Exit                                                   |\r\n"
						+ "+-----------------------------------------------------------+"+consolecolor. RESET);
		System.out.println(consolecolor.TEAL+"Enter your number accoding your work"+consolecolor.TEAL);
		int accordingWork = scanner.nextInt();
		return accordingWork;
	}

//	******************************************************************
	public void MoneySender() throws CustomerException {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(consolecolor.ROSY_PINK+"Enter Reciver ID"+consolecolor.RESET);
		int id = scanner.nextInt();
		
		String rUsername = dao.ReciverUsername(id);
		
		if (rUsername == null) {
			System.out.println(consolecolor.ROSY_PINK+"Enter correcet reciver id or this person not any account"+consolecolor.RESET);
			return;
		}
		System.out.println(consolecolor.ROSY_PINK+"Enter Amount"+consolecolor.RESET);
		int Amount = scanner.nextInt();
		
		int AmountCheck = dao.CheckSufficientAmount(this.Username);
		
		if (AmountCheck < Amount) {
			System.out.println(consolecolor.RED+"your amount is not Sufficeent"+consolecolor.RESET);
			return;
		}
		
		int i = dao.Moneytranfer(this.Username, rUsername, Amount);
		if (i == 1) {
			System.out.println(consolecolor.GREEN+"send your money SuccessFully"+consolecolor.RESET);
			
			int subM = dao.SubtractSenderMoney(Amount, this.Username);
			
			int reciM = dao.AddReciverAmount(Amount, rUsername);
			
			if (subM == 1 && reciM == 1) {
				System.out.println(consolecolor.GREEN+"process is complete..."+consolecolor.RESET);
			}

		} else {
			System.out.println(consolecolor.RED+"no send money"+consolecolor.RESET);
		}

	}
	public void transactionhistory () throws TransactionException {
		
	List<Transaction> list=dao.checkTransfermationHistory(this.Username);
	
	list.forEach(dao->System.out.println(consolecolor.YELLOW+dao+consolecolor.RESET));
	}

}
