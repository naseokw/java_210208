package com.design.zipcode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import com.util.DBConnectionMgr;

public class ZipCodeDAO {

	DBConnectionMgr dbMgr = null;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public ZipCodeDAO() {
		dbMgr = DBConnectionMgr.getInstance();

		try {
			con = dbMgr.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * SELECT '전체' zdo FROM dual UNION ALL SELECT DISTINCT(zdo) FROM zipcode_t ORDER
	 * BY zdo ASC;
	 * 
	 * @return 전체 경기 강원 경북...
	 */
	public String[] getZdoList() {
		String[] zdos = null;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT '전체' zdo FROM dual UNION ALL SELECT DISTINCT(zdo) FROM zipcode_t ORDER BY zdo ASC");
		try {
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			Vector<String> vec = new Vector<String>();
			while (rs.next()) {
				String zdo = rs.getString("zdo");
				vec.add(zdo);
			}
			zdos = new String[vec.size()];
			vec.copyInto(zdos);

			dbMgr.freeConnection(con, pstmt, rs);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return zdos;
	}

	// 클래스 쪼개기에서 초급자가 항상 염두할 사항은 배달사고
	public ArrayList<ZipCodeVO> getZipCodeList(String dong) {
		System.out.println("getZipCodeList called successfully. " + dong);

		ArrayList<ZipCodeVO> zipcodeList = new ArrayList<ZipCodeVO>();

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT zipcode, address FROM zipcode_t WHERE dong LIKE ?||'%'");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dong);
			rs = pstmt.executeQuery();
			ZipCodeVO zcVO = null;
			while (rs.next()) {
				zcVO = new ZipCodeVO();
				zcVO.setZipcode(rs.getInt("zipcode"));
				zcVO.setAddress(rs.getString("address"));
				zipcodeList.add(zcVO);
			}

			dbMgr.freeConnection(con, pstmt, rs);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return zipcodeList;
	}

//	public static void main(String[] args) {
//		ZipCodeDAO zcdao = new ZipCodeDAO();
//		ArrayList<ZipCodeVO> al = new ArrayList<ZipCodeVO>();
//		
//		al = zcdao.getZipCodeList("가산동"); 
//		
//		for (ZipCodeVO z : al) {
//			System.out.println(z.getAddress() + " " + z.getZipcode());
//		}
//		
//	}

}
