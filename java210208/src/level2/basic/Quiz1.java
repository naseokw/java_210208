package level2.basic;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Quiz1 extends JFrame {

	JButton			jbtn_one	= new JButton("one");
	JButton			jbtn_two	= new JButton("two");
	JButton			jbtn_three	= new JButton("three");
	JLabel			jlb			= new JLabel("현재시간", JLabel.CENTER);
	Container		cont		= this.getContentPane();
	TempCenterPanel	jp			= new TempCenterPanel();

	public void initDisplay() {
		JPanel jp = new JPanel(new GridLayout(1, 3, 3, 3));
		jbtn_one.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼 호출 성공");
				viewUpdate(e);
			}
		});
		jbtn_two.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("전체화면 변경하기");
				viewAllUpdate(e);
			}

		});
		jbtn_three.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("되돌리기");
				viewRevocer(e);
			}

		});
		jp.add(jbtn_one);
		jp.add(jbtn_two);
		jp.add(jbtn_three);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add("North", jp);
		this.add("South", jlb);
		this.setSize(400, 300);
		this.setVisible(true);
	}

	public void viewRevocer(ActionEvent e) {

		if (jp != null) {
			jp.remove(jp.jbtn_one);
			jp.remove(jp.jbtn_two);

		}
		JPanel jp2 = new JPanel();
		jp2.setBackground(Color.RED);
		this.add("Center", jp2);
		cont.revalidate();
	}

	public void viewAllUpdate(ActionEvent e) {
		// 선언부와 생성부를 다르게 하여 인스턴스화를 하면
		// 인스턴스 변수로는 수퍼타입에서 제공되는
		// 메서드만 사용할 수 있다. 즉, 서브클래스 메서드는 사용불가
//		JPanel			jp	= new TempCenterPanel();

		jp.initDisplay();
		this.add("Center", jp);
		cont.revalidate();
//		this.revalidate();
//		this.repaint();
	}

	public void viewUpdate(ActionEvent e) {
		cont.remove(jlb);
		cont.revalidate();
		this.remove(jbtn_one);
		this.revalidate();
		this.repaint();
	}

	public static void main(String[] args) {
		Quiz1 q1 = new Quiz1();
		q1.initDisplay();
	}
}
