package com.onj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class YourCalcLogic implements ActionListener {

	YourCalcView	ycv	= null;

	String			v1	= "";
	String			v2	= "";
	String			op	= "";

	public YourCalcLogic(YourCalcView ycv) {

		this.ycv = ycv;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();

		if (obj == ycv.jbtns[0]) {
			ycv.jtf_result.setText(ycv.jtf_result.getText() + "1");
		}
		else if (obj == ycv.jbtns[1]) {
			ycv.jtf_result.setText(ycv.jtf_result.getText() + "2");
		}
		else if (obj == ycv.jbtns[2]) {
			v1 = ycv.jtf_result.getText();
			System.out.println("v1 : " + v1);
			op = "+";
			ycv.jtf_result.setText("");
		}
		else if (obj == ycv.jbtns[3]) {
			v2 = ycv.jtf_result.getText();
			System.out.println("v1 = " + v1 + "-> v2 = " + v2 + " op : " + op);
			String result = YourCalcLogic.calc(v1, v2, op);
			ycv.jtf_result.setText(result);
		}
		else if (obj == ycv.jbtns[4]) {
			ycv.jtf_result.setText("");
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
}
