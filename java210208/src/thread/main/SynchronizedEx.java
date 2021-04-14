package thread.main;

public class SynchronizedEx {

	public static void main(String[] args) {
		ATM		atm		= new ATM();
		Thread	thread1	= new Thread(atm, "김경민");
		Thread	thread2	= new Thread(atm, "윤지원");
		Thread	thread3	= new Thread(atm, "이주상");

		thread1.start();
		thread2.start();
		thread3.start();
	}
}
