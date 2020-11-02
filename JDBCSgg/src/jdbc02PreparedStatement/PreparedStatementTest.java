/**
 * 
 */
package jdbc02PreparedStatement;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.xml.crypto.Data;

import org.junit.Test;

import jdbc01Connection.ConnectionTest;
import jdbc03util.JDBCUtils;

/**
 * @author ChristinaXinny
 * @date 2020_10_25 18:10:02
 */

/*
 * 
 * 使用PreparedStatement代替Statement
 * 
 * 增删改；查
 * 
 * 
 */

public class PreparedStatementTest {

//	增
	@Test
	public void test01() throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			// 1.读取4个信息
			InputStream is = ClassLoader.getSystemResourceAsStream("jdbc.properties");
			// getClassLoader类的加载器 获取一个系统类加载器

			Properties prop = new Properties();
			prop.load(is);

			String user = prop.getProperty("user");
			String password = prop.getProperty("password");
			String url = prop.getProperty("url");
			String driverClass = prop.getProperty("driverClass");

			// 2.加载驱动
			Class.forName(driverClass);

//		3.获取连接
			conn = DriverManager.getConnection(url, user, password);
			System.out.println(conn);

			// 4.预编译sql语句 返回PreparedStatement实例 占位符‘ ？’
			String sql = "insert into `order`(order_id,order_name,order_date)values(?,?,?)";
			ps = conn.prepareStatement(sql);

			// 5.填充
			ps.setInt(1, 11);// 占领第一个问号
			ps.setString(2, "nana@mail.com");

			// 补充：获取时间 注意这里的yyyy-MM-dd MM是要大写 不然就变成了min分钟
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date data = sdf.parse("1000-1-1");
			ps.setDate(3, new java.sql.Date(data.getTime()));

			// 6.执行sql
			ps.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
//		7.资源关闭

			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

//	改
	@Test
	public void testUpdate() throws Exception {

		Connection conn = null;
//		Statement statement = conn.createStatement();
		PreparedStatement ps = null;
		try {
//---1.获取数据库的连接 connection
			conn = jdbc03util.JDBCUtils.getConnection();

// ---2.预编译sql语句 preparedStatement的实例
			String sql = "update `customers` set name = ? where id = ?";
			ps = conn.prepareStatement(sql);

// ---3.填充占位符
			ps.setObject(1, "摸咂");
			ps.setObject(2, 13);
			// 这里用setObject 是为了 防止int string char 之类的

// ---4.执行
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//		5.资源关闭 
			jdbc03util.JDBCUtils.closeResource(conn, ps);

		}

	}
	
	
	
	
	
	
	
	
	

	@Test
	public void testCommonUpdate() throws Exception {
		
////		删除
//		String sql = "delete from customers where id = ?";
//		update(sql, 3);
		
		
//		改
		String sql = "update `order` set order_name = ? where order_id = ?";
		update(sql, "DD" ,"2");
	}
	
	
	
	
	
	public void update(String sql, Object... obj){

		Connection conn = null;
		PreparedStatement ps = null;
		try {
//		1.获取conn 
			conn = JDBCUtils.getConnection();

// 2.预编译sql 返回ps string sql = "..."; ps ps = conn.ps(sql)
			ps = conn.prepareStatement(sql);

//		3.填充占位符 setObject
			for (int i = 0; i < obj.length; i++) {
				ps.setObject(i + 1, obj[i]);
			}

//		4.执行 execute
			ps.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
//		5.关闭资源
			JDBCUtils.closeResource(conn, ps);
			
		}


	}

}
