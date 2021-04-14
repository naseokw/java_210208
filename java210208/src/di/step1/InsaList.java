package di.step1;

import java.util.List;

public class InsaList extends Object {

	private List<String> insaBean = null;

	public void setInsaBean(List<String> insaBean) {
		this.insaBean = insaBean;
	}

	public void printList() {
		System.out.println(insaBean);

		if (insaBean != null) {
			for (String l : insaBean)
				System.out.println(l);
		}
	}

	public List<String> getInsaBean() {
		return insaBean;
	}
}
