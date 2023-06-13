package bankProgram;

public class BankAccount {
	private String bankNumber;
	private int pinCode;
	private double balance;
	private User user;
	
	public BankAccount(String bankNumber, int pinCode, double balance, User user) {
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
