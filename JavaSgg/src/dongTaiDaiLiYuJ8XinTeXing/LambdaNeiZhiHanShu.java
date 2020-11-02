/**
 * 
 */
package dongTaiDaiLiYuJ8XinTeXing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.junit.Test;

/**
 * @author ChristinaXinny
 * @date 2020_10_19 17:50:59
 * 
 * 
 * 
 * java 内置4大基本函数式接口
 * 
 * 消费型接口 Consumer<T>			void accept(T t)
 * 供给型接口	Supplier<T>			T get()
 * 函数型接口 Function<T,R>		R apply(T t)
 * 判定型接口 Predicate<T>		boolean test(T t)
 * 
 * 
 * 
 */
public class LambdaNeiZhiHanShu {
	
	@Test
	public void test1() {
		
		happyTime(500, new Consumer<Double>() {
			@Override
			public void accept(Double t) {
				System.out.println("学习太累了，去天上人间买了瓶水，价格为：" + t);
			}
		});
		
		System.out.println("******************");

		happyTime(400, money -> System.out.println("学习太累了，去天上人间喝了口水，价格为：" + money));
		
	}
	
	
	public void happyTime(double money, Consumer<Double> con) {
		con.accept(money);
	}
	
	
	@Test
	public void test2() {
		List<String> list = Arrays.asList("南京","北京","天津","东京","吸金","普京");
		List<String> fil1 = filString(list, new Predicate<String>() {
			
			@Override
			public boolean test(String s) {
				// TODO Auto-generated method stub
				return s.contains("京");
			}
		});
		System.out.println(fil1);
		
		List<String> fil2 = filString(list, s -> s.contains("京"));
		System.out.println(fil2);
		
	}
	
//	根据给定的规则，过滤集合中的字符串 此规则有Predicate方法决定
	public List<String> filString(List<String> li, Predicate<String> pre){
		
		ArrayList<String> filList = new ArrayList<String>();
		
		for (String s : li) {
			if(pre.test(s)) {
				filList.add(s);
			}
		}
		return filList;
	}
	
	
	
	
	
	
	
	
	
	
	

	

}
