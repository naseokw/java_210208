package panelRefresh.cons;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JPanel1 extends JPanel {
	String[] cols = { "대화명" };
	String[][] data = new String[0][1];
	// Eager Initialization은 변화에 대처하기 힘들다
	// 이런 상황에서는 오브젝트 생성으로 인한 생성자 호출에 주의
	DefaultTableModel dtm = new DefaultTableModel(data, cols);

	JTable jtb = new JTable(dtm);
	JScrollPane jsp = new JScrollPane(jtb, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	public JPanel1() {
		initDisplay();
	}

	private void initDisplay() {
		this.setLayout(new BorderLayout());
		this.add("Center", jsp);
		this.setSize(400, 300);
		this.setVisible(true);
	}
}
