package level2.basic;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class A extends JFrame {

	JButton			jbtn		= null;
	boolean			isView		= false;
	JRadioButton	radioButton	= null;

	public A() {
		initDisplay();
	}

	public A(boolean isView) {
		this.isView = isView;
		initDisplay();
	}

	private void initDisplay() {
		String jbtnText = "Button";
		jbtn = new JButton(jbtnText);
		radioButton = new JRadioButton(jbtnText);
		this.add("South", jbtn);
		this.add("Center", radioButton);
		this.setSize(500, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(isView);
	}

	public static void main(String[] args) {
		new A(true);

	}
}
