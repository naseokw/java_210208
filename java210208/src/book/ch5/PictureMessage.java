package book.ch5;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class PictureMessage extends JDialog {

	String		imagePath		= "src\\images\\";

	JPanel		jp_emoticon		= new JPanel();
	GridLayout	gl_emoticon		= new GridLayout(1, 5);
	JButton		pic0			= new JButton();
	JButton		pic1			= new JButton();
	JButton		pic2			= new JButton();
	JButton		pic3			= new JButton();
	JButton		pic4			= new JButton();
	String[]	imageFiles		= { "lion11.png", "lion22.png", "lion33.png", "lion44.png", "lion55.png" };
	JButton[]	imageButtons	= { pic0, pic1, pic2, pic3, pic4 };
	ImageIcon[]	imageIcons		= new ImageIcon[imageButtons.length];

	public PictureMessage() {
		initDisplay();
	}

	public void initDisplay() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);

		for (int i = 0; i < imageFiles.length; i++) {
			imageIcons[i] = new ImageIcon(imagePath + imageFiles[i]);
			imageButtons[i].setIcon(imageIcons[i]);
			imageButtons[i].setBorderPainted(false);
			imageButtons[i].setContentAreaFilled(false);
			jp_emoticon.add(imageButtons[i]);
		}
		jp_emoticon.setLayout(gl_emoticon);
		this.add("Center", jp_emoticon);
		this.setSize(585, 147);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new PictureMessage();
	}
}
