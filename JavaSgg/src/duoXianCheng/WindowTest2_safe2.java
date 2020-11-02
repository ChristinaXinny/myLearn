/**
 * 
 */
package duoXianCheng;

/**
 * @author ChristinaXinny
 * @date 2020_10_16 17:30:53
 * 
 * Runnable接口：
 * 同步方法 解决线程安全问题 
 * 
 */

class Window2_safe2 implements Runnable {

	private int ticket = 100;

	@Override
	public void run() {
		while (true) {
			show();
			
		}
	}
	private synchronized void show() {//这样写 其实同步监视器就相当于this
		//可以没有开始
		try {
			Thread.sleep(10);//主要是sleep
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//可以没有结束

		if (ticket > 0) {
			System.out.println(Thread.currentThread().getName() + " have :" + ticket);
			ticket--;
		} 
	}

}
public class WindowTest2_safe2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Window2_safe2 w = new Window2_safe2();

		Thread t1 = new Thread(w);
		Thread t2 = new Thread(w);
		Thread t3 = new Thread(w);

		t1.setName("Window11");
		t2.setName("Window22");
		t3.setName("Window33");

		t1.start();
		t2.start();
		t3.start();
	}

}
