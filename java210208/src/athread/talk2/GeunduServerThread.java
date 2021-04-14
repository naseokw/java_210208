package athread.talk2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

public class GeunduServerThread extends Thread {
	public GeunduServer	gs			= null;
	Socket				client		= null;
	ObjectOutputStream	oos			= null;
	ObjectInputStream	ois			= null;
	String				chatName	= null;	// 현재 서버에 입장한 클라이언트 스레드 닉네임 저장

	public GeunduServerThread(GeunduServer gs) {
		this.gs = gs;
		this.client = gs.socket;

		try {
			oos = new ObjectOutputStream(client.getOutputStream()); // 홀수 소켓
			ois = new ObjectInputStream(client.getInputStream()); // 짝수 소켓
			// 130#유저1
			String msg = (String) ois.readObject();// 듣기
			gs.jta_log.append(msg + "\n");// 서버 텍스트에리어에 출력
			StringTokenizer st = new StringTokenizer(msg, Protocol.seperator);
			st.nextToken();// 130
			chatName = st.nextToken();
			gs.jta_log.append(chatName + "님이 입장하였습니다.\n");

			for (GeunduServerThread tst : gs.globalList) {
				// 이전에 입장해 있는 친구들 정보 받아내기
				// String currentName = tst.chatName;
				this.send(Protocol.ROOM_IN + Protocol.seperator + tst.chatName);
			}
			// 현재 서버에 입장한 클라이언트 스레드 추가하기
			gs.globalList.add(this);
			// add 되고 나서 입장한 사람에게만 브로드캐스팅
			this.broadCasting(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 현재 입장해 있는 친구들 모두에게 메시지 전송하기 구현
	public void broadCasting(String msg) {

		for (GeunduServerThread tst : gs.globalList) {
			// this.send(msg)를 하게 되면 본인 스레드에만 전송되기 때문에 좆망함
			tst.send(msg);
		}
	}

	// 클라이언트에게 말하기 구현
	public void send(String msg) {

		try {
			oos.writeObject(msg);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		String	msg		= null;
		boolean	isStop	= false;

		try {
			// while(true) {//무한루프에 빠질 수 있다.
			run_start: while (!isStop) {
				msg = (String) ois.readObject();
				gs.jta_log.append(msg + "\n");
				gs.jta_log.setCaretPosition(gs.jta_log.getDocument().getLength());
				StringTokenizer	st			= null;
				int				protocol	= 0;	// 100|200|201|202|500

				if (msg != null) {
					st = new StringTokenizer(msg, Protocol.seperator);
					protocol = Integer.parseInt(st.nextToken());// 100
				}

				switch (protocol) {

				case Protocol.MESSAGE: {
					String	nickName	= st.nextToken();
					String	message		= st.nextToken();
					broadCasting(Protocol.MESSAGE + Protocol.seperator + nickName + Protocol.seperator + message);
				}
					break;

				case Protocol.CHANGE: {
					String	nickName	= st.nextToken();
					String	afterName	= st.nextToken();
					String	message		= st.nextToken();
					// 서버측 닉네임과 동기화할 것
					this.chatName = afterName;
					broadCasting(Protocol.CHANGE + Protocol.seperator + nickName + Protocol.seperator + afterName
												+ Protocol.seperator + message);
				}
					break;

				case Protocol.ROOM_OUT: {
					String nickName = st.nextToken();
					gs.globalList.remove(this);
					broadCasting(Protocol.ROOM_OUT + Protocol.seperator + nickName);
				}
					break run_start;
				}///////////// end of switch
			} ///////////////// end of while
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}///////////////////////// end of run
}