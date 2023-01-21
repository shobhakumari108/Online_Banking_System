package com.masai.module;

import java.security.Timestamp;

public class Transaction {
	private int Trans_ID;
   private String Sender;
   private String Receiver ;
   private int Amount;
   private String date;
public Transaction() {
	super();
	// TODO Auto-generated constructor stub
}
public Transaction(int trans_ID, String sender, String receiver, int amount, String date) {
	super();
	Trans_ID = trans_ID;
	Sender = sender;
	Receiver = receiver;
	Amount = amount;
	this.date = date;
}
@Override
public String toString() {
	return "Transaction [Trans_ID=" + Trans_ID + ", Sender=" + Sender + ", Receiver=" + Receiver + ", Amount=" + Amount
			+ ", date=" + date + "]";
}
public int getTrans_ID() {
	return Trans_ID;
}
public void setTrans_ID(int trans_ID) {
	Trans_ID = trans_ID;
}
public String getSender() {
	return Sender;
}
public void setSender(String sender) {
	Sender = sender;
}
public String getReceiver() {
	return Receiver;
}
public void setReceiver(String receiver) {
	Receiver = receiver;
}
public int getAmount() {
	return Amount;
}
public void setAmount(int amount) {
	Amount = amount;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}

}
