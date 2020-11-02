/**
 * 
 */
package jdbc03util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.cj.protocol.Resultset;

import jdbc01Connection.ConnectionTest;

/**
 * @author ChristinaXinny
 * @date 2020_10_25 20:57:56
 */
public class JDBCUtils {
	
	
	
//	连接
	public static Connection getConnection() throws Exception{
		InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
		
		Properties prop = new Properties();
		prop.load(is);
		
		String user= prop.getProperty("user");
		String password= prop.getProperty("password");
		String url= prop.getProperty("url");
		String driverClass= prop.getProperty("driverClass");
		
		
		
		Class.forName(driverClass);
		
		Connection conn = DriverManager.getConnection(url, user, password); 
		return conn;
		
		
	}
	
	
//	关闭
	public static void closeResource(Connection conn, Statement ps) {
		try {
			if(ps != null)
				ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public static void closeResultset(Connection conn, Statement ps, ResultSet rs ) {
		
		try {
			if(ps != null)
				ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
