package book.ch7;

public class Array2 {
	int x = 3;
	public static void main(String[] args) {
		Array2 a2 = new Array2();
		boolean[] isOk = new boolean[a2.x];
		for (boolean b : isOk)
			System.out.println(b);
	}

}
