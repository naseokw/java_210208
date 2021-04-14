package my.exam;

import java.util.Scanner;

public class GeoSequence {
	
	void geometricSeq(double a, double r) {
		
		double result = a;
		
		System.out.println("1항 : " + a + " ");
		
		for(int i = 1; i < 7; i++) {
			result = result * r;
			System.out.println((i + 1) + "항 : " + result + " ");
		}
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		GeoSequence gs = new GeoSequence();
		
		System.out.print("초항 a를 입력하시오 : ");
		double a = s.nextDouble();
		System.out.print("공비 r을 입력하시오 : ");
		double r = s.nextDouble();
		
		gs.geometricSeq(a, r);
		
		s.close();
	}
}
