/**
 * 
 */
package jdbc04exer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import org.junit.Test;

import jdbc03util.JDBCUtils;

/**
 * @author ChristinaXinny
 * @date 2020_10_26 18:26:02
 */
public class Exer1Test {

	/*
	 * 从控制台输入数据 添加哦到customers表
	 */
	@Test
	public void testInsert() {
		Scanner in = new Scanner(System.in);
		System.out.print("inset user name: ");
		String name = in.next();
		System.out.print("inset user email: ");
		String email = in.next();
		System.out.print("inset user birthday: ");
		String birthday = in.next();//'1999-09-03'
		
		String sql = "insert into `customers`(name, email, birth)values(?,?,?)";
		int isInsert = update(sql, name, email, birthday);
		System.out.println(isInsert>0?"添加成功":"添加失败");
		
	}
	
	
	public int update(String sql, Object... obj) {

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtils.getConnection();

			ps = conn.prepareStatement(sql);

			for (int i = 0; i < obj.length; i++) {
				ps.setObject(i + 1, obj[i]);
			}

			/*
			 * ps .execute ()
			 * 如果执行的是查询操作,有返回结果,则此方法返回true;
			 * 如果执行的是增、删、改操作,没有返回结果,则此方法返回false
			 * 
			 */
//			ps.execute();
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.closeResource(conn, ps);
			
		}
		return 0;


	}

}
