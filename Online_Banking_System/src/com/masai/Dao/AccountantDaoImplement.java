package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//import javax.security.auth.login.AccountException;

import com.masai.exception.AccountntException;
import com.masai.exception.CustomerException;
import com.masai.exception.TransactionException;
import com.masai.module.Customer;
import com.masai.module.Transaction;
import com.masai.utility.DBUtil;

public class AccountantDaoImplement implements AccountantDao {
   boolean flag = false;
   @Override
	public boolean LoginAccountant(String Username, String Password) throws AccountntException {
		// TODO Auto-generated method stub
	   
	   try(Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from Accountant where Username=? and password=?");
			ps.setString(1, Username);
			ps.setString(2, Password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				flag = true;
			}
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AccountntException(e.getMessage());
		}
	   
		return flag;
	}


	@Override
	public int InsertCustomer(String Name, String Username, String password, int AccountNo, int Amount)
			throws CustomerException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int UpdateCusomer(String Name, String Username, String password, int AccountNo, int Amount, int Trans_ID)
			throws CustomerException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delectCustomer(int AccountNo) throws CustomerException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int FindParticularAccountDetail(int AccountNo) throws CustomerException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Customer> FindAllCustomerDetail() throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> FindTransactionList() throws TransactionException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
