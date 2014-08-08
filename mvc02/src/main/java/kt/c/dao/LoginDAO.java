package kt.c.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kt.c.util.ConnectionFactory;
import kt.c.util.JDBCClose;
import kt.c.vo.LoginVO;

public class LoginDAO {
	public LoginVO login(LoginVO loginVO) {
		
		LoginVO userVO = null;
		
		Connection con = new ConnectionFactory().getConnection();
		StringBuilder sql = new StringBuilder();
		
		sql.append("select id, password, type ");
		sql.append(" from t_member ");
		sql.append(" where id = ? and ");
		sql.append("       password = ? ");
		
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, loginVO.getId());
			pstmt.setString(2, loginVO.getPassword());
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				userVO = new LoginVO();
				userVO.setId(rs.getString("id"));
				userVO.setPassword(rs.getString("password"));
				userVO.setType(rs.getString("type"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(con, pstmt);
		}
		return userVO;
		
	}
}
