package book.ch7;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class RandGenerator {		//난수 생성 클래스
	
	int i;
	
	RandGenerator(UserBoundScan ubs, int[] randArray) { //난수 바운드 입력 받아서 randGen 메서드 콜
		this.i = ubs.boundScan();
		randGen(randArray);
	}
	int[] randGen(int[] randArray) {	//매개변수 배열 받아서 난수 생성 및 배열에 저장
		Random rand = new Random();
		
		for (int i = 0; i < randArray.length; i++)
			randArray[i] = rand.nextInt(this.i);
		return randArray;
	}
}

class RandPrint {	//난수 출력 클래스
	void randPrint(int[] randArray) {	//배열 난수값 출력 메서드
		System.out.print("[ ");
		for (int index : randArray) {
			System.out.print(index + " ");
		}
		System.out.println("]");
	}
}

class RandSortOrComp {	//정렬해서 마지막 인덱스값 출력하거나 비교해서 max값 출력 클래스
	void randSort(int[] randArray) {	//오름차순 정렬 및 크기-1값 출력(최댓값)
		Arrays.sort(randArray);
		System.out.println("최댓값은 = " + randArray[randArray.length - 1]);
	}
	void randComp(int[] randArray) {	//비교 및 최댓값 출력 메서드
		int max = randArray[0];
		
		for (int i = 1; i < randArray.length; i++) {
			if (max <= randArray[i])
				max = randArray[i];
		}
		System.out.println("최댓값은 = " + max);
	}
}

class UserBoundScan {	//난수의 바운드값을 유저로부터 입력받음, RandGenerator 클래스 생성자가 콜함
	int boundScan() {	//바운드값 입력 받는 메서드
		int input;
		Scanner scan = new Scanner(System.in);
		System.out.print("수의 범위를 입력하시오(양의 정수) : ");
		input = scan.nextInt();
		scan.close();
		return input;
	}
}

public class ArrayQuiz1_1 {
	public static void main(String[] args) {
		
		int[] randArray = new int[10];
		RandGenerator r_generator = new RandGenerator(new UserBoundScan(), randArray);
		RandPrint r_print = new RandPrint();
		RandSortOrComp r_sortComp = new RandSortOrComp();
		r_print.randPrint(randArray);
		r_sortComp.randComp(randArray);
	}
}