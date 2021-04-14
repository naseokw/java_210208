package book.ch12;

import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.util.MyBatisCommonFactory;

public class MapTest1_2 {

	SqlSessionFactory factory = null;

	public List<Map<String, Object>> getRecordTest(List<Map<String, Object>> test) {
		factory = MyBatisCommonFactory.getInstance();
		SqlSession sqlSession = factory.openSession();
		test = sqlSession.selectList("testMapper.testQuery");
		return test;

	}

	public static void main(String[] args) {
		MapTest1_2					mt1_2	= new MapTest1_2();
		List<Map<String, Object>>	test	= null;
		test = mt1_2.getRecordTest(test);

//		System.out.println(test);

		for (Map<String, Object> index : test) {
			System.out.println(index);
		}
	}
}
