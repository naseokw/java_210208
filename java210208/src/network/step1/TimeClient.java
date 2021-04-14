package network.step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JLabel;

public class TimeClient extends Thread{

	JLabel jlb_time = null;

	public TimeClient() {

	}

	public TimeClient(JLabel jlb_time) {
		this.jlb_time = jlb_time;
	}

	String receiveStr = "";

	@Override
	public void run() {
		Socket cli_socket = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
			cli_socket = new Socket("121.139.85.156", 9234);
			pw = new PrintWriter(cli_socket.getOutputStream(), true);
			br = new BufferedReader(new InputStreamReader(cli_socket.getInputStream()));

			while(true) {
				while(receiveStr != null) {
					receiveStr = br.readLine();
					System.out.println(receiveStr);
					jlb_time.setText(receiveStr);
					try {
						sleep(1000);
					} catch(Exception e) {
						e.printStackTrace();
					}
				}

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	public static void main(String[] args) {
//		JLabel jlb_time = null;
//		TimeClient tc = new TimeClient(jlb_time);
//		tc.start();
//	}
}
