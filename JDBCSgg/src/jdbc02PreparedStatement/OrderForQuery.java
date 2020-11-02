/**
 * 
 */
package jdbc02PreparedStatement;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.junit.Test;

import jdbc03util.JDBCUtils;

/**
 * @author ChristinaXinny
 * @date 2020_10_26 15:36:18
 */


/*
 * 针对于表的字段名与类的属性名不相同的情况:
 * 1.必须声明sql时,使用类的属性名来命名字段的别名
 * 2.使用ResultsetMetaData 时,需要使用getColumnLabel ()来替换getColumnName (）
 * 获取列的别名。
 * 说明:如果sql中没有给字段其别名,getColumnLabe ()获取的就是列名
 * 
 */


public class OrderForQuery {

	@Test
	public void testQueryForCustomers() throws Exception {

		String sql = "select order_id orderId,order_name orderName,order_date orderDate from `order` where order_id = ?";
		Order o1 = testOrderQuery(sql, 1);
		System.out.println(o1);

		
		sql = "select order_id orderId,order_date orderDate from `order` where order_name=?";
		Order o2 = testOrderQuery(sql, "AA");
		System.out.println(o2);

	}
	
	
	public Order lxyOrder(String sql, Object...args) throws Exception {
		
		Connection conn = null;
		PreparedStatement ps= null;
		ResultSet rs =null;
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i+1, args[i]);
			}
			
			rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			int columnCount = rsmd.getColumnCount();
			
			if(rs.next()) {
				Order order = new Order();
				for (int i = 0; i < columnCount; i++) {
					String columnLabel = rsmd.getColumnLabel(i+1);
					Object columnValue = rs.getObject(i+1);
					
					Field field = Order.class.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(order, columnValue);
					
					
				}
				return order;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			JDBCUtils.closeResultset(conn, ps, rs);
		}
		
		
		
		return null;
	} 
	
	
	
	
	
	
	public Order testOrderQuery(String sql, Object... args) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);

			}
// 		ps.exeQ ---> rs 执行---->结果集
			rs = ps.executeQuery();
//		rs.getMD ---> rsmd    结果集----->元数据
			ResultSetMetaData rsmd = rs.getMetaData();
//		rsmd.getColC----->colC    列数
			int columnCount = rsmd.getColumnCount();

//			如果是对多行数据查询 可以采用
//			在sql语句中 id<10...
//			用while代替if
			
			
//			这个是对一行的几个特点进行next
			if (rs.next()) {
				Order order = new Order();
				for (int i = 0; i < columnCount; i++) {
//				rs.getObj ---> colV    列的值
					Object columnValue = rs.getObject(i + 1);
//				rsmd.getColL ----> colL    列的（别）名
					String columnLabel = rsmd.getColumnLabel(i + 1);

//				反射 ----- 得到field【控制属性】
					Field field = Order.class.getDeclaredField(columnLabel);
//					允许证
					field.setAccessible(true);
//					对属性对对象和值 set
					field.set(order, columnValue);

				}
				return order;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			JDBCUtils.closeResultset(conn, ps, rs);
		}
		return null;

	}

}
