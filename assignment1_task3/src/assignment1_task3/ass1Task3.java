package assignment1_task3;

import java.util.Random;
import java.util.Scanner;

public final class ass1Task3 {
	/*function for asking the add question and judge the answer is the correct answer*/
	public static int getCorrectAnswer() {
		int correctAnswer = 0; //initialize the variable of correct answer count
		/*iterating for creating the random number and asking the correct answer for five times*/
		for (int i = 0; i < 5; i++) {
			Random randomGenerator = new Random();
			int randomInt1 = randomGenerator.nextInt(50); // creating the random number 1
			int randomInt2 = randomGenerator.nextInt(50); //creating the random number 2
			int realAnswer = randomInt1 + randomInt2; //for storing the real answer
			
			Scanner input = new Scanner(System.in); 
			System.out.format("Question %d - Calculate the addition (%d + %d): ", i+1, randomInt1, randomInt2);
			int userAnswer = input.nextInt(); //for storing the user's answer
			if (realAnswer == userAnswer) { //if user's answer is the correct answer, add the correct answer plus one
				correctAnswer += 1;
			}
		}
		return correctAnswer;
	}
	/*function for printing the right comment according to correct answer*/
	public static void printComment(int correctAnswer) {
		switch (correctAnswer) {
		case 0:
			System.out.println("Try again.");
			break;
		case 1:
			System.out.println("Very bad.");
			break;
		case 2:
			System.out.println("Not bad.");
			break;
		case 3:
			System.out.println("Good.");
			break;
		case 4:
			System.out.println("Very good!");
			break;
		case 5:
			System.out.println("Excellent!");
			break;
		}
	}

	public static void main(String[] args) {
		int correctAnswer;
		System.out.print("Generating a random integer in range 0~49\n");
		
		correctAnswer = getCorrectAnswer();
		
		System.out.format("Number of correct answers: %d\n",correctAnswer);
		
		printComment(correctAnswer);
	
	}
}
