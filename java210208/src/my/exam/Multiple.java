package my.exam;

public class Multiple {
	
	int[] exchangeInt(int[] array) {
		int temp = 0;
		
		if (array[0] > array[1]) {
			temp = array[0];
			array[0] = array[1];
			array[1] = temp;
		}
		return array;
	}

	public static void main(String[] args) {
		MultipleInput mc = new MultipleInput();
		Multiple m = new Multiple();
		
		int[] storage = new int[2];

		int counter = 0;
		
		m.exchangeInt(mc.myScan(storage));
		
		for (int i = storage[0]; i <= storage[1]; i++) {
			if (i % 3 == 0) {
				counter += 1;
			}
		}
		System.out.println("3의 배수는 " + counter + "개 입니다");
	}
}
