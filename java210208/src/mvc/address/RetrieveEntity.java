package mvc.address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.util.DBConnectionMgr;

public class RetrieveEntity {
	Connection			 	con 	= null;
	PreparedStatement 		pstmt 	= null;
	ResultSet 				rs 		= null;
//오버로딩에 리턴타입은 영향이 없다.
	/********************************************************************
	 * 상세조회 구현
	 * 
	 * @param vo - vo.getID();
	 * @return AddressVO ( or Map )
	 * 	 SELECT id, name, address, telephone, gender
	 *        , relationship, birthday, comments, registedate
	 *     FROM mkaddrtb
	 *    WHERE id=:x
	 ********************************************************************/
	public AddressVO select(AddressVO pavo) {//무조건 1개로우만 가능함
		System.out.println("RetrieveEntity's select(paVO) 호출 성공"); // paVO = parameter.address.VO
		return null;
	}

	public Map<String, Object> selectMap(AddressVO vo) {//무조건 1개로우만 가능함
		System.out.println("RetrieveEntity's select() 호출 성공");
		return null;
	}

	public AddressVO[] select() {//n개 로우 가능함
		System.out.println("RetrieveEntity's select() 호출 성공");
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id, name, address, telephone, gender         ");
	    sql.append(" 	 , relationship, birthday, comments, registedate");
	    sql.append("  FROM mkaddrtb                                     ");
	    DBConnectionMgr dbmgr = DBConnectionMgr.getInstance();
	    Vector<AddressVO> v = new Vector<>();
	    AddressVO[] aVOS = null;
	    try {
	    	con = dbmgr.getConnection();
//	    	pstmt = con.prepareStatement(sql.toString());
	    	pstmt = con.prepareStatement(String.valueOf(sql));
	    	rs = pstmt.executeQuery();
	    	AddressVO aVO = null;
//	    	int i = 1;
	    	while(rs.next()) {
	    		aVO = new AddressVO();
//	    		aVO.setId(rs.getInt(i++));
	    		aVO.setId(rs.getInt("id"));
	    		aVO.setName(rs.getString("name"));
	    		aVO.setAddress(rs.getString("telephone"));
	    		aVO.setTelephone(rs.getString("gender"));
	    		aVO.setGender(rs.getString("gender"));
	    		aVO.setRelationship(rs.getString("relationship"));
	    		aVO.setBirthday(rs.getString("birthday"));
	    		aVO.setComments(rs.getString("comments"));
	    		aVO.setRegistedate(rs.getString("registedate"));
	    		v.add(aVO);
	    	}
	    	aVOS = new AddressVO()[v.size()];
	    	v.copyInto(aVOS);
	    }catch (SQLException se) {
			// TODO: handle exception
		}finally {//사용한 자원 반납하기
			dbmgr.freeConnection(con, pstmt, rs);
		}
		return aVOS;
	}

	public List<AddressVO> selectList(AddressVO pVO) {
		List<AddressVO> addressList = null;

		AddressDAO aDAO = new AddressDAO();
		addressList = aDAO.selectList(pVO);

		System.out.println("RetrieveEntity's selectList(AddressVO) 호출 성공");
		return addressList;
	}
}
