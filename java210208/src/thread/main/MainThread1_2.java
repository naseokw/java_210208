package thread.main;

class MyRunningTwo implements Runnable {

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

public class MainThread1_2 {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " start");
		Runnable	runnable	= new MyRunningTwo();
		Thread		thread		= new Thread(runnable);
		thread.start();

		try {
			thread.join();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " end");
	}
}
