package com.onj;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyCalcFusion extends JFrame implements ActionListener {

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

	String				v1			= "";
	String				v2			= "";
	String				op			= "";

	public MyCalcFusion() {

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
			jbtns[i].addActionListener(this);
		}
		this.add("Center", jp_text);
		this.add("South", jp_btn);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();

		if (obj == jbtns[0]) {
			jtf_result.setText(jtf_result.getText() + "1");
		}
		else if (obj == jbtns[1]) {
			jtf_result.setText(jtf_result.getText() + "2");
		}
		else if (obj == jbtns[2]) {
			v1 = jtf_result.getText();
			System.out.println("v1 : " + v1);
			op = "+";
			jtf_result.setText("");
		}
		else if (obj == jbtns[3]) {
			v2 = jtf_result.getText();
			System.out.println("v1 = " + v1 + "-> v2 = " + v2 + " op : " + op);
			String result = MyCalcFusion.calc(v1, v2, op);
			jtf_result.setText(result);
		}
		else if (obj == jbtns[4]) {
			jtf_result.setText("");
		}
	}

	public static String calc(String sValue1, String sValue2, String sOp) {

		double	v1	= Double.parseDouble(sValue1);
		double	v2	= Double.parseDouble(sValue2);

		System.out.println("sValue1 : " + sValue1 + " : sValue2 : " + sValue2 + " ==> " + sOp);

		if (sOp.equals("+")) {
			return "" + (v1 + v2);
		}
		else {
			return "error";
		}
	}

	public static void main(String[] args) {

		new MyCalcFusion();
	}
}
