package com.design.zipcode;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.util.MyBatisCommonFactory;

public class MyBatisZipCodeDAO {

	SqlSessionFactory sqlSessionFactory = null;

	public MyBatisZipCodeDAO() {
		sqlSessionFactory = MyBatisCommonFactory.getInstance();
	}

	public List<ZipCodeVO> getZipCodeList(ZipCodeVO zcVO) {
		System.out.println("getZipCodeList called successfully. " + zcVO);
		List<ZipCodeVO>	zipcodeList	= new ArrayList<ZipCodeVO>();
		SqlSession		sqlSession	= null;

		try {
			sqlSession = sqlSessionFactory.openSession();
			zipcodeList = sqlSession.selectList("mybatis.mapper.ZipcodeMapper.refreshData", zcVO);

			sqlSession.close();

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return zipcodeList;
	}

	public static void main(String[] args) {
		MyBatisZipCodeDAO	mbzcd		= new MyBatisZipCodeDAO();
		List<ZipCodeVO>		zipcodeList	= new ArrayList<ZipCodeVO>();
		ZipCodeVO			pzcVO		= new ZipCodeVO();
		pzcVO.setDong("부림동");
		zipcodeList = mbzcd.getZipCodeList(pzcVO);

		for (ZipCodeVO index : zipcodeList) {
			System.out.println(index.getZipcode() + " " + index.getAddress());
		}
	}
}
