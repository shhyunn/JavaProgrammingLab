package bankProgram;

import java.util.ArrayList;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		//System.out.println("Working Directory = " + System.getProperty("user.dir"));
		
		
		
		ArrayList<BankAccount> bankAccounts = new ArrayList<>();
		User user1 = new User("Firuz");
		User user2 = new User("John");
		User user3 = new User("Eldor");
		
		bankAccounts.add(new BankAccount("200100237898", 1234, 500000.0, user1));
		bankAccounts.add(new BankAccount("110000022033", 4321, 700000.0, user2));
		bankAccounts.add(new BankAccount("111111111111", 2222, 900000.0, user3));
		
		//bankGUI bankGUI = new bankGUI(bankAccounts);
		try {
			bankGUI frame = new bankGUI(bankAccounts);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		bankGUI.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		bankGUI.setSize(300, 400);
		bankGUI.setVisible(true);
		*/
	}

}
