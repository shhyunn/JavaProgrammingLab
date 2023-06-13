package midtermAssignment;

import midtermAssignment.User;

public class BankAccount {
	private String bankNumber; //for storing user's account
	private int pinCode; //for storing user's password
	private double balance; //for storing user's balance
	private User user; //for storing class 'user'
	
	public BankAccount(String bankNumber, int pinCode, double balance, User user) { //constructor for initializing 4 variables
		this.bankNumber = bankNumber;
		this.pinCode = pinCode;
		this.balance = balance;
		this.user = user;
	}

	public String getBankNumber() {
		return bankNumber;
	}

	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
