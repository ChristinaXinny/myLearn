/**
 * 
 */
package duoXianCheng;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ChristinaXinny
 * @date 2020_10_17 16:57:58
 * 
 * 
 */

class Window implements Runnable {

	private int ticket = 100;
	
//	如果是继承Thread：
//	private static int ticket = 100;
	

//	1.实例化ReentrantLock
//	ReentrantLock(true)当括号里面写的是true 意味着是公平的 
//	即 当线程1 2 3 按顺序来到这一步骤时 根据到达的顺序 进入lock
//	也就是说1先到1先执行 在1执行时 2 3都在外头等着 之后1结束 2比3先到 就也是先2进入 在这排队
//	而不是1完了之后 2和3还要在抢一次进去

	private ReentrantLock lock = new ReentrantLock(true);

	@Override
	public void run() {
		while (true) {

			
			
			try {
				
				// 2.调用锁定方法lock（）
				lock.lock();
				if (ticket > 0) {
					System.out.println(Thread.currentThread().getName() + ": is " + ticket);
					ticket--;
				} else {
					break;
				}
			} finally {
//				3.调用解锁
				lock.unlock();
				
			}
		}

	}

}

public class LockTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
