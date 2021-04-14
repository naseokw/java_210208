package book.ch8;

public class SuperAndSubTest {

	public static void main(String[] args) {
		Super	sup		= new Super();
		Super	sup2	= new Sub();
		Sub		sub		= new Sub();

		sup.methodA();

		// sub의 메서드만 호출됨. super의 메서드는 shadow 메서드가 됨
		sup2.methodA();
		sub.methodA();
		sub.methodB();

	}
}
