package kt.c.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() {
		
		Connection con = null;
		
		try {
			
			// 1. ����̹� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";
			
			con = DriverManager.getConnection(url, user, password);
			
			// 2. ���ᰴü ��
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 3. ��� ���ᰴü ����
		return con;
	}
	
	public void close(Connection con, PreparedStatement pstmt) {
		
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}












