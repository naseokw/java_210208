package thread.bakery;

public class Simulation {

	public static void main(String[] args) {
		BreadStack bs = new BreadStack();
		Producer p1 = new Producer(bs);
		p1.start();
		Producer p2 = new Producer(bs);
		p2.start();
		Producer p3 = new Producer(bs);
		p3.start();

		Consumer c1 = new Consumer(bs);
		c1.start();
		Consumer c2 = new Consumer(bs);
		c2.start();
		Consumer c3 = new Consumer(bs);
		c3.start();
	}
}
