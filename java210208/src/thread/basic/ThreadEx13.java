package thread.basic;

class A extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print("-");
		}
		System.out.println("Thread 1 종료");
	}
}// end of class A

class B implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print("|");

		}
		System.out.println("Thread 2 종료");
	}
}// end of class B

public class ThreadEx13 {

	static long startTime = 0;
	/*
	 * [main thread 시작] - [스레드 로딩, 대기 - start()하면 실행 - A의 run() 실행 - B의 run() 실행]
	 * 
	 */

	public static void main(String[] args) {
		A th1 = new A();
		B th = new B();
		Thread th2 = new Thread(th);
		th1.start();
		th2.start();

		// 시간을 계산함
		startTime = System.currentTimeMillis();

		try {
			th1.join();
			th2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("소요 시간 : " + (System.currentTimeMillis() - ThreadEx13.startTime));
	}
}
