package book.ch4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RamdomGameView extends JFrame implements ActionListener{
	
	public RamdomGameView() {
		System.out.println("default constructor called");
		initDisplay();
	}

	//속지(중앙)을 생성하는 클래스 인스턴스화
	JPanel jp_center = new JPanel();
	//버튼 4개를 붙일 속지(동쪽)를 생성하는 클래스 인스턴스화
	JPanel jp_east = new JPanel();
	JButton jbtn_new = new JButton("새게임");
	
	JButton jbtn_dap = new JButton("정답");
	JButton jbtn_clear = new JButton("지우기");
	JButton jbtn_exit = new JButton("나가기");
	JTextArea jta_display = new JTextArea(5,30);
	JTextField jtf_input = new JTextField();
	
	public void initDisplay() {
		jp_east.setLayout(new GridLayout(4,1));
		jp_east.add(jbtn_new);
		jp_east.add(jbtn_dap);
		jp_east.add(jbtn_clear);
		jp_east.add(jbtn_exit);
		jp_center.setLayout(new BorderLayout());
		jp_center.add("Center", jta_display);
		jp_center.add("South", jtf_input);
		this.add("Center",jp_center);
		this.add("East",jp_east);
		this.setTitle("난수 게임. Ver1.0");
		this.setSize(400, 300);
		this.setVisible(true);
		jbtn_new.addActionListener(this);
		jbtn_dap.addActionListener(this);
		jbtn_clear.addActionListener(this);
		jbtn_exit.addActionListener(this);
	}
	
	public static void main(String[] args) {
		RamdomGameView rgview = new RamdomGameView();
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (jbtn_new == e.getSource()) {
			this.repaint();
			Game g = new Game();
			Random r = new Random();
			int randNum = r.nextInt(10);
			System.out.println("생성된 숫자 " + randNum);
			g.isThisGame(randNum);
		}
		else if (jbtn_dap == e.getSource()) {
			
		}
		else if (jbtn_clear == e.getSource()) {
			this.repaint();
		}
		else {
			
		}
	}

}