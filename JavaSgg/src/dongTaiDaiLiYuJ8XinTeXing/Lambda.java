/**
 * 
 */
package dongTaiDaiLiYuJ8XinTeXing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;

/**
 * @author ChristinaXinny
 * @date 2020_10_19 15:36:03
 * 
 * 
 *       1.举例 (o1, o2) ---> Integer.compare(o1, o2); 
 *       
 *       2.格式： 
 *       -> : Lambda 操作符/箭头操作符 
 *       ->左边： Lambda形参列表 （其实就是接口中的抽象方法的形参类表 
 *       ->右边： Lambda本体
 *       （其实就是重写的抽象方法的方法体
 * 
 *       3.Lambda的使用 ：（6种情况
 *       
 *       	总结：
 *       	->左边：
 *       	->右边：
 *       
 *       4.lambda本质： 函数式接口的实例
 *       5.如果一个接口中只声明了一个抽象方法 就称这个接口为函数式接口
 *       6.以前用的匿名函数都可以用lambda
 *       
 *   因为java一开始就声明了自己是面向对象的【oop】但是随着科技的发展。。。也开始想接收一些面向函数【oof】 
 *   lambda在其他语言中大部分都是一个函数 但在java中他则是一个实例 
 *   java：    Runnable r2 = 【lambda】
 *   所以  lambda 是 函数式接口的实例 是属于‘=’的左侧
 *   
 * 
 */
public class Lambda {

//法1.	无参 无返回值
	@Test
	public void test1() {
		Runnable r1 = new Runnable() {

			@Override
			public void run() {
				System.out.println("it is first run");
			}
		};
		;
		r1.run();

		System.out.println("******************");

		Runnable r2 = () -> System.out.println("it is second run");

		r2.run();

	}
	
//法2.		有参数 无返回值
	@Test
	public void test2() {
		Consumer<String> c1 = new Consumer<String>() {
			
			@Override
			public void accept(String t) {
				System.out.println("it is third Consumer: \n" + t);
				
			}
		};
		c1.accept("谎言与誓言的区别？？");
		
		System.out.println("******************");
		
		Consumer<String> c2 = (String t) -> {
			System.out.println("it is fourth Consumer: \n" + t);

		};
		c2.accept("一个说的人当真了， 一个听的人当真了");
		
	}
	
//法3.	’类型推断‘：数据类型可以省略 编译器推断出类型
	@Test
	public void test3() {
		
		Consumer<String> c3 = (t) -> {
			System.out.println("it is fifth Consumer: \n" + t);

		};
		c3.accept("Amazing!!!");
		
		System.out.println("******************");

//		类型推断：
		List<String> list = new ArrayList<>();//推断《》
		
		int[] a = new int[] {1,2,3};
		int[] b = {1,2,3};//推断【】
		
	}
	
	
//法4.当参数只有一个的时候 可以不要写（）
	@Test
	public void test4() {
		Consumer<String> c3 = t -> {
			System.out.println("it is sixth Consumer: \n" + t);

		};
		c3.accept("Amazing!!!");
	}
	
	
//法5.当有2个即以上多个参数值 多条语句 有返回值
	@Test
	public void test5() {
		Comparator<Integer> c1 = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				System.out.println(o1);
				System.out.println(o2);
				return o1.compareTo(o2);
			}
			
		};
		System.out.println("~~~");
		System.out.println("c1 : "+ c1.compare(21, 23));
		System.out.println("~~~");
		int ans1  = c1.compare(21, 23);
		System.out.println("ans1: "+ans1);
		
		
		System.out.println("******************");
		Comparator<Integer> c2 = (o1, o2) -> {
				System.out.println(o1);
				System.out.println(o2);
				return o1.compareTo(o2);
			};
			
		System.out.println("~~~");
		System.out.println("c2 : "+ c2.compare(44, 23));
		System.out.println("~~~");
		int ans2  = c2.compare(44, 23);
		System.out.println("ans2: "+ans2);
		
	}
	
	
//法6.当只有一条语句 return和大括号有 可以省略
		@Test  
		public void test6() {
			Comparator<Integer> c2 = (o1, o2) -> {
				return o1.compareTo(o2);
			};
			
		System.out.println("~~~");
		System.out.println("c2 : "+ c2.compare(44, 23));
		System.out.println("~~~");
		int ans2  = c2.compare(44, 23);
		System.out.println("ans2: "+ans2);
		}
	
	

}
