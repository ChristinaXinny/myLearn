/**
 * 
 */
package duoXianCheng;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ChristinaXinny
 * @date 2020_10_18 22:52:12
 * 
 *       线程池
 * 
 */

class R1 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			if (i % 2 == 0) {
//				System.out.println("ff");
				System.out.println(Thread.currentThread().getName() + " : " + i);
			}
		}

	}

}

class R2 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			if (i % 2 != 0) {
				System.out.println(Thread.currentThread().getName() + " : " + i);
			}
		}

	}

}

public class Thread4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		1.提供指定数量的线程池 这里是10个
		ExecutorService es = Executors.newFixedThreadPool(10);
		
//		2.执行指定的线程的操作 要传入Runnable接口或者是Callable接口的实现对象
//		适用于Runnable接口
		es.execute(new R1());
		es.execute(new R2());
		
//		适用于Callable的接口
//		es.submit(Callable a);
		
		
//		3.关闭线程池
		es.shutdown();

	}

}
