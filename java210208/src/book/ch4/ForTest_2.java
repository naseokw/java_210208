package book.ch4;

class WhileClass {
	WhileClass() {
		guguWhile();
	}
	
	void guguWhile() {
		
		int i = 2;
		int j = 1;
		
		while (i < 10) {
			while (j < 10) {
				System.out.print("[" + i + " * " + j + " = " + (i * j) + "]	");
				j++;
			}
			System.out.println();
			i++;
			j = 1;
		}
	}
}

public class ForTest_2 {
	void guguFor() {
		for (int i = 2; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.print("[" + i + " * " + j + " = " + (i * j) + "]	");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		ForTest_2 ft = new ForTest_2();
		WhileClass wc = new WhileClass();
		ft.guguFor();
	}
}