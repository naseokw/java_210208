package book.ch4;

public class SwitchQuiz {

	public static void main(String[] args) {
		
//		for (int i = 1; i < 101;i++) {
//			switch (i % 35) {
//			case 0:
//				System.out.println("fizzbuzz");
//				break;
//			case 5: case 10: case 15: case 20: case 25: case 30:
//				System.out.println("fizz");
//				break;
//			case 7: case 14: case 21: case 28:
//				System.out.println("buzz");
//				break;
//			default:
//				System.out.println(i);
//				break;
//			}/////////////end of switch
//		}/////////////////end of for
		
		int index = 1;
		
		while (index < 101) {
			switch (index % 35) {
			case 0:
				System.out.println("fizzbuzz");
				break;
			case 5: case 10: case 15: case 20: case 25: case 30:
				System.out.println("fizz");
				break;
			case 7: case 14: case 21: case 28:
				System.out.println("buzz");
				break;
			default:
				System.out.println(index);
				break;
			}/////////////end of switch
			index++;
		}/////////////////end of while
		
	}/////////////////////end of main

}
