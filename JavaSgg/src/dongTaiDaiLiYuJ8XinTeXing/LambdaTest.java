/**
 * 
 */
package dongTaiDaiLiYuJ8XinTeXing;

import java.util.Comparator;

import org.junit.Test;

//import jdk.internal.jline.internal.TestAccessible;

/**
 * @author ChristinaXinny
 * @date 2020_10_19 14:56:20
 */
public class LambdaTest {

	@Test
	public void test1() {
		Runnable r1 = new Runnable() {
			public void run() {
				System.out.println("i love bj");
			}
		};
		r1.run();

		System.out.println("************");

		new Runnable() {
			public void run() {
				System.out.println("i love gg");
			}
		}.run();

		System.out.println("************");

		Runnable r2 = () -> System.out.println("i love qq");
		r2.run();

	}

	@Test
	public void test2() {
		Comparator<Integer> com1 = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}
		};

		int cc1 = com1.compare(21, 33);
		System.out.println(cc1);

		System.out.println("************");

//		lambda表达式
//		Comparator这个接口和runnable接口一样 只有一个方法 所以可以直接调用即可
//		Integer类型只要在第一次出现之后 像是new后面的《》里面也可以省略 public int compare(Integer o1, Integer o2)这里的integer也可以省略
		Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);

		int cc2 = com2.compare(21, 11);
		System.out.println(cc2);

		System.out.println("************");
		
//		方法引用
		Comparator<Integer> com3 = Integer :: compare;

		int cc3 = com3.compare(21, 11);
		System.out.println(cc3);
		
	}

}
