package book.ch7;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ObjectArray {

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.setLayout(new GridLayout(1, 10));
		JButton[] jbtns = new JButton[10];
		String[] jbtn_label = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		JButton jbtn = null;
		
		for (int i = 0; i < jbtns.length; i++) {	//버튼 생성 자체는 객체배열이 없어도 된다
			jbtn = new JButton(jbtn_label[i]);
			jbtns[i] = jbtn;						//해당 부분이 없어도 버튼 생성에는 문제가 없음
			jf.add(jbtn);
		}
		jf.setSize(700, 200);
		jf.setTitle("Object Array 실습");
		jf.setVisible(true);
	}
}
