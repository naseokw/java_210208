package athread.talk1;

import java.awt.Color;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
/*
 * 클라이언트에서 접속 시도가 있을 때 서버에서
 * 클라이언트의 로그 정보를 보고 싶다.
 * 따라서 화면에 전광판을 하나 추가하여
 * 텍스트로 로그 정보를 확인할 수 있도록 하기 위해서
 * JFrame을 상속받았다.
 * main() 메서드가 있는 클래스는 디폴트 스레드를 가진다.
 * 이 스레드에서 소켓서버 정보를 관리하는 중 경합이 일어날 수 있고
 * 그에 따라 충돌이나 이상이 발생할 수 있으므로
 * 별도의 스레드를 구현하고 그 스레드의 run() 메소드 안에서
 * 안전하게 소켓들을 생성하고 관리할 수 있도록 한다.
 */
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TalkServer extends JFrame implements Runnable {

	ServerSocket server = null;
	Socket client = null;
	TalkServerThread tst = null;
	Vector<TalkServerThread> globalList = null;
	JTextArea jta_log = new JTextArea();
	JScrollPane jsp_log = new JScrollPane(jta_log);

	public void initDisplay() {
		System.out.println("initDisplay() called successfully.");
		jta_log.setBackground(Color.ORANGE);
		this.add("Center", jsp_log);
		this.setSize(500, 500);
		this.setVisible(true);
	}

	@Override
	public void run() {
		System.out.println("TalkServer run() called successfully.");
		globalList = new Vector<TalkServerThread>();

		boolean isFlag = false;

		try {
			server = new ServerSocket(9234);
			jta_log.append("Server Ready...\n");

			while (!isFlag) {
				client = server.accept();
				jta_log.append("Client info : " + client + "\n");
				tst = new TalkServerThread(this);
				tst.start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TalkServer ts = new TalkServer();
		ts.initDisplay();
		Thread th = new Thread(ts);
		th.start();// run() 메서드가 호출된다.
	}
}
