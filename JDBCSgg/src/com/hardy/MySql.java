/**
 * 
 */
package com.hardy;

/**
 * @author ChristinaXinny
 * @date 2020_10_25 13:14:17
 */
//package com.hardy;

import java.sql.*;

import org.junit.Test;

//import org.junit.Test;


public class MySql 
{
	
	@Test
	public void test() {
		try 
        {  
              Class.forName("com.mysql.cj.jdbc.Driver");     //加载MYSQL JDBC驱动程序      
             System.out.println("Success loading Mysql Driver!");  
         }  
         catch (Exception e) 
        {  
              System.out.print("Error loading Mysql Driver!");  
              e.printStackTrace();  
        }  
        try 
        {  
                Connection connect = DriverManager.getConnection(  
                  "jdbc:mysql://localhost:3306/mySql","root","qwe123123");  
                   //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码  
          
              
               Statement stmt = connect.createStatement();  
               
               ResultSet rs = stmt.executeQuery("select * from testToJavaConnection.testsss");  
                                                                      //user 为你表的名称  
               while (rs.next()) 
               {  
                   
                   String uid = rs.getString("stuID");
                   String name = rs.getString("name");
                   String age = rs.getString("age");
                   
                   System.out.println("学号:" + uid +""
                        + "\t" + "姓名:" + name + "\t" + "年龄:"+ age + "\n" );
               }   
               rs.close(); 
               connect.close(); // 关闭连接  
         }  
         catch (Exception e) 
         {  
              System.out.print("get data error!");  
              e.printStackTrace();  
          }  
	}
	
    public static void main(String[] args) 
    {
        
    }  
}