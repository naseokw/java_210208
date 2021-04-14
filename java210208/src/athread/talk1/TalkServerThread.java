package athread.talk1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

public class TalkServerThread extends Thread {

	TalkServer ts = null;
	Socket client = null;

	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;

	String nickname = null;
	/*
	 * 클라이언트에서 서버소켓에 접속하고 나면 생성자를 통해서 TalkServer의 주소를 받게 되고 이것으로 소켓에 접근할 수 있다. 해당
	 * 소켓으로 ois와 oos를 생성하고 접속해온 사용자의 정보 청취 청취한 내용을 TalkServer의 jta_log에 출력해본다.
	 */

	public TalkServerThread(TalkServer ts) {
		this.ts = ts;
		this.client = ts.client;
		try {
			oos = new ObjectOutputStream(client.getOutputStream());// 홀수자리 소켓 - Write
			ois = new ObjectInputStream(client.getInputStream());// 짝수자리 소켓 - Read
			String msg = (String) ois.readObject();
			ts.jta_log.append(msg + "\n");
			StringTokenizer st = new StringTokenizer(msg, "#");
			st.nextToken();// 100
			nickname = st.nextToken();
			ts.jta_log.append(nickname + "님이 입장하였습니다.\n");
			//////////////////////// 오늘의 어려운 부분 시작//////////////////////////

			for (TalkServerThread tst : ts.globalList) {
				this.broadCasting(100 + "#" + tst.nickname);
			}
			ts.globalList.add(this);
			this.broadCasting(msg);
			//////////////////////// 오늘의 어려운 부분 끝//////////////////////////

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}

	public void broadCasting(String msg) {
		for (TalkServerThread tst : ts.globalList) {
			try {
				oos.writeObject(msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}




	@Override
	public void run() {
		System.out.println("TalkServerThread run() called successfully.");

		boolean isFlag = false;
		try {
			run_start: while (!isFlag) {
				try {
					String msg = "";
					msg = (String) ois.readObject();
					ts.jta_log.append(msg + "\n");
					StringTokenizer st = null;
					int protocol = 0;
					if (msg != null) {
						st = new StringTokenizer(msg, "#");
						protocol = Integer.parseInt(st.nextToken());
					}
					switch (protocol) {
					case 200: {
						String nickname = st.nextToken();
						String msg2 = st.nextToken();
						broadCasting(200 + "#" + nickname + "#" + msg2);
					}

					}

				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
