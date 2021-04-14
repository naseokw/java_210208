package mybatis.step1;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BookDAO {
	// 이것을 통하여 xml 문서의 정보를 읽어 Connection
	String				resource	= "mybatis\\step1\\MapperConfig.xml";
	SqlSessionFactory	sqlMapper	= null;

	public List<Map<String, Object>> getBookList() {
		List<Map<String, Object>>	bookList	= null;
		SqlSession					session		= null;

		try {
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			// auto commit true
//			session = sqlMapper.openSession(true);
			// auto commit false
			session = sqlMapper.openSession();
			bookList = session.selectList("mybatis.mapper.BookMapper.currentTime");

			session.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return bookList;
	}

	public static void main(String[] args) {
		BookDAO						bDAO		= new BookDAO();
		List<Map<String, Object>>	bookList	= null;
		bookList = bDAO.getBookList();
		System.out.println(bookList);
	}
}
