package athread.talk2;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

public class GeunduClientVer2 extends JFrame implements ActionListener {
	//////////////// 통신과 관련한 전역변수 추가 시작//////////////
	Socket				socket			= null;
	ObjectOutputStream	oos				= null;																	// 말 하고
																												// 싶을 때
	ObjectInputStream	ois				= null;																	// 듣기 할
																												// 때
	String				nickName		= null;																	// 닉네임
																												// 등록
	//////////////// 통신과 관련한 전역변수 추가 끝 //////////////
	JPanel				jp_second		= new JPanel();
	JPanel				jp_second_south	= new JPanel();
	JButton				jbtn_one		= new JButton("1:1");
	JButton				jbtn_change		= new JButton("대화명변경");
	JButton				jbtn_font		= new JButton("글자색");
	JButton				jbtn_exit		= new JButton("나가기");
	JButton				jbtn_emoticon	= new JButton("이모티콘");
	JButton				jbtn_fontSize	= new JButton("글자크기");
	String				cols[]			= { "대화명" };
	String				data[][]		= new String[0][1];
	DefaultTableModel	dtm				= new DefaultTableModel(data, cols);
	JTable				jtb				= new JTable(dtm);
	JScrollPane			jsp				= new JScrollPane(jtb);
	JPanel				jp_first		= new JPanel();
	JPanel				jp_first_south	= new JPanel();
	JTextField			jtf_msg			= new JTextField(20);													// south속지
																												// center
	JButton				jbtn_send		= new JButton("전송");													// south속지
																												// east
	// JTextArea는 문자열을 그리는 개념이 아니라 출력하는 개념이라 부분색상변경, 문자열 그리기 등이 불가능하다
	StyledDocument		sd_display		= new DefaultStyledDocument(new StyleContext());
	JTextPane			jtp_display		= new JTextPane(sd_display);
	JScrollPane			jsp_display		= new JScrollPane(jtp_display, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
								JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	// 배경 이미지에 사용될 객체 선언-JTextArea에 페인팅
	Image				back			= null;

	public GeunduClientVer2() {
		jtf_msg.addActionListener(this);
		jbtn_exit.addActionListener(this);
		jbtn_change.addActionListener(this);
		jbtn_emoticon.addActionListener(this);
		jbtn_font.addActionListener(this);
		jbtn_fontSize.addActionListener(this);
	}

	public void initDisplay() {
		// 사용자의 닉네임 받기
		nickName = JOptionPane.showInputDialog("닉네임을 입력하세요.");
		this.setLayout(new GridLayout(1, 2));
		jp_second.setLayout(new BorderLayout());
		jp_second.add("Center", jsp);
		jp_second_south.setLayout(new GridLayout(3, 2));
		jp_second_south.add(jbtn_one);
		jp_second_south.add(jbtn_change);
		jp_second_south.add(jbtn_font);
		jp_second_south.add(jbtn_fontSize);
		jp_second_south.add(jbtn_emoticon);
		jp_second_south.add(jbtn_exit);
		jp_second.add("South", jp_second_south);
		jp_first.setLayout(new BorderLayout());
		jp_first_south.setLayout(new BorderLayout());
		jp_first_south.add("Center", jtf_msg);
		jp_first_south.add("East", jbtn_send);
		back = getToolkit().getImage("src\\athread\\talk2\\back.gif");

		Font font = new Font("맑은 고딕", Font.PLAIN, 20);
		jtp_display.setFont(font);
		jp_first.add("Center", jsp_display);
		jp_first.add("South", jp_first_south);
		this.add(jp_first);
		this.add(jp_second);
		this.setTitle(nickName);
		this.setSize(800, 550);
		this.setVisible(true);
	}

	public static void main(String args[]) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		GeunduClientVer2 gc = new GeunduClientVer2();
		gc.initDisplay();
		gc.init();
	}

	// 소켓 관련 초기화
	public void init() {

		try {
			// 서버측의 ip주소 작성하기
			socket = new Socket("121.139.85.156", 9234);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			// initDisplay에서 닉네임이 결정된 후 init메소드가 호출되므로
			// 서버에게 내가 입장한 사실을 알린다.(말하기)
			oos.writeObject(Protocol.ROOM_IN + Protocol.seperator + nickName);
			// 서버에 말을 한 후 들을 준비를 한다.
			GeunduClientThread tct = new GeunduClientThread(this);
			tct.start();
		}
		catch (Exception e) {
			// 예외가 발생했을 때 직접적인 원인되는 클래스명 출력하기
			System.out.println(e.toString());
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object	obj	= ae.getSource();
		String	msg	= jtf_msg.getText();

		if (jbtn_one == obj) {

		}
		else if (jtf_msg == obj) {

			try {
				oos.writeObject(Protocol.MESSAGE + Protocol.seperator + nickName + Protocol.seperator + msg);
				jtf_msg.setText("");
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if (jbtn_exit == obj) {

			try {
				oos.writeObject(Protocol.ROOM_OUT + Protocol.seperator + this.nickName + "종료");
				// 자바가상머신과 연결고리 끊기
				System.exit(0);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if (jbtn_change == obj) {
			String afterName = JOptionPane.showInputDialog("변경할 대화명을 입력하세요.");

			// 앞에서 먼저 널체크를 하기 때문에 널포인터를 피해갈 수 있다
			if (afterName == null || afterName.trim().length() < 1) {
				JOptionPane.showMessageDialog(this, "변경할 대화명을 입력하세요", "INFO", JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			try {
				oos.writeObject(Protocol.CHANGE + Protocol.seperator + nickName + Protocol.seperator + afterName
											+ Protocol.seperator + nickName + "의 대화명이 "
											+ afterName
											+ "으로 변경되었습니다.");
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}////////////////////// end of actionPerformed
}
