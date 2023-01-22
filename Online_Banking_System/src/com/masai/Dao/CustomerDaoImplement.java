package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.masai.exception.CustomerException;
import com.masai.exception.TransactionException;
import com.masai.module.Transaction;
import com.masai.utility.DBUtil;

public class CustomerDaoImplement implements CustomerDao{

	@Override
	public boolean loginCustomer(String Username, int password) throws CustomerException {
		// TODO Auto-generated method stub
		
		boolean flag = false;
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from Customer where Username =? and password=?");
			
			ps.setString(1, Username);
			ps.setInt(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			
			if(rs.next()) {
				flag = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new CustomerException(e.getMessage());
		}
		return flag;
	}
//****************************************************************************************************
	@Override
	public String SenderUsername(String Username, int password) throws CustomerException {
		// TODO Auto-generated method stub
		
		String name = null;//*****************
				try(Connection conn = DBUtil.provideConnection()){
					
					PreparedStatement ps = conn.prepareStatement("select * from Customer where Username=? and password=?");
					
					ps.setString(1, Username);
					ps.setInt(2, password);
					
					ResultSet rs = ps.executeQuery();
					
					
					if(rs.next()) {
						name= rs.getString("name");//******************
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new CustomerException(e.getMessage());
				}	
		return name;
	}
//*******************************************************************************************
	@Override
	public int Moneytranfer(String SUsername, String RUsername, int Amount) throws CustomerException {
		// TODO Auto-generated method stub
		int res=0;
		java.util.Date date = Calendar.getInstance().getTime();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		
		String strDate = dateFormat.format(date);
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into transaction (Sender,Receiver,Amount,data)  values(?,?,?,?)");
			
			ps.setString(1, SUsername);
			ps.setString(2, RUsername);
			ps.setInt(3,Amount);
			ps.setString(4, strDate);
			int A = ps.executeUpdate();

			if (A > 0) {
				res++;
			}

		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		
		return res;
	}
//*************************************************************************************
	@Override
	public String ReciverUsername(int id) throws CustomerException {
		// TODO Auto-generated method stub
		String Name_Of_usere = null;
try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from Customer where CustomerID=?");//*********************;
			
			
			ps.setInt(1,id);
			
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Name_Of_usere = rs.getString("UserName");
			}

		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		
				
		return Name_Of_usere;
	}
//*************************************************************************************************************
	@Override
	public int CheckSufficientAmount(String Username) throws CustomerException {
		// TODO Auto-generated method stub
		int res = 0;
		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from Customer where Username=?");
			
			ps.setString(1, Username);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				res = rs.getInt("Amount");
			}

		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());

		}
		return res;
	}
//********************************************************************************************************************
	@Override
	public int SubtractSenderMoney(int Amount, String Username) throws CustomerException {
		// TODO Auto-generated method stub
		int res = 0;
		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("update Customer set Amount=Amount-? where Username=? and Amount-?>=0 ");
			
			ps.setInt(1, Amount);			
			ps.setString(2, Username);
			ps.setInt(3, Amount);
			int rs = ps.executeUpdate();
			
			if (rs > 0) {
				res++;
			}

		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());

		}
		return res;
	}
//**********************************************************************************************************************
	@Override
	public int AddReciverAmount(int Amount, String Username) throws CustomerException {
		// TODO Auto-generated method stub
		int res = 0;
		
		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("update Customer set Amount = Amount+? where Username=? ");
			
			ps.setInt(1, Amount);
			ps.setString(2, Username);
			int rs = ps.executeUpdate();
			
			if (rs>0) {
				res++;
			}

		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());

		}
		return res;
	}
//*****************************************************************************************************************
	@Override
	public List<Transaction> checkTransfermationHistory(String Username) throws TransactionException {
		// TODO Auto-generated method stub
		List<Transaction> list = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from tranSaction where Sender=? ");
			
			ps.setString(1, Username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int cid = rs.getInt("Trans_ID");
				
				String Sender = rs.getString("Sender");
				
				String Receiver = rs.getString("Receiver");
				
				int Amount = rs.getInt("Amount");
				
				String date = rs.getString("data");
				
				Transaction tr = new Transaction(cid, Sender, Receiver, Amount, date);
				list.add(tr);
			}
			
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}

		return list;
	}


}



