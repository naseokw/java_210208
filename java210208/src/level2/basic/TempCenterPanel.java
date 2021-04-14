package level2.basic;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TempCenterPanel extends JPanel {

	JButton	jbtn_one	= new JButton("회원가입");
	JButton	jbtn_two	= new JButton("로그인");

	public void initDisplay() {
//		JPanel jp = new TempCenterPanel();
		this.setBackground(Color.GREEN);
		this.add(jbtn_one);
		this.add(jbtn_two);
		
	}
}
