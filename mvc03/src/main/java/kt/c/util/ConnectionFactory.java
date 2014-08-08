package kt.c.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class ConnectionFactory {
	
	ArrayList<Connection> conlist = new ArrayList<Connection>();

	public Connection getConnection() throws Exception {
		if (conlist.size() > 0) {
			return conlist.remove(0); // 0번지 객체 리턴
		} else {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";

			return DriverManager.getConnection(url, user, password);
		}
	}

	public void returnConnection(Connection con) {
		try {
			if (!con.isClosed()) {
				conlist.add(con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void closeAll(){
		for(Connection con : conlist){
			try {
	      con.close();
      } catch (Exception e) {
      	e.printStackTrace();
      }
		}
	}
}