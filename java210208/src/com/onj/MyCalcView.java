package com.onj;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyCalcView extends JFrame {

	String[]			btnChar		= { "1", "2", "+", "=", "C" };
	JPanel				jp_text		= new JPanel(new BorderLayout());
	JPanel				jp_btn		= new JPanel(new GridLayout(1, 5, 10, 10));
	JTextField			jtf_result	= null;
//	JButton				jbt_one		= null;
//	JButton				jbt_two		= null;
//	JButton				jbt_plus	= null;
//	JButton				jbt_equals	= null;
//	JButton				jbt_clear	= null;
	JButton[]			jbtns		= null;
	MyCalcEventHandler	mceh		= null;

	public MyCalcView() {

		initDisplay();
	}

	public void initDisplay() {

		jtf_result = new JTextField();
		jtf_result.setHorizontalAlignment(JTextField.RIGHT);

		jp_text.add(jtf_result);
		jbtns = new JButton[btnChar.length];

		for (int i = 0; i < btnChar.length; i++) {
			jbtns[i] = new JButton(btnChar[i]);
			jp_btn.add(jbtns[i]);
		}
		mceh = new MyCalcEventHandler(jtf_result, jbtns[0], jbtns[1], jbtns[2], jbtns[3], jbtns[4]);

		for (int i = 0; i < jbtns.length; i++) {
			jbtns[i].addActionListener(mceh);
		}
		this.add("Center", jp_text);
		this.add("South", jp_btn);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setVisible(true);
	}

	public static void main(String[] args) {

		new MyCalcView();
	}
}
