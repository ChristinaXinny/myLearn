
/**
 * 
 */

import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import jdbc01Connection.ConnectionTest;
import jdbc03util.JDBCUtils;

/**
 * @author ChristinaXinny
 * @date 2020_10_25 10:48:37
 */

/*
 * 
 * 1.connection 
 * 2.preparedStatement 
 * 1）增删改 
 * 2）查----有返回resultSet 
 * 3）
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * ---------------------------JDBC编写步骤--------------------------- 【见MC/JDBC/图片】
 * 1. 开始 
 * 2. 导入java.sql包 
 * 3.1 纯java驱动方式【oracle，mysql】 
 * 3.2 jdbc-odbc桥【sqlserver】微软家的（ 
 * 4. 加载 驱动包 
 * 5. 创建Connection对象 【获得到数据库连接的可以说是一个数据库操作的允许】【想要得到允许就相当于是想要去西藏一样，要有1车driver 2路线url 3通行证info】 
 * 6. 创建Statement对象【控制数据库的增删改查的操作 这个是被允许操作的操作者 许可证】 
 * 7. 执行Sql语句 if 查询【查询的话是会返回一个表（结果） 所以是result 的一个set（集合）】 使用ResultSet对象 关闭ResultSet对象【就和io操作一样要关闭】 
 * 8. 关闭statement对象 
 * 9. 关闭connection对象 
 * 10. 结束
 * 
 * statement：说明; 说法; 表白; 表态; 声明; 陈述; 报告; 结算单; 清单; 报表;
 * 
 * 
 * 
 * 
 * 好比做是去西藏旅游 
 * driver相当于是那辆车 ----Driver 
 * url：相当于是走那条路 ----String
 * info：相当于是通行证【含用户名/密码】---Properties
 * 
 * 
 * properties：所有物; 财产; 财物; 不动产; 房地产; 房屋及院落; 庄园; class Properties extends
 * Hashtable<Object,Object>
 * 
 * Instance： 例子; 事例; 实例
 * 
 * 
 * ---------------------------ConnectionTest---------------------------
 * 
 * 
 * 5种方式连接 第四种： 
 * 1. 提供4个基本信息：
 * a.要连接的是那个第三方driver 
 * b.要链接的数据库url 
 * c.user 
 * d.password 
 * 2.加载Class.forName 
 * 3. 获取连接： 采用Connection conn =DriverManager.getConnection（url，user，password）
 * 
 * user=root password=qwe123123 url=jdbc:mysql://localhost:3306/mySql
 * driverClass=com.mysql.cj.jdbc.Driver
 * 
 * 
 * 
 * public class Driver extends NonRegisteringDriver implements java.sql.Driver
 * implements java.sql.Driver ：实现了jdbc的一个标准
 * 
 * 
 * 
 * 
 * //url:http://localhost:8080/gmall/keyboard.jpg
 * 
 * // http == jdbc:mysql:一整个就是充当http 协议 // jdbc: 主协议 // mysql ： 子协议
 * 
 * // localhost ： ip地址 // 3306 ：默认的mysql的 端口号 // test ： 数据库的名字 String url =
 * "jdbc:mysql://localhost:3306/test";
 * 
 * 
 * 最终版********************* // 
 * 1.读取4个信息 InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
 * // getClassLoader类的加载器
 * 
 * Properties prop = new Properties(); prop.load(is);
 * 
 * String user= prop.getProperty("user"); String password=
 * prop.getProperty("password"); String url= prop.getProperty("url"); String
 * driverClass= prop.getProperty("driverClass");
 * 
 * 
 * 
 * // 2.加载驱动 Class.forName(driverClass);
 * 
 * // 3.获取连接 Connection conn = DriverManager.getConnection(url, user, password);
 * System.out.println(conn);
 * 
 * 
 * 
 * 
 * 
 * 
 * ------------------Statement-->PreparedStatement---------------------------
 * 不靠谱 sy被替换成了他的子接口：PreparedStatement yw ：
 * 1.拼串 
 * 2.SQL注入问题【可以让不存在的用户也能进入到数据库】
 * 
 * 
 * 
 * 
 * ～～～～～～增删改～～～～的操作 
 * 1.获取到connection的连接 
 * 2.预编译sql语句返回PreparedStatement的实例 String sql = "...sql的增删改语句..."; PreparedStatement ps = conn.preparedStatement(sql);
 * 3.填充占位符 ps.setObject(1,"..."); ps.setObject(2,"..."); .... 
 * 4.执行 ps.execute()
 * 5.关闭 conn ps
 * 
 * 
 * ～～～～～～～～查～～～～～
 * 
 * 
 * 对customer表 queryForCustomers(String sql, Object... args) 
 * 1. conn --------- 
 * 2. sql 返回ps-------ps = conn.ps(sql) 
 * 3. setObj到ps------- ps.setObj(args)//args不确定
 * 4. ps.运行 得到一个结果集-------rs = ps.exeQ()//rs不确定 
 * 5. yw结果集的元素不确定 sy：获取元数据 rsmd =
 * rs.getMateDate()//这里得到的是一行的数据 
 * 6. 获取列数 colCount = rsmd.getColCount(); 
 * 7. rs.next()//rs是对行操作； rsmd是对列操作[表头元素】 
 * 8. 建立每一行的数据对象 每一行都是一个数据对象
 * 每一行的一个特征映射是类对象的一个属性 
 * 9. 获取列的值 colValue = rs.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

/*
 * 补充知识 ---------------------------多态---------------------------
 * 多态是同一个行为具有多个不同表现形式或形态的能力。 多态就是同一个接口，使用不同的实例而执行不同操作
 * 
 * Animal animal = new Animal(); //创建Animal对象 
 * Animal cat = new Cat(); //创建Cat对象
 * Animal dog = new Dog(); //创建Dog对象 
 * // 三块广告牌 
 * board(animal); 
 * board(cat);
 * board(dog); 
 * 多态存在的三个必要条件 继承 重写 基类引用指向派生类对象（引用还是指向基类）eg: Parent p = new
 * Child();
 * 
 * 
 * 
 * 
 * ---------------------------反射---------------------------
 * https://blog.csdn.net/u014102846/article/details/81481126 Class
 * （反射的入口）、Method （成员方法）、Field （成员变量） 
 * Java反射中Field类描述的是类的属性信息，功能包括：
 *  1. 获取当前对象的成员变量的类型 
 *  2. 对成员变量重新设值
 * 
 * 
 * 
 * 
 * ---------------------------forEach---------------------------
 * List.forEach(System.out::println);
 * 
 */
public class AASummary {
	
/*
 * 增删改
 */
	public void update(String sql, Object... obj) {

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
		} finally {
//		5.关闭资源
			JDBCUtils.closeResource(conn, ps);

		}

	}
	
	
	/*
	 * 查
	 */
	
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
