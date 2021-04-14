package com.pattern;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class RandomGameView extends JFrame implements ActionListener{
	//선언부
	//동쪽 패널 선언
	JPanel jp_east = new JPanel();
	JButton jbtn_new = new JButton("새 게임");
	JButton jbtn_clear = new JButton("삭제");
	JButton jbtn_answer = new JButton("정답");
	JButton jbtn_exit = new JButton("종료");
	JTextArea jta_display = new JTextArea(7, 20);
	JScrollPane jsp_display = new JScrollPane(jta_display
											, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
											, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	//남쪽 패널 - 여기 버튼 10개 할당
	JPanel jp_south = new JPanel();
	//버튼 객체배열 크기만 초기화
	JButton[] jbtns = new JButton[10];
	JButton jbtn = null;
	//문자열 10개 담는 배열 선언 및 초기화
	String[] nums_label = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
	//생성자
	
	//화면처리부
	public void initDisplay() {
//		JFrame jf = new JFrame();
		jp_south.setLayout(new GridLayout(1, 10, 3, 3));
		jp_east.setLayout(new GridLayout(4, 1, 2, 2));
		jp_east.add(jbtn_new);
		jp_east.add(jbtn_clear);
		jbtn_clear.addActionListener(this);
		jbtn_exit.addActionListener(this);
//		jbtns[5].addActionListener(this);
		jp_east.add(jbtn_answer);
		jp_east.add(jbtn_exit);
		
		for (int i = 0; i < nums_label.length; i++) {
			
			jbtn = new JButton(nums_label[i]);
			jp_south.add(jbtn);
			jbtns[i] = jbtn;
		}
		jp_south.setBackground(Color.yellow);
		jp_east.setBackground(Color.red);
		this.setLayout(new BorderLayout());
		this.add("East", jp_east);
		this.add("Center", jsp_display);
		this.add("South", jp_south);
		this.setTitle("숫자 맞히기 Ver 1.0");
		this.setSize(500, 500);
		this.setVisible(true);
	}
	
	//메인
	public static void main(String[] args) {
		RandomGameView rgView = new RandomGameView();
		rgView.initDisplay();
	}

	@Override
	public void actionPerformed(ActionEvent e) { //콜백메서드 main도 같음 유저가 따로 콜을 하지 않아도 시스템에서 알아서 콜하는구조
		String command = e.getActionCommand();
		System.out.println(command);
		if (e.getSource() == jbtn_exit) {
			System.exit(0);
		}
		else if ("5".equals(command)){
			jta_display.append(command);
		}
	}
}
