/**
 * 
 */
package duoXianCheng;

/**
 * @author ChristinaXinny 2020_09_29 12:52:02
 * 
 *    实现Runnable接口 但任然有线程安全问题
 * 
 */

class Window2 implements Runnable {

	private int ticket = 100;

	@Override
	public void run() {
		while (true) {
			
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
			} else {
				break;
			}
		}
	}

}

public class WindowTest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Window2 w = new Window2();

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
