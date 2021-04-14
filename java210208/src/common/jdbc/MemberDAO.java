package common.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.design.zipcode.MemberShip;
import com.util.DBConnectionMgr;

public class MemberDAO {
	Connection			con		= null;
	PreparedStatement	pstmt	= null;
	CallableStatement	cstmt	= null;
	ResultSet			rs		= null;
	DBConnectionMgr		dbMgr	= null;

	public String login(String p_id, String p_pw) {
		dbMgr = DBConnectionMgr.getInstance();
		String msg = "";

		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_login80(?, ?, ?)}");
			cstmt.setString(1, p_id);
			cstmt.setString(2, p_pw);
			cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			int result = cstmt.executeUpdate();

			if (result == 1) {
				msg = cstmt.getString(3);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			dbMgr.freeConnection(con, cstmt);
		}
		return msg;
	}

	public boolean join(MemberShip membership) {
		boolean isRefused = false;

		isRefused = joinCheck(membership);

		if (isRefused != true) {
			dbMgr = DBConnectionMgr.getInstance();
			String sql = "INSERT INTO membership_t(m_id, m_pw, m_nickname, m_name, m_sex, m_zipcode, m_address) VALUES (?, ?, ?, ?, ?, ?, ?)";

			try {
				con = dbMgr.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, membership.jtf_id.getText());
				pstmt.setString(2, membership.jtf_pw.getText());
				pstmt.setString(3, membership.jtf_nickName.getText());
				pstmt.setString(4, membership.jtf_name.getText());
				pstmt.setInt(5, membership.gender);
				pstmt.setString(6, membership.jtf_zipcode.getText());
				pstmt.setString(7, membership.jtf_address.getText());
				rs = pstmt.executeQuery();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				dbMgr.freeConnection(con, pstmt, rs);
			}
		}
		return isRefused;
	}

	// 나중에 부분검색으로 바꿀 수 있도록 처리해야 한다 지금은 SELECT 전체 다 해오기 때문에 비효율적
	public boolean joinCheck(MemberShip membership) {
		boolean isExist = false;
		dbMgr = DBConnectionMgr.getInstance();
		String sql = "SELECT m_id FROM membership_t WHERE m_id = ?";

		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, membership.jtf_id.getText());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				isExist = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			dbMgr.freeConnection(con, pstmt, rs);
		}
		return isExist;
	}
}
