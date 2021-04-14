package level2.basic;

import javax.swing.JFrame;

public class Test0329_1 extends JFrame {
	// 선언부 - 멤버변수, 스태틱변수, 클래스급, 인스턴스화, 배열 선언
	// 안 되는 것 - 선언 후 초기화를 분리하는 문장
	// 제어문 사용 불가
	// 메서드 호출 불가

	private void subMethod() {
		System.out.println("nothing");
	}

	JFrame jf = new Test0329_1();

	public static void main(String[] args) {

	}
}
