package thread.bakery;

public class Consumer extends Thread {

	BreadStack bs = null;

	public Consumer(BreadStack bs) {
		this.bs = bs;
	}

	@Override
	public void run() {
		String bread = bs.pop();

		try {
			Thread.sleep((int) (Math.random() * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
