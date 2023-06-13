package week2_practice2;

import java.util.Random;
import java.util.Scanner;

public class week2_practice2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter number of dices: ");
		int dice_num = input.nextInt();
		
		System.out.println("Enter number of rolls: ");
		int dice_roll = input.nextInt();
		
		int [] arraySum = new int[6*dice_num];
		
		for (int i = 0; i < dice_roll; i++) {
			Random randomGenerator = new Random();
			int sum = 0;
			for (int j = 0; j < dice_num; j++) {
				int randomInt = randomGenerator.nextInt(7);
				sum += randomInt;
			}
			arraySum[sum-1] += 1;
		}
		for (int k = 0; k < arraySum.length;k++) {
			float percentages =(arraySum[k]*100)/dice_roll;
			System.out.printf("Sum: %d Frequency: %d Percentages : %.2f\n", k+1, arraySum[k], percentages);
		}
		
	}

}
