/**
 * 
 */
package duoXianCheng;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author ChristinaXinny
 * @date 2020_10_18 19:48:32
 * 

新增方式一:实现Callable 接口
与使用Runnable 相比,Callable 功能更强大些
	相比run()方法,可以有返回值
	方法可以抛出异常
	支持泛型的返回值
	需要借助Future 类,比如获取返回结果
	
	Future 接口
		可以对具体Runnable 、Callable 任务的执行结果进行取消、查询是否完成、获取结果等。
		Future Task 是Future 接口的唯一的实现类
		Future Task 同时实现了Runnable ,Future 接口。它既可以作为Runnable 被线程执行,又可以作为Future 得到Callable 的返回值


https://www.cnblogs.com/dolphin0520/p/3949310.html


 * 
 */
//创建线程的方式3:
//	实现Callable接口


//1.创建callable的实现类
class Number2 implements Callable{
//Callable支持泛型
//class Number2 implements Callable<Integer>{
	
	


	
//	throws Exception 可以抛异常
//	2.实现call方法，将此线程需要执行的操作声明在call中
	@Override
	public Object call() throws Exception {
	//Callable支持泛型
//	public Integer call() throws Exception {

		int sum = 0;
		for (int i = 0; i < 100; i++) {
			if(i%2==0) {
				System.out.println(i);
				sum += i;
			}
		}
		return sum;
	}
}

public class Thread3 {
	public static void main(String[] args) {
//		3.创建callable接口实现类的对象
		Number2 n = new Number2();
		
//		4.将此Callable接口实现类的对象作为传递到FutrueTask构造器中，创建FutureTask的对象
		FutureTask ft = new FutureTask(n);
//		支持泛型
//		FutureTask<Integer> ft = new FutureTask<Integer>(n);
		
//		5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread的对象，最后调用start（）
		new Thread(ft).start(); 
		try {
			
//			6.【可要可不要，如果对返回值不敢兴趣可以不要】获取Callable中的call方法的返回值
//			get（）返回值是FutureTask构造器参数Callable的实现类重写call的返回值
			Object sum = ft.get();
//			支持泛型
//			Integer sum = ft.get();
//			泛型写出来是为了更好的明确类型是什么 更容易读懂代码
			System.out.println(sum);
			
//			6.其实是为了有些项目中 实现一个线程要获取另一个线程的东西才可以向下进行设计
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
