package athread.talk2;

import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.text.BadLocationException;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;

public class GeunduClientThread extends Thread {
	GeunduClient		gc	= null;
	GeunduClientVer2	gc2	= null;

	public GeunduClientThread(GeunduClient gc) {
		this.gc = gc;
	}

	public GeunduClientThread(GeunduClientVer2 gc2) {
		this.gc2 = gc2;
	}

	/*
	 * 서버에서 말한 내용을 들어봅시다.
	 */
	public void run() {
		boolean isStop = false;

		while (!isStop) {

			try {
				String msg = "";// 100#apple
				msg = (String) gc2.ois.readObject();
				StringTokenizer	st			= null;
				int				protocol	= 0;	// 100|200|201|202|500

				if (msg != null) {
					st = new StringTokenizer(msg, "#");
					protocol = Integer.parseInt(st.nextToken());// 100
				}

				switch (protocol) {
				case Protocol.ROOM_IN: {// 100#apple
					String				nickName	= st.nextToken();

					// gc.jta_display.append(nickName + "님이 입장하였습니다.\n");
					MutableAttributeSet	attr		= new SimpleAttributeSet();

					try {
						gc2.sd_display.insertString(gc2.sd_display.getLength(), nickName + "님이 입장하였습니다.\n", attr);
					}
					catch (BadLocationException e) {
						e.printStackTrace();
					}
					Vector<String> v = new Vector<>();
					v.add(nickName);
					gc2.dtm.addRow(v);
				}
					break;
//				case 200: {
//
//				}
//					break;
				case Protocol.MESSAGE: {
					String				nickName	= st.nextToken();
					String				message		= st.nextToken();
					MutableAttributeSet	attr		= new SimpleAttributeSet();

					try {
						gc2.sd_display.insertString(gc2.sd_display.getLength(),
													nickName + "[" + nickName + "]" + message + "\n", attr);
					}
					catch (BadLocationException e) {
						e.printStackTrace();
					}
					// 새로운 메시지가 들어올 때 자동으로 포커스 이동 처리
					gc2.jtp_display.setCaretPosition(gc2.sd_display.getLength());
				}
					break;
				case Protocol.CHANGE: {
					String	nickName	= st.nextToken();
					String	afterName	= st.nextToken();
					String	message		= st.nextToken();

					// 테이블에 대화명 변경하기
					for (int i = 0; i < gc2.dtm.getRowCount(); i++) {
						String imsi = (String) gc2.dtm.getValueAt(i, 0);

						if (nickName.equals(imsi)) {
							gc2.dtm.setValueAt(afterName, i, 0);
							break;
						}
					}
					MutableAttributeSet attr = new SimpleAttributeSet();

					try {
						gc2.sd_display.insertString(gc2.sd_display.getLength(), message + "\n", attr);
					}
					catch (BadLocationException e) {
						e.printStackTrace();
					}
					gc2.jtp_display.setCaretPosition(gc2.sd_display.getLength());

					// 채팅창에 타이틀바에도 대화명을 변경처리 한다.
					if (nickName.equals(gc2.nickName)) {
						gc2.setTitle(afterName + "님의 대화창");
						gc2.nickName = afterName;
					}
				}
					break;
				case Protocol.ROOM_OUT: {
					String				nickName	= st.nextToken();
					MutableAttributeSet	attr		= new SimpleAttributeSet();

					try {
						gc2.sd_display.insertString(gc2.sd_display.getLength(), nickName + "님이 퇴장하였습니다.\n", attr);
					}
					catch (BadLocationException e) {
						e.printStackTrace();
					}
					gc2.jtp_display.setCaretPosition(gc2.sd_display.getLength());

					for (int i = 0; i < gc2.dtm.getRowCount(); i++) {
						String n = (String) gc2.dtm.getValueAt(i, 0);

						if (n.equals(nickName)) {
							gc2.dtm.removeRow(i);
						}
					}
				}
					break;
				}//////////// end of switch
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		} //////////////////// end of while
	}//////////////////////// end of run
}