package book.ch6;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ClassGubun extends JFrame {

	JButton	button_search	= new JButton("조회");
	JButton	button_close	= new JButton("닫기");

	public ClassGubun() {
		start();
	}

	public void start() {
//		button_search.addActionListener(this);
//		button_search.addActionListener(ClassGubun$1.class);
		button_search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("조회 버튼");
			}
		});
		button_close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("닫기 버튼");
			}
		});
	}

	public void initDisplay() {
		this.setLayout(new FlowLayout());
		this.add(button_search);
		this.add(button_close);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(400, 300);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		ClassGubun test = new ClassGubun();
		test.initDisplay();
	}
}
