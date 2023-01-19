package com.masai.module;

import java.security.Timestamp;

public class Transaction {
	private int Trans_ID;
   private String Sender;
   private String Receiver ;
   private int Amount;
   private Timestamp transactionTime;
public Transaction() {
	super();
	// TODO Auto-generated constructor stub
}
public Transaction(int trans_ID, String sender, String receiver, int amount, Timestamp transactionTime) {
	super();
	Trans_ID = trans_ID;
	Sender = sender;
	Receiver = receiver;
	Amount = amount;
	this.transactionTime = transactionTime;
}
@Override
public String toString() {
	return "Transaction [Trans_ID=" + Trans_ID + ", Sender=" + Sender + ", Receiver=" + Receiver + ", Amount=" + Amount
			+ ", transactionTime=" + transactionTime + "]";
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
public Timestamp getTransactionTime() {
	return transactionTime;
}
public void setTransactionTime(Timestamp transactionTime) {
	this.transactionTime = transactionTime;
}
   
}
