package thread.main;

public class ATM extends Thread {

	private int depositedMoney = 10000;

	@Override
	public void run() {

		synchronized (this) {

			for (int i = 0; i < 10; i++) {

				try {
					Thread.sleep(500);
//					this.notifyAll();
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				withDraw(1000);

//				try {
//					this.wait();
//				}
//				catch (InterruptedException e) {
//					e.printStackTrace();
//				}
			} // end of for
		} // end of synchronized
	}// end of run()

	private void withDraw(int howMuch) {

		if (depositedMoney > 0) {
			depositedMoney -= howMuch;
			System.out.print(Thread.currentThread().getName());
			System.out.printf(": 잔액 : %,d원%n", depositedMoney);
		}
		else {
			System.out.print(Thread.currentThread().getName());
			System.out.println(": 잔액이 부족합니다.");
		}
	}
}
