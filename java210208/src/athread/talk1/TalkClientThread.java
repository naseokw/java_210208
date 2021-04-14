package athread.talk1;

import java.util.StringTokenizer;

public class TalkClientThread extends Thread {

	TalkClient tc = null;
	TalkClientVer2 tc2 = null;

	// 들어야 하는데 TalkClient에 ObjectInputStream가 있어서 생성자를 통해 불러옴
	public TalkClientThread(TalkClient tc) {
		this.tc = tc;
	}
	
	public TalkClientThread(TalkClientVer2 tc2) {
		this.tc2 = tc2;
	}

	@Override
	public void run() {// 듣는 곳이다
		System.out.println("run() called successfully");
		boolean isFlag = false;

		while (!isFlag) {
			try {
				String msg = "";
				msg = (String) tc.ois.readObject();
				StringTokenizer st = null;
				int protocol = 0;
				if (msg != null) {
					st = new StringTokenizer(msg, "#");
					protocol = Integer.parseInt(st.nextToken());
				}
				switch (protocol) {
				case 100: {
					String nickname = st.nextToken();
					tc.jta_display.append(nickname + "님이 입장하였습니다.\n");
					break;
				}

				case 200: {
					String nickname = st.nextToken();
					String msg2 = st.nextToken();
					tc.jta_display.append("[" + nickname + "]" + msg2 + "\n");
				}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
