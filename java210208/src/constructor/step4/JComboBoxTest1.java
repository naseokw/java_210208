package constructor.step4;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JComboBoxTest1 extends JFrame implements ItemListener {
	/*
	 * 생성자 매개변수 활용 연습 인스턴스화 이전에 반드시 생성자 확인할 것. API(Application Programming
	 * Interface) new JFrame(); new JFrame("title"); new JComboBox(); new
	 * JComboBox(String[]); new JComboBox(String); => 불가능
	 */
	JPanel jp_north = null;
	JComboBox<String> jcb_first = null;
	JComboBox<String> jcb_second = null;
	JComboBox<String> jcb_third = null;

	String[] total = { "전체" };
	String[] firstItem = { "전체", "가전", "컴퓨터", "모바일" };
	String[] secondItem0 = { "전체", "주방가전", "생활가전", "계절가전" };
	String[] secondItem1 = { "전체", "노트북", "브랜드PC", "모니터" };
	String[] secondItem2 = { "전체", "태블릿", "휴대폰", "스마트워치" };
	String[] thirdItem0 = { "전체", "냉장고", "전기밥솥", "에어프라이어" };
	String[] thirdItem1 = { "전체", "세탁기", "옷건조기", "청소기" };
	String[] thirdItem2 = { "전체", "온수매트", "선풍기", "에어컨" };
	String first, second, third;

	JComboBoxTest1() {
//		super("콤보박스 실습");

		jp_north = new JPanel();
		jcb_first = new JComboBox<>(firstItem);
		jcb_second = new JComboBox<>(total);
		jcb_third = new JComboBox<>(total);
		initDisplay();
	}

	public void initDisplay() {
		jp_north.setBackground(Color.ORANGE);
		Font font = new Font("맑은 고딕", Font.PLAIN, 15);

		jcb_first.setFont(font);
		jcb_first.addItemListener(this);
		jcb_second.setFont(font);
		jcb_second.addItemListener(this);
		jcb_third.setFont(font);
		jcb_third.addItemListener(this);

		jp_north.add(jcb_first);
		jp_north.add(jcb_second);
		jp_north.add(jcb_third);
		this.add("North", jp_north);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("생성자 & 콤보박스 실습");
		this.setSize(500, 500);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new JComboBoxTest1();
	}

	/**
	 * ItemListener라는 인터페이스에 정의된 추상메서드. 어떤 컴포넌트에 사용될지 알 수 없으므로 구현 불가능. 따라서 구현체 클래스에서
	 * 오버라이드하여 사용한다. 인터페이스는 보통 공통메서드를 정의하여 재사용성과 다형성을 지원함. 결합도를 낮추어 단위테스트 통합테스트 가능하게
	 * 하고 그러면서도 재사용성은 높임.
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj = e.getSource();
		if (obj == jcb_first) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				// 0:가전, 1:컴퓨터, 2:모바일
				first = firstItem[jcb_first.getSelectedIndex()];
				jcb_second.removeAllItems();
//				if (first.equals("가전")) -> NullPointerException이 발생할 수도 있어서 지양해야 함
				if ("가전".equals(first)) {
					for (String i : secondItem0) {
						jcb_second.addItem(i);
					}
				} else if ("컴퓨터".equals(first)) {
					for (String i : secondItem1) {
						jcb_second.addItem(i);
					}
				} else if ("모바일".equals(first)) {
					for (String i : secondItem2) {
						jcb_second.addItem(i);
					}
				} else {
					jcb_second.addItem(total[0]);
				}
			}
		}
		if (obj == jcb_second) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				second = secondItem0[jcb_second.getSelectedIndex()];
				jcb_third.removeAllItems();
				if ("주방가전".equals(second)) {
					for (String index : thirdItem0) {
						jcb_third.addItem(index);
					}
				} else if ("생활가전".equals(second)) {
					for (String index : thirdItem1) {
						jcb_third.addItem(index);
					}
				} else if ("계절가전".equals(second)) {
					for (String index : thirdItem2) {
						jcb_third.addItem(index);
					}
				} else {
					jcb_third.addItem(total[0]);
				}
			}
		}
	}
}
