package thread.main;

class MyRunningOne implements Runnable {

	@Override
	public void run() {
		System.out.println("run()");
		first();
	}

	public void first() {
		System.out.println("first()");
		second();
	}

	public void second() {
		System.out.println("second()");
	}
}

public class MainThread1_1 {

	public static void main(String[] args) {
		System.out.println("main() start");
		Runnable	runnable	= new MyRunningOne();
		Thread		thread		= new Thread(runnable);
		thread.start();
		System.out.println("main() end");
	}
}
