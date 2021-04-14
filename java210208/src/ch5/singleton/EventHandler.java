package ch5.singleton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventHandler implements ActionListener {
	
	ViewApp viewApp = null;
	public EventHandler(ViewApp viewApp) {
		this.viewApp = viewApp;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == viewApp.jbtn_close) {
			System.exit(0);
		}
//		String command = e.getActionCommand();
//		if ("Close".equals(command)) {
//			System.exit(0);
//		}
	}
}
