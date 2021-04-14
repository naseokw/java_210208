package my.exam;

import java.util.Scanner;

public class MultipleInput {
	int[] myScan(int[] array) {
		Scanner s = new Scanner(System.in);
		
		for (int i = 0; i < 2; i++) {
			System.out.print((i + 1) + "번째 양의 정수를 입력하시오 : ");
			array[i] = s.nextInt();
			
			if (array[i] < 1) {
				System.out.println("양의 정수를 입력하십시오.");
				i--;
			}
		}
		s.close();
		return array;
	}
}