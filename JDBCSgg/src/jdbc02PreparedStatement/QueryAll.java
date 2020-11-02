/**
 * 
 */
package jdbc02PreparedStatement;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import jdbc03util.JDBCUtils;

/**
 * @author ChristinaXinny
 * @date 2020_10_26 16:52:18
 */








public class QueryAll {
	
	@Test
	public void testQueryMore() throws Exception {
		String sql = "select id,name,email from customers where id<?";
		List<Customer> cList = QueryMore(Customer.class, sql, 12);
//		System.out.println(c);
		cList.forEach(System.out::println);
		
		System.out.println("*******************");
//		这样也可以 就相当于是statement   prepareStatement就是有了‘？’占位符
		sql = "select id,name,email from customers where id =12";
		List<Customer> cList2 = QueryMore(Customer.class, sql);
//		System.out.println(c);
		cList2.forEach(System.out::println);
		
		
		System.out.println("*******************");
		sql = "select order_id orderId,order_name orderName,order_date orderDate from `order` where order_id < ?";
		List<Order> oList = QueryMore(Order.class, sql, 3);
//		System.out.println(o1);
		oList.forEach(System.out::println);
		
		
		System.out.println("*******************");
//		查询所有
		sql = "select order_id orderId,order_name orderName,order_date orderDate from `order`";
		List<Order> oList2 = QueryMore(Order.class, sql);
//		System.out.println(o1);
		oList2.forEach(System.out::println);
	}
	
	
	/*
	 * 查询对随意表的多条记录
	 * 返回list
	 */
	public <T> List<T> QueryMore(Class<T> clazz, String sql, Object...args) throws Exception {

		Connection conn = null;
		PreparedStatement ps = null;
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
			ArrayList<T> list = new ArrayList<T>();
			while(rs.next()) {
				T t = clazz.getDeclaredConstructor().newInstance();//任何一个类都要提供一个空参
				for (int i = 0; i < columnCount; i++) {
					String columnLabel = rsmd.getColumnLabel(i+1);
					Object columnValue = rs.getObject(i+1);
					
					Field field = clazz.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(t, columnValue);
				}
				list.add(t);
			}
			return list;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			JDBCUtils.closeResultset(conn, ps, rs);
		}
		
		
		
		return null;
	}
	
	
	
	
	//测试Query
	@Test
	public void testQuery() throws Exception {
		String sql = "select id,name,email from customers where id=?";
		Customer c1 = Query(Customer.class, sql, 12);
		System.out.println(c1);
		
		
		sql = "select order_id orderId,order_name orderName,order_date orderDate from `order` where order_id = ?";
		Order o1 = Query(Order.class, sql, 1);
		System.out.println(o1);
	}
	
	/*
	 * 对不同表对通用对查询操作
	 */
	public <T> T Query(Class<T> clazz, String sql, Object...args) throws Exception {

		Connection conn = null;
		PreparedStatement ps = null;
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
				T t = clazz.getDeclaredConstructor().newInstance();//任何一个类都要提供一个空参
				for (int i = 0; i < columnCount; i++) {
					String columnLabel = rsmd.getColumnLabel(i+1);
					Object columnValue = rs.getObject(i+1);
					
					Field field = clazz.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(t, columnValue);
				}
				return t;
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			JDBCUtils.closeResultset(conn, ps, rs);
		}
		
		
		
		return null;
	}
	

}
