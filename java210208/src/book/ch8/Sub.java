package book.ch8;

public class Sub extends Super {

	public Sub() {
		System.out.println("Sub() called successfully.");
	}

	public Sub(String title) {
		System.out.println("Sub() called successfully.");
		this.title = title;
	}

	@Override
	public void methodA() {
		System.out.println("Sub's methodA called");
	}

	public void methodA(int x) {
		System.out.println("Sub's methodA(int x) called");
	}

	public void methodB() {
		System.out.println("Sub's methodA called");
	}
}
