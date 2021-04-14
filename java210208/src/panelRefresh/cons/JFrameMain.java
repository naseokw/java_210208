package panelRefresh.cons;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class JFrameMain extends JFrame implements ActionListener {

	JPanel jp = new JPanel(new BorderLayout());
	JTextArea jta = new JTextArea();
	JButton jbtn_change = new JButton("화면 변경");

	public JFrameMain() {
		initDisplay();
	}

	public void initDisplay() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		jta.setBackground(Color.ORANGE);
		jp.add("Center", jta);
		this.add("Center", jp);
		jbtn_change.addActionListener(this);
		this.add("South", jbtn_change);
		this.setSize(500, 400);
		this.setTitle("JFrameMain");
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new JFrameMain();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == jbtn_change) {
			Container cont = this.getContentPane();
			if (jp != null) {
				cont.remove(jp);
				cont.remove(jbtn_change);
			}
			JPanel1 jp1 = null;
			jp1 = new JPanel1();
			this.add("Center", jp1);
			cont.revalidate();
		}
	}
}
