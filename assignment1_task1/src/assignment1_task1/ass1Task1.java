package assignment1_task1;

import java.util.Scanner;

public final class ass1Task1 {
	/* function for inputting user's name */
	public static String inputName() {
		Scanner input = new Scanner(System.in); 
		System.out.printf("Your name: ");
		String userName = input.nextLine(); 
		return userName;
	}
	/* function for inputting user's initial balance */
	public static float inputBalance() {
		Scanner input = new Scanner(System.in); 
		System.out.printf("Initial Balance: ");
		float userBalance = input.nextFloat(); 
		return userBalance;
	}
	/* function for inputting percentage, meaning interest */
	public static float inputPercentage() {
		Scanner input = new Scanner(System.in); 
		System.out.printf("Percentage: ");
		float userPercentage = input.nextFloat(); 
		return userPercentage;
	}
	/* function for inputting number of years */
	public static int inputYears() {
		Scanner input = new Scanner(System.in); 
		System.out.printf("Number of years: ");
		int userYears = input.nextInt(); 
		return userYears;
	}
	
	public static void main(String[] args) {
		
		String userName = inputName(); //for storing the bank user's name
		float userBalance = inputBalance(); //for storing the bank user's balance
		float userPercentage = inputPercentage(); //for storing the percentage
		int userYears = inputYears(); // for storing the years
		
		float finalBalance = userBalance; //initialize the final balance as initial balance

		/*iterating for getting balance increase for year*/
		for (int i = 1; i <= userYears; i++) {
			//adding the percentage of previous balance
			finalBalance = finalBalance + finalBalance * (userPercentage / 100); 
		}
		
		/* print user's name, percentage, final balance */
		System.out.println("===============================");
		System.out.println("Your name: "+userName);
		System.out.format("Percentage: %.1f\n", userPercentage);
		System.out.format("Your balance (after %d years): %.1f\n", userYears, finalBalance);
	}

}
