package book.ch7;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class RandArrayQuiz {
	
	int i;
	
	RandArrayQuiz() {
		i = 100;
	}
	
	int[] randCalc(int[] randArray) {
		Random rand = new Random();
		
		for (int i = 0; i < randArray.length; i++)
			randArray[i] = rand.nextInt(this.i);
		return randArray;
	}
	
	void randPrint(int[] randArray) {
		System.out.print("[ ");
		for (int index : randArray) {
			System.out.print(index + " ");
		}
		System.out.println("]");
	}
	
	void randSort(int[] randArray) {
		Arrays.sort(randArray);
		System.out.println("최댓값은 = " + randArray[randArray.length - 1]);
	}
	void randComp(int[] randArray) {
		int max = randArray[0];
		
		for (int i = 1; i < randArray.length; i++) {
			if (max <= randArray[i])
				max = randArray[i];
		}
		System.out.println("최댓값은 = " + max);
	}
}

public class ArrayQuiz1 {
	public static void main(String[] args) {
		RandArrayQuiz[] objArray = new RandArrayQuiz[2];
		objArray[0] = new RandArrayQuiz();
//		objArray[1] = objArray[0];
		int[] randArray = new int[10];
		
		objArray[0].randPrint(objArray[0].randCalc(randArray));
		objArray[0].randSort(randArray);
		objArray[0].randComp(randArray);
	}
}