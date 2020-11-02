/**
 * 
 */
package jdbc01Connection;




import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


import org.junit.Test;

/**
 * @author ChristinaXinny
 * @date 2020_10_25 16:10:33
 */
public class ConnectionTest {

	@Test
	public void test1() throws SQLException {
		System.out.println("eee");

//		驱动包和mysql必须要保持一致 在驱动包8.0以上的版本必须要加com.mysql.cj.jdbc.Driver();
//		Driver driver = new com.mysql.jdbc.Driver();//这个是5.0版本
		Driver driver = new com.mysql.cj.jdbc.Driver();
//		相当于是多态  下面声明成connection 实际上是driver的对象

		String url = "jdbc:mysql://localhost:3306/mySql";

//		将用户名和密码封装到properties中
		Properties info = new Properties();
//		setProperty（键值对）
		info.setProperty("user", "root");// 用户名
		info.setProperty("password", "qwe123123");// 密码

		Connection conn = driver.connect(url, info);

		System.out.println(conn);
		System.out.println("e");

	}

	@Test
	public void testC1() throws SQLException {

		Driver driver = new com.mysql.cj.jdbc.Driver();

		String url = "jdbc:mysql://localhost:3306/mySql";

		Properties info = new Properties();
		info.setProperty("user", "root");// 用户名
		info.setProperty("password", "qwe123123");// 密码

		Connection conn = driver.connect(url, info);

		System.out.println(conn);
		System.out.println("t1e");
	}
	
	
	
	
	
	
	
//	面向对像 尽可能不要出现第三方的api【比如从mysql换成sqlServer】保证更好的可移植性
//	test1中 com.mysql.cj.jdbc.Driver();这个就是第三方的 mysql
//	对法1的迭代 【不出现第三方的api】
	@Test
	public void test2() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
//		1.使用反射获取driver对象【车
		Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");//第三方的驱动包
		Driver driver = (Driver) clazz.newInstance();
		
//		2.提供要链接的数据库【路线
		String url = "jdbc:mysql://localhost:3306/mySql";
		
//		3.提供连接的用户名 密码【通行证
		Properties info = new Properties();
		info.setProperty("user", "root");
		info.setProperty("password", "qwe123123");
		
//		4.获取连接【最后获取到许可进行下一步的是车 所以利用的也是车来connect】 
		Connection conn = driver.connect(url, info);
		System.out.println(conn);
		System.out.println("t2");
	}
	
	
	
//	获取方式3
//	DriverManager代替driver
	@Test
	public void test3() throws Exception{
		
		
//		1.提供url user password
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "qwe123123";
		
		
		
//		2.获取driver的对象
//		Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
		Class clazz1 = Class.forName("com.mysql.cj.jdbc.Driver");
		Driver driver = (Driver) clazz1.newInstance();
//		3.注册驱动
		DriverManager.registerDriver(driver);
		
//		4.获取连接
		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println(conn);
		System.out.println("t3");

	}
	
	
	
	
	
	
	
	
//	方式4  优化方式3 只是加载驱动 不用显示的注册驱动 
	@Test
	public void test4() throws Exception{
		
		
//		1.提供url user password
		String url = "jdbc:mysql://localhost:3306/mySql";
		String user = "root";
		String password = "qwe123123";
		
		
		
//		2.加载driver
		Class.forName("com.mysql.cj.jdbc.Driver");
//		因为在mysql的driver实现类 中的静态代码块声明了注册驱动了
		
//		3.获取连接
		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println(conn);
		System.out.println("t4");

	}
	
	
	
//	方式5 【final】将数据库的4个基本信息声明在配置文件中 通过读取配置文件 获得连接
//	好处：
//	实现了数据与代码分离 实现了解耦
//	如果需要修改配置文件信息 可以避免程序重新打包
	@Test
	public void test5() throws Exception{
//		1.读取4个信息
		InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
//		getClassLoader类的加载器
		
		Properties prop = new Properties();
		prop.load(is);
		
		String user= prop.getProperty("user");
		String password= prop.getProperty("password");
		String url= prop.getProperty("url");
		String driverClass= prop.getProperty("driverClass");
		
		
		
//		2.加载驱动
		Class.forName(driverClass);
		
//		3.获取连接
		Connection conn = DriverManager.getConnection(url, user, password); 
		System.out.println(conn);
		
		
	}

	


}
