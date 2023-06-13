package week2_practice1;

import java.util.Random;
import java.util.Scanner;

public class week2_practice1 {
	
	public static int question(int num1, int num2) {
		
		
		Scanner input = new Scanner(System.in); //내 키보드에서 입력받기
		System.out.printf("How much is %d times %d?",num1, num2);
		System.out.println("Enter your answer (-1 to exit): ");
		int answer = input.nextInt(); //콘솔로 입력 받기
		return answer;
	}
	
	public static int compare(int result, int user) {
		if (user == -1) {
			return -1;
		} else if (result == user){
			return 0;
		} else {
			return 1;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int status = 0;
		int randomInt1 = 0;
		int randomInt2 = 0;
		boolean boolType = true;
		while (boolType) {
			if (status != -1) {
				Random randomGenerator = new Random();
				randomInt1 = randomGenerator.nextInt(100);
				randomInt2 = randomGenerator.nextInt(100);
			}
			
			int user_num = question(randomInt1, randomInt2);
			int result_num = randomInt1 * randomInt2;
			
			int result = compare(result_num, user_num);
			
			switch (result) {
			case 1:
				System.out.println("No. Keep trying.");
				status = -1;
				break;
			case 0:
				System.out.println("Very good!!");
				status = 1;
				break;
			case -1:
				boolType = false;
				break;
			}
		}
	}
}
