package athread.talk1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TalkClient extends JFrame implements ActionListener {

	Socket socket = null;

	// 직렬화를 누릴 수 있다.
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;

	String nickname = null;

	JPanel jp_south = null;
	JTextField jtf_msg = null;
	JTextArea jta_display = null;
	JScrollPane jsp_display = null;
	JButton jbtn_send = null;
	JPanel jp_first = null;
	JPanel jp_second = null;
	JPanel jp_second_south = null;
	String[] cols = { "대화명" };
	String[][] data = new String[0][1];
	DefaultTableModel dtm_nickname = new DefaultTableModel(data, cols);
	JTable jtb_nickname = new JTable(dtm_nickname);
	JScrollPane jsp_nickname = new JScrollPane(jtb_nickname);
	JButton jbtn_privateChat = new JButton("1:1대화");
	JButton jbtn_changeNickname = new JButton("대화명 변경");
	JButton jbtn_Emoticon = new JButton("이모티콘");
	JButton jbtn_exit = new JButton("나가기");

	// 소켓 관련 초기화
	public void init() {
		try {
			socket = new Socket("localhost", 9234);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeObject(100 + "#" + nickname);
			TalkClientThread tct = new TalkClientThread(this);
			tct.start();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
		}
	}

	public void initDisplay() {
		jp_south = new JPanel(new BorderLayout());
		jp_first = new JPanel(new BorderLayout());
		jp_second = new JPanel(new BorderLayout());
		jp_second_south = new JPanel(new GridLayout(2, 2));
		jta_display = new JTextArea();
		jta_display.setEditable(false);
		jsp_display = new JScrollPane(jta_display);
		jtf_msg = new JTextField(20);
		jtf_msg.addActionListener(this);
		jbtn_privateChat.addActionListener(this);
		jbtn_changeNickname.addActionListener(this);
		jbtn_Emoticon.addActionListener(this);
		jbtn_exit.addActionListener(this);
		jbtn_send = new JButton("SEND");
		nickname = JOptionPane.showInputDialog("닉네임을 입력하세요.");

		jp_south.add("Center", jtf_msg);
		jp_south.add("East", jbtn_send);
		jp_first.add("Center", jsp_display);
		jp_first.add("South", jp_south);
		jp_second_south.add(jbtn_privateChat);
		jp_second_south.add(jbtn_changeNickname);
		jp_second_south.add(jbtn_Emoticon);
		jp_second_south.add(jbtn_exit);
		jp_second.add("Center", jsp_nickname);
		jp_second.add("South", jp_second_south);
		this.setLayout(new GridLayout(1, 2));
		this.add(jp_first);
		this.add(jp_second);
		this.setTitle(nickname + "님의 창");
		this.setSize(500, 400);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		TalkClient tc = new TalkClient();
		tc.initDisplay();
		tc.init();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String msg = jtf_msg.getText();
		if (jtf_msg == obj) {
			try {
				oos.writeObject(200 + "#" + nickname + "#" + msg);
				jtf_msg.setText("");

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		else if (jbtn_privateChat == obj) {
			System.out.println("1:1대화 버튼 눌림");
		}

		else if (jbtn_changeNickname == obj) {
			System.out.println("대화명 변경 버튼 눌림");
		}

		else if (jbtn_Emoticon == obj) {
			System.out.println("이모티콘 버튼 눌림");
		}

		else {
			System.exit(0);
		}
	}
}
