/**
 * 
 */
package changYongLei;

/**
 * @author ChristinaXinny
 * @date 2020_10_19 10:51:46
 */



/*

字符串的类：
	StringBuffer
	StringBuilder
时间类：
	System静态方法
	Data类
	Calendar类
	SimpleDataFormat
java比较器
	Comparable接口
	Comparator接口
System
Math
BigInteger/BigDecimal



-------------------------------------------------------------------
String
	1.声明为final 是不可被继承的
	2.实现Serializable接口【可序列化】
		 Comparable接口【可以计较】
	3.定义了final char[] value 【本质是字符数组】
	4.不可变字符序列  ----不可变性
		体现1）字符串重新赋值 要重写指定内存区赋值 不能在原有的value赋值
			2）对现有字符串+字符串时 也是重新赋值到新的地址上
			3）调用string对replace（）方法 修改 也是指向了一块新地址
	5.直接给String s = "..."这样字面量形式赋值【不是new】 这时对字符串声明在字符串对常量池中
	6.常量池里的字符串 不会有相同的 s1 = "123"; s2="123";  s1和s2都指向同一个地址上的字符串

 








 */
public class AASummary {

}
