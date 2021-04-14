package variable.step1;

import java.util.Scanner;

public class Account1_1 {
	
	double sum(double kor,	double math, double eng) {
		double sumScore = kor + math + eng;
		System.out.print("점수 합 : " + sumScore + ", ");
		return sumScore;
	}
	
	double mean(double sum, int classNum) { //평균의 평균을 낼 수도 있기 때문에 return 줬음
		double meanScore = sum / classNum;
		System.out.println("평균 : " + String.format("%.2f", meanScore));
		return  meanScore;
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		Account1_1 acc = new Account1_1();
		double[] korScore = new double[1000];
		double[] mathScore = new double[1000];
		double[] engScore = new double[1000];
		int classNum = 3;
		
		for (int i = 1; i <= 1000; i++) {
			
			System.out.print(i + "번째 학생의 국어 점수를 입력하시오 : ");
			korScore[i] = s.nextDouble();
			System.out.print(i + "번째 학생의 수학 점수를 입력하시오 : ");
			mathScore[i] = s.nextDouble();
			System.out.print(i + "번째 학생의 영어 점수를 입력하시오 : ");
			engScore[i] = s.nextDouble();
			acc.mean(acc.sum(korScore[i], mathScore[i], engScore[i]), classNum);
		}
		s.close();
	}
}
