package com.ocjp;
/**************************************
 * ++i는 i = i + 1과 같다?
 * --1은 i = i - 1과 같다?
 * i++는 postfix이므로 먼저 비교하고 나중에 1을 증가시킴
 * ++i prefix이다 
 *
************************************ */

public class Exam1 {

	public static void main(String[] args) {

		int i = 1;
		int j = 2;
		
		if ((++i > j--) & (++i > j)) {
			System.out.println("if");
		}
		else {
			System.out.println("else");
		}
		System.out.printf("%d, %d\n", i, j);
//		System.out.print(i + ", " + j);
		
		i = 1;
		j = 2;
		
		int temp_i = i;
		int temp_j = j;
		
		if ((++i > j--) && (++i > j)) {
			System.out.println("if");
		}
		else {
			System.out.println("else");
		}
		
		System.out.println(temp_i + ", " + temp_j);
		System.out.printf("%d, %d\n", i, j);
	}
}
