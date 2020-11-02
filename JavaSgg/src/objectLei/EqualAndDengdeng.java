/**
 * 
 */
package objectLei;

import java.util.Date;

//import javax.xml.crypto.Data;

/**
 * @author ChristinaXinny
 * @date 2020_10_24 08:14:55
 */
public class EqualAndDengdeng {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 10;
		int j =10;
		double d = 10.0;
		System.out.println(i==j);//t
		System.out.println(i==d);//t
		
		boolean b = true;
//		System.out.println(i == b);
		
		char c = 10; 
		System.out.println(i == c);//t
		
		char c1 = 'A';
		char c2 = 65;
		System.out.println(c1 == c2);
		
		Customer cust1 = new Customer("tom", 12);
		Customer cust2 = new Customer("tom", 12);
		System.out.println(cust1 == cust2);//f-----对象之间== 是比较两个对象的地址是否一致
//		说是对象不如说cust1 2是对象的管理者 他们内容上储存的是customer的name age储存所在的地址
//		其实比较的是两个是不是指向同一个实体
		
		
		String s1 = new String("dddd");
		String s2 = new String("dddd");
		System.out.println(s1 ==s2);//f
		
		System.out.println("-------------------");
		System.out.println(cust1.equals(cust2));//f
//		因为Customer是自己写的类 其中在内部宾没有重写equal方法 所以继承自object的equal方法
//		也就是比较两个对象的地址 而不是内容【同==】 
//		在后面的String Data这些是引用类java的内部定义的类 
//		java已经在内部重写了equal 所以这里就比较的是内容  
		System.out.println(s1.equals(s2));//t
		
		Date da1 = new Date(32432525324L);
		Date da2 = new Date(32432525324L);
		System.out.println(da1.equals(da2));//t
		
		
		

	}

}
