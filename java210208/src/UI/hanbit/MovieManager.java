package UI.hanbit;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MovieManager extends JFrame {
	MovieWest mw = new MovieWest();
	JPanel jp_west = new JPanel();
	JPanel jp_center = new JPanel();
	
	public void initDisplay() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jp_west.setBackground(Color.green);
		jp_center.setBackground(Color.blue);
//		this.add("West", jp_west");
		mw.setVisible(true);
		this.add("West", mw);
		this.setSize(900,700);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		MovieWest mm = new MovieWest();
		mm.initDisplay();
	}

}
