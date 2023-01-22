package com.masai.Dao;

//import java.security.DomainCombiner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.masai.custom.consolecolor;

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
	public boolean LoginAccountant(String Username, int Password) throws AccountntException {
		// TODO Auto-generated method stub
	   
	   try(Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from Accountant where Username=? and password=?");
			ps.setString(1, Username);
			ps.setInt(2, Password);
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
	public int InsertCustomer(String Name, String Username, int password, int AccountNo, int Amount)
			throws CustomerException {
		// TODO Auto-generated method stub
		int res=0;
		try(Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("insert into Customer (name,username,password,AccountNo,Amount) values(?,?,?,?,?)");
			ps.setString(1, Name);
			ps.setString(2, Username);
			ps.setInt(3, password);
			ps.setInt(4, AccountNo);
			ps.setInt(5, Amount);
			
			int A = ps.executeUpdate();
			
			if(A > 0) {
		      res++;
			}else {
				throw new CustomerException(consolecolor.RED+"username or passwod is wrong..."+consolecolor.RESET);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new CustomerException(e.getMessage());
		}
		return res;
	}

	@Override
	public int UpdateCusomer(String Name, String Username, int password, int AccountNo, int Amount, int CustomerID)
			throws CustomerException {
		// TODO Auto-generated method stub
		int res=0;
		
		
		
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement(
					
					"update Customer set Name = ?, Username = ?, password = ?, "
					+ "AccountNo = ?, Amount = ? where CustomerID=?");
			ps.setString(1, Name);
			ps.setString(2, Username);
			ps.setInt(3, password);
			ps.setInt(4, AccountNo);
			ps.setInt(5, Amount);
			ps.setInt(6, CustomerID);
			
			int A = ps.executeUpdate();
			
			if(A >0) {
				res++;
			}			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new CustomerException(e.getMessage());
		}
		return res;
	}

	@Override
	public int delectCustomer(int AccountNo) throws CustomerException {
		// TODO Auto-generated method stub
		int res =0;
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("delete from Customer where AccountNo = ?");
			
			ps.setInt(1, AccountNo);
			int A = ps.executeUpdate();
			
			if(A > 0) {
				res++;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new CustomerException(e.getMessage());
		}
		return res;
		
	}

	@Override
	public int FindParticularAccountDetail(int AccountNo) throws CustomerException {
		// TODO Auto-generated method stub
		int res =0;
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from Customer where AccountNo= ?");
			
			ps.setInt(1, AccountNo);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				res++;
				System.out.println(" ContomerId is" + rs.getInt("CustomerID") 
				+ "name is : " + rs.getString("Name") 
				+ " username is :" + rs.getString("Username")
				+ "password is " +rs.getString("password")
				+ " AccountNo is :" + rs.getInt("AccountNO")
				+ " Amount is :" + rs.getInt("Amount")
				);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new CustomerException(e.getMessage());
		}
		return res;

		
	}

	
	@Override
	public List<Customer> FindAllCustomerDetail() throws CustomerException {
		// TODO Auto-generated method stub
		List<Customer> list = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from Customer");
			
			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int CustomerId = rs.getInt("CustomerID");
				String Name = rs.getString("Name");
				String Username = rs.getString("Username");
			     int password = rs.getInt("password");
				int AccountNo = rs.getInt("AccountNo");
				int Amount = rs.getInt("Amount");
				
				Customer customer = new Customer(CustomerId , Name, Username, password, AccountNo, Amount);
				list.add(customer);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return list;
	}

	@Override
	public List<Transaction> FindTransactionList() throws TransactionException {
		// TODO Auto-generated method stub
		List<Transaction> list = new ArrayList<>();
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from Transaction");
			
			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int Trans_ID = rs.getInt("Trans_ID");
				String Sender = rs.getString("Sender");
				String Receiver = rs.getString("Receiver");
				int Amount = rs.getInt("Amount");
				String date = rs.getString("data");
				
				Transaction transaction = new Transaction( Trans_ID, Sender, Receiver, Amount,date);
				list.add(transaction);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return list; 
	}

	
}
