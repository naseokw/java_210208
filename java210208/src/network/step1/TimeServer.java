package network.step1;

import java.io.IOException;

/*
 * 소켓 - 무전기에 장착된 하드웨어라고 생각해도 됨
 * 네트쿼으케어 정보가 들어가고 나가는 지점에 대한 유일한 식별자
 * 32비트의 숫자로 구성되며 짝수번 소켓은 정보를 받아들이는 용도로
 * 홀수번 소켓은 정보를 보내는 용도로 사용됨
 * 
 * 네트워크망이 구성되어 있어야 한다.
 * 
 * fifo 속성 가지고 있음 (ex queue.) stack(백팩이당.. FILO)
 * 동시에 두 가지를 할 수는 없다.(R/W 동시 불가)
 * 
 * tcp 포트번호 물리적인 장치를 꽂는 장소는 아니다. 용도에 따라 쓰는 숫자 값
 * 서버에서 돌아가는 특정 프로그램을 나타내는 16비트 숫자
 * 웹서버 80
 * 텔넷 23
 * ftp 20
 * smtp 25
 * 
 * 같은 포트에서 여러 프로그램이 돌아갈 수 있는가?
 * 바인드 익셉션 발생
 * 
 * netstat -ano | findstr 포트번호 검색
 * taskkill -pid [프로세스 아이디] -f
 * 
 */
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

public class TimeServer extends Thread {

	Socket c_socket = null;

	public TimeServer() {
	}

	public TimeServer(Socket c_socket) {
		this.c_socket = c_socket;
	}

	@Override
	public void run() {

		try {
			PrintWriter	sendWriter	= new PrintWriter(c_socket.getOutputStream(), true);
			boolean		isFlag_run	= false;

			while (!isFlag_run) {

				sendWriter.println(getTimer());
//				sendWriter.flush();
				sleep(1000);// ms 단위 설정함 지연시키기 스레드 경합 스레드 순서 스레드...
			}
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getTimer() {
		Calendar	cal		= Calendar.getInstance();
		int			hour	= cal.get(Calendar.HOUR_OF_DAY);
		int			min		= cal.get(Calendar.MINUTE);
		int			sec		= cal.get(Calendar.SECOND);

		return hour + ":" + min + ":" + sec;
	}

	// 메인메서드도 스레드이다 디폴트 스레드. 엔트리 포인트
	public static void main(String[] args) {

		try {
			ServerSocket	s_socket	= new ServerSocket(9234);
			// taskkill -pid [pid] -f
			Socket			c_socket	= null;
			boolean			isFlag		= false;

			while (!isFlag) {
				c_socket = s_socket.accept();
				// accept에서 대기타기 때문에 로그 UI같은 걸 띄우고 싶으면 이 전에 해야 함
				// 화면 - input - operation - output 소통의 시작점
				System.out.println(c_socket.toString());

				TimeServer ts = new TimeServer(c_socket);

				ts.run();
			}
			s_socket.close();

		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}
}
