package com.masai.module;

public class Transaction {
   private String Sender;
   private String Receiver ;
   private int Amount;
   private int Data;
public Transaction() {
	super();
	// TODO Auto-generated constructor stub
}
public Transaction(String sender, String receiver, int amount, int data) {
	super();
	Sender = sender;
	Receiver = receiver;
	Amount = amount;
	Data = data;
}
@Override
public String toString() {
	return "Transaction [Sender=" + Sender + ", Receiver=" + Receiver + ", Amount=" + Amount + ", Data=" + Data + "]";
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
public int getData() {
	return Data;
}
public void setData(int data) {
	Data = data;
}
   
   
}
