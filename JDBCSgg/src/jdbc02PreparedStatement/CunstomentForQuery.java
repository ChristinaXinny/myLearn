/**
 * 
 */
package jdbc02PreparedStatement;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.junit.Test;

import jdbc03util.JDBCUtils;

/**
 * @author ChristinaXinny
 * @date 2020_10_26 09:59:14
 */

/*
 * 针对customers表的查询 yw每个表的各个数据对应不一样 sy先在这建立一个关于customer的查询
 */

public class CunstomentForQuery {

	@Test
	public void testQueryForCustomers() {

		String sql = "select id,name,birth,email from customers where id = ?";
		Customer c1 = queryForCustomers(sql, 12);
		System.out.println(c1);

		sql = "select id,email from `customers` where name=?";
		Customer c2 = queryForCustomers(sql, "aa");
		System.out.println(c2);

	}

	/*
	 * 针对customers表的通用的查询操作
	 */
	public Customer queryForCustomers(String sql, Object... args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);

			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			rs = ps.executeQuery();

//		获取结果集的元数据 ResultSetMetaData 
			ResultSetMetaData rsmd = rs.getMetaData();
//		通过ResultSetMetaData获取到了结果集的列数
			int columnCount = rsmd.getColumnCount();

//		进行行操作 有下一行数据 就下一个没有就false出来
			if (rs.next()) {
//			对每一行的数据都进行一次无参对象的建立
				Customer cust = new Customer();
//			对每一行
				for (int i = 0; i < columnCount; i++) {
//				获取列的值
					Object columnValue = rs.getObject(i + 1);

//				获取列的名字
					String columnName = rsmd.getColumnName(i + 1);

//				动态实现---》反射
//				给Custemers对象的columnName的属性赋值为columnValue----》通过反射
//				通过列的名字获得
//				DeclaredField：被宣布的地
//				getDeclaredFields(): 获取类中所有的属性(public、protected、default、private)，但不包括继承的属性，返回 Field 对象的一个数组
					Field field = Customer.class.getDeclaredField(columnName);
//				允许被改
					field.setAccessible(true);
//				set(Object obj, Object value) 将指定对象变量上此 Field 对象表示的字段设置为指定的新值
					field.set(cust, columnValue);

				}
				return cust;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResultset(conn, ps, rs);

		}

		return null;
	}

	@Test
	public void testQuery1() throws Exception {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
//		1. conn
			conn = JDBCUtils.getConnection();

			// 2. sql -> pa ps = conn.ps(sql)
			String sql = "select id,name,email,birth,photo from `customers` where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, 1);

			// 3. 占位符填充
			ps.setInt(1, 1);

//		4. 执行 并得到resultSet    ：    rs 	rs = ps.executeQuery()
			rs = ps.executeQuery();

			// 5. 处理结果集rs
			// next是判断rs的吓一跳是否有数据 有返回t并指针下移 无返回f指针不下一个
			if (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				java.util.Date birth = rs.getDate(4);
				int photo = rs.getInt(5);

				// 方式1
				System.out.println("id:" + id + ",name:" + name + ",...");

				// 方式2
				Object[] obj = new Object[] { id, name, email, birth, photo };

				// 方式3 一般提及数组 可以用set集合来代替【推荐
				Customer customer = new Customer(id, name, email, birth);
				System.out.println(customer.toString());

				// 关闭

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResultset(conn, ps, rs);

		}

//		补充
		/*
		 * hasNext（）和next（）是两步走 hasN仅仅是判断下面有没有下一项 next是返回下一项的值
		 * 
		 * 
		 */

	}
}
