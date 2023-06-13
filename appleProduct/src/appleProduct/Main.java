package appleProduct;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean flagExit = true; //for storing the exit flag
		int moreChoice; //for storing the choice select of user
		/*
		 * iteration for apple program.
		 * if user wants to stop the apple program, user enters '1', otherwise user enters '0'.
		 * user can select 1 or 2 or 3 or 0.
		 * if user selects '0', the program is immediately come to end.
		 */
		while (flagExit) {
			System.out.println("==== Welcome Apple Korea");
			System.out.println("What do you want to buy?");
			System.out.println("Choose 1 for MacBook \nChoose 2 for iPhone \nChoose 3 for AirPods \nChoose 0 for Exit");
			Scanner input0 = new Scanner(System.in); 
			System.out.println("Please enter your choice: ");
			int choice = input0.nextInt(); //for storing the choice of apple product 
			System.out.println("==========================");
			/*
			 * switch for user select (1,2,3,0)
			 */
			switch(choice) {
			case 1: //choice : 1
				Macbook product1 = new Macbook(); //creating the object of class 'Macbook'
				System.out.printf("Base cost of the Macbook: $%d\n", product1.getBasePrice()); //printing base price
				System.out.println("Which model do you want (Macbook Air or Macbook Pro): ");
				Scanner input1 = new Scanner(System.in); 
				String MacModel = input1.nextLine(); //for storing user's choice of Macbook model
				product1.setModel(MacModel);
				
				System.out.println("Size(13 or 14 or 16 (inch)): ");
				Scanner input2 = new Scanner(System.in); 
				int MacSize = input2.nextInt(); //for storing user's choice of Macbook size
				product1.setSize(MacSize);
				
				System.out.println("Color (base, Gold, Silver): ");
				Scanner input3 = new Scanner(System.in); 
				String MacColor = input3.nextLine(); //for storing user's choice of Macbook color
				product1.setColor(MacColor);
				
				System.out.println("Memory (128 or 256 or 512)");
				Scanner input4 = new Scanner(System.in); 
				int MacMemory = input4.nextInt(); //for storing user's choice of Macbook memory
				product1.setMemory(MacMemory);
				
				System.out.println("How many do you want to buy:");
				Scanner input5 = new Scanner(System.in); 
				int Macqty = input5.nextInt(); //for storing user's choice of Macbook numbers
				product1.setQuantity(Macqty);
				
				System.out.println("===== check =====");
				product1.getUserSelection(); //printing user's check list for extra costs
				
				product1.calculateCost(); //calculating total costs
				
				System.out.printf("\nTotal cost for one Macbook: $%.2f\n", product1.getCost()); //printing single cost
				//printing number of product, total cost
				System.out.printf("Total cost (quantity x %d): $%.2f\n", product1.getQuantity(), product1.getTotalCost());
				
				System.out.println("Do you want to purchase something else (Yes : 1, No : 0): "); 
				Scanner input6 = new Scanner(System.in);
				moreChoice = input6.nextInt(); //storing user's input
				
				if (moreChoice == 0) { 
					flagExit = false; //changing flag exit to false in order to end the iteration
					System.out.println("Thank you for your purchase!");
				}
				
				break;
				
			case 2: //choice : 2
				iPhone product2 = new iPhone();
				System.out.printf("Base cost of the iPhone: $%d\n", product2.getBasePrice());
				
				System.out.println("Which model do you want (iPhone12 or iPhone13): ");
				Scanner input7 = new Scanner(System.in);
				String iPhoneModel = input7.nextLine();
				product2.setModel(iPhoneModel);
				
				System.out.println("Color (base, Gold, Silver): ");
				Scanner input8 = new Scanner(System.in);
				String iPhoneColor = input8.nextLine();
				product2.setColor(iPhoneColor);
				
				System.out.println("Memory (64 or 128 or 256 or 512)");
				Scanner input9 = new Scanner(System.in);
				int iPhoneMemory = input9.nextInt();
				product2.setMemory(iPhoneMemory);
				
				System.out.println("How many do you want to buy:");
				Scanner input10 = new Scanner(System.in);
				int iPhoneqty = input10.nextInt();
				product2.setQuantity(iPhoneqty);
				
				System.out.println("===== check =====");
				product2.getUserSelection();
				
				product2.calculateCost();
				
				System.out.printf("\nTotal cost for one Macbook: $%.2f\n", product2.getCost());
				System.out.printf("Total cost (quantity x %d): $%.2f\n", product2.getQuantity(), product2.getTotalCost());
				
				System.out.println("Do you want to purchase something else (Yes : 1, No : 0): ");
				Scanner input11 = new Scanner(System.in);
				moreChoice = input11.nextInt();
				if (moreChoice == 0) {
					flagExit = false;
					System.out.println("Thank you for your purchase!");
				}
				
				break;
				
			case 3: //choice : 3
				AirPods product3 = new AirPods();
				System.out.printf("Base cost of the AirPods: $%d\n", product3.getBasePrice());
				
				System.out.println("Which model do you want (AirPods3 or AirPodsPro or AirPodsMax): ");
				Scanner input12 = new Scanner(System.in);
				String iPodsModel = input12.nextLine();
				product3.setModel(iPodsModel);
				
				System.out.println("How many do you want to buy:");
				Scanner input13 = new Scanner(System.in);
				int iPodsqty = input13.nextInt();
				product3.setQuantity(iPodsqty);
				
				System.out.println("===== check =====");
				product3.getUserSelection();
				
				product3.calculateCost();
				
				System.out.printf("\nTotal cost for one Macbook: $%.2f\n", product3.getCost());
				System.out.printf("Total cost (quantity x %d): $%.2f\n", product3.getQuantity(), product3.getTotalCost());
				
				System.out.println("Do you want to purchase something else (Yes : 1, No : 0):");
				Scanner input14 = new Scanner(System.in);
				moreChoice = input14.nextInt();
				if (moreChoice == 0) {
					flagExit = false;
					System.out.println("Thank you for your purchase!");
				}
				
				break;
				
			case 0: //choice : 0
				flagExit = false; // changing the exit flag
				break;
			}
		}
	}
}
