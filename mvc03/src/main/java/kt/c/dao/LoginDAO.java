package kt.c.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import kt.c.vo.LoginVO;

public class LoginDAO {
	
	DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public LoginVO login(LoginVO loginVO) throws Exception {
		
		LoginVO userVO = null;
		StringBuilder sql = new StringBuilder();
		
		sql.append("select id, password, type ");
		sql.append(" from t_member ");
		sql.append(" where id = ? and ");
		sql.append("       password = ? ");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, loginVO.getId());
			pstmt.setString(2, loginVO.getPassword());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				userVO = new LoginVO();
				userVO.setId(rs.getString("id"));
				userVO.setPassword(rs.getString("password"));
				userVO.setType(rs.getString("type"));
			}
			return userVO;
			
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				rs.close();
				pstmt.close();
				
				// DataSource로부터 얻은커넥션 객체는 close()를 호출하면, 
				// DB서버와의 연결을 닫는 것이 아니라 DataSource에게 커넥션 반납
				con.close();
			} catch (Exception e) {
			}
		}
	}
}
