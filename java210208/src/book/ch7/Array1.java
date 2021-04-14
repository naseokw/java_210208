package book.ch7;
/*
 * 배열은 한 번 선언하면 원손의 수를 조정할 수 없다
 * 끼워넣기가 안 된다
 * 
 * 
 */
public class Array1 {
	
	public void printArray(int[] empnos) {
		int cnt = 0;
		for (int i = 0; i < empnos.length; i++) {
			System.out.println(String.format("%02d", ++cnt) + "번 방 : " + empnos[i]);
		}
	}

	public static void main(String[] args) {
		int[] empnos = new int[10];
		Array1 a1 = new Array1();
		a1.printArray(empnos);
	}
}
