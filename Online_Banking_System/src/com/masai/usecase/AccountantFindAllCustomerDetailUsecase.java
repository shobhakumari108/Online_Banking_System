package com.masai.usecase;

import java.util.List;

import com.masai.Dao.AccountantDao;
import com.masai.Dao.AccountantDaoImplement;
import com.masai.exception.CustomerException;
import com.masai.module.Customer;

public class AccountantFindAllCustomerDetailUsecase {

	public void FindAllCustomerDetail() throws CustomerException {
		AccountantDao dao = new AccountantDaoImplement();
		List<Customer> list = dao.FindAllCustomerDetail();
		list.forEach(res-> System.out.println(res));
		
	}
	
}
