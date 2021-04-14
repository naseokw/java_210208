package book.ch12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest1_1 {
	private List<String>		arrList	= null;
	private Map<String, Object>	map		= null;
	private Object[]			keys	= null;

	public MapTest1_1() {
		arrList = new ArrayList<String>();
		map = new HashMap<String, Object>();
	}

	public static void main(String[] args) {
		MapTest1_1	testInstance	= new MapTest1_1();
		boolean		isExistKey		= false;

		testInstance.arrList.add(0, "사과");
		testInstance.arrList.add("포도");
		testInstance.arrList.add("키위");

		for (String index : testInstance.arrList) {
			System.out.println(index);
		}

		System.out.println();

		testInstance.map.put("one", "사과");
		testInstance.map.put("two", "포도");
		testInstance.map.put("three", "키위");

		testInstance.keys = testInstance.map.keySet().toArray();
		isExistKey = testInstance.map.containsKey("four");
		System.out.println(isExistKey + "\n");

		for (Object index : testInstance.keys) {
			System.out.println(index);
		}
	}
}
