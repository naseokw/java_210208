package mvc.address;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class AddressDAO {
	String				resource	= "mybatis\\step1\\MapperConfig.xml";
	SqlSessionFactory	sqlMapper	= null;

	public List<AddressVO> selectList(AddressVO pVO) {
		List<AddressVO>	bookList	= null;
		SqlSession		session		= null;

		try {
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			session = sqlMapper.openSession();
			bookList = session.selectList("mybatis.mapper.AddressMapper.selectList", pVO);

			session.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return bookList;
	}

//	public static void main(String[] args) {
//		AddressDAO					bDAO		= new AddressDAO();
//		List<Map<String, Object>>	bookList	= null;
//		bookList = bDAO.getBookList();
//		System.out.println(bookList);
//	}
}
