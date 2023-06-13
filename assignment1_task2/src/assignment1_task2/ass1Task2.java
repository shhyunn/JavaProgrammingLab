package assignment1_task2;

import java.util.Scanner;

public final class ass1Task2 {
	/*function for inputting days for getting money*/
	public static int inputDays() {
		Scanner input = new Scanner(System.in); 
		System.out.printf("Enter the number of days: ");
		int userDays = input.nextInt(); 
		return userDays ;
	}
	
	/*function for iterating days and adding money*/
	public static int iterateMoney(int day) {
		int moneySum = 0; //initialize sum of saving money
		int coin = 1; //initialize the money as one 
		
		/*iterate for days and add the coin*/
		for (int i = 1 ; i <= day; i++) {
			moneySum += coin; 
			/*if day is divided into 7, increase the coin one more
			 * This means a week has passed
			 */
		if (i % 7 == 0) {
		coin += 1;
			}
		}
		return moneySum;
	}
	
	public static void main(String[] args) {
		
		int userDays; //for storing days
		int getMoney; //for storing saved money
		userDays = inputDays();
		getMoney = iterateMoney(userDays);
		
		System.out.format("Total Frank's saving (after %d days): %d", userDays, getMoney);
	}
	

}
