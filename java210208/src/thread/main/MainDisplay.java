package thread.main;

import javax.swing.JFrame;

public class MainDisplay extends Thread {

	JFrame jf = null;

	public void initDisplay() {
		System.out.println("initDisplay() called successfully.");
		jf = new JFrame();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(400, 300);
		jf.setTitle("☆★☆★BEFORE★☆★☆");
		jf.setVisible(true);
	}

	@Override
	public void run() {
		System.out.println("run() called successfully.");

		try {
			sleep(5000);

			for (double d = 0; d < 100; d++) {
				System.out.println("d = " + d);

				if (jf != null) {
					jf.setTitle("★☆★☆AFTER☆★☆★");
					jf.revalidate();
				}
			}
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MainDisplay md = new MainDisplay();
		md.initDisplay();
		md.run();
	}
}
