package week2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class week2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] array = { "Hello", "nice evening", "Java coding" };
		int[] intArray = { 2, 4, 1, 8, 6, 9, 0, 7 };
		int[] copyArray = new int[intArray.length];

		copyArray = Arrays.copyOf(intArray, intArray.length);

		Arrays.sort(intArray);

		for (int i = 0; i < copyArray.length; i++) {
			System.out.print(copyArray[i] + " ");
		} // C++

		System.out.print("\n");

		System.out.print(intArray);

		System.out.print(Arrays.toString(intArray));

		for (String element : array) {
			System.out.println(element);
		} // Java

		Random randomGenerator = new Random(221); //시드 설정 가능
		for (int i = 0; i < 10; i++) {
			int rand = randomGenerator.nextInt(10); // 실수형 nextFloat
			System.out.println(rand);
		}
		
		Scanner input = new Scanner(System.in); //내 키보드에서 입력받기
		System.out.println("Please insert your answer:");
		int answer = input.nextInt(); //콘솔로 입력 받기
		
		//String answer = input.nextLine();
		
		System.out.println("You inserted " + answer);
	}

}
