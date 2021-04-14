package thread.bakery;

public class Producer extends Thread {

	BreadStack bs = null;

	public Producer(BreadStack bs) {
		this.bs = bs;
	}

	public String getBread() {
		String bread = null;

		switch ((int) (Math.random() * 3)) {
		case 0:
			bread = "바게뜨";
			break;
		case 1:
			bread = "샌드위치";
			break;
		case 2:
			bread = "도넛";
			break;
		}
		return bread;
	}

	@Override
	public void run() {
		String bread = getBread();

		try {
			bs.push(bread);
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
