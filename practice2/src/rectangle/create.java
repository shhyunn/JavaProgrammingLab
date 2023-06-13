package rectangle;

import java.util.Scanner;

public class create {

	public static void main(String[] args) {
		rectangle rec1;
		rec1 = new rectangle();
		System.out.println("Rectangle created");
		//rec1.printRectangle();
		while (true) {
			rec1.printMenu();
			Scanner input = new Scanner(System.in);
			System.out.println("Choice: ");
			int choice = input.nextInt();
			if (choice == 1) {
				
				Scanner input1 = new Scanner(System.in);
				System.out.println("Enter Length: ");
				double length = input1.nextDouble();
				rec1.setHeight(length);
			}
			else if (choice == 2) {
				Scanner input2 = new Scanner(System.in);
				System.out.println("Enter Width: ");
				double width = input2.nextDouble();
				rec1.setWidth(width);
			}
			else if (choice == 3) {
				break;
			}
			System.out.print(rec1);
		}
	}

}
