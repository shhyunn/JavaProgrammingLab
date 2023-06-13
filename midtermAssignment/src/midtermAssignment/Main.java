package midtermAssignment;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		ArrayList<BankAccount> bankAccounts = new ArrayList<>(); //for storing user's bank account information(class object)
		//for class object each user's name
		User user1 = new User("Firuz");
		User user2 = new User("John");
		User user3 = new User("Eldor");
		
		//for creating the bank account object and adding at array list
		bankAccounts.add(new BankAccount("200100237898", 1234, 500000.0, user1));
		bankAccounts.add(new BankAccount("110000022033", 4321, 700000.0, user2));
		bankAccounts.add(new BankAccount("111111111111", 2222, 900000.0, user3));
		
		try {
			BankGUI frame = new BankGUI(bankAccounts); //for storing bank GUI program
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
