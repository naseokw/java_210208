package book.ch8;

public class Super {

	String		title	= null;
	private int	a		= 10;

	public Super() {

		System.out.println("Super() called successfully.");
	}

	public Super(String title) {

		System.out.println("Super() called successfully.");
		this.title = title;
	}

	public void methodA() {

		System.out.println("Super's methodA called");
	}
}
