package book.ch4;

import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import oracle.net.aso.i;

public class Grade {

	public static void main(String[] args) {
		String s_grade = JOptionPane.showInputDialog("점수를 입력하시오 : ");
		int i_grade = Integer.parseInt(s_grade);
//		System.out.println(s_grade);
//		System.out.println(i_grade);
		
		String msg = 300 + "," + "아이디" + "," + "응애";
		StringTokenizer st = new StringTokenizer(msg, ",");
		int toint = Integer.parseInt(st.nextToken());
		
		switch (i_grade/10) {
		case 10: case 9:
			System.out.println('A');
			break;
		case 8:
			System.out.println('B');
			break;
		case 7:
			System.out.println('C');
			break;
		case 6:
			System.out.println('D');
		default:
			System.out.println('F');
		}
	}
}
