package com.onj;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class YourCalcView extends JFrame {

	String[]		btnChar		= { "1", "2", "+", "=", "C" };
	JPanel			jp_text		= new JPanel(new BorderLayout());
	JPanel			jp_btn		= new JPanel(new GridLayout(1, 5, 10, 10));
	JTextField		jtf_result	= null;
	JButton[]		jbtns		= null;
	YourCalcLogic	ycl			= null;

	public YourCalcView() {

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
		ycl = new YourCalcLogic(this);

		for (JButton index : jbtns) {
			index.addActionListener(ycl);

		}
		this.add("North", jp_text);
		this.add("Center", jp_btn);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500, 150);
		this.setVisible(true);
	}

	public static void main(String[] args) {

		new YourCalcView();
	}
}
