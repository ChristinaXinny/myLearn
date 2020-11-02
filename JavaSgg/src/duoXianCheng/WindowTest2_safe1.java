/**
 * 
 */
package duoXianCheng;

/**
 * @author ChristinaXinny 2020_10_16 16:17:57
 */

class WindowSafe2 implements Runnable {

	private int ticket = 100;

//	private Object obj = new Object();// 法1  这里可以不用写static 因为全程只new了一个window

	@Override
	public void run() {
//		private Object obj = new Object();//不可以咋这里new obj 因为t1 t2 t3 start就会调用一次run 就会new一个obj
//		 无法保证了唯一锁
		while (true) {
//			synchronized (obj) {//法1
			synchronized (this) {//法2 可以用this 因为全程只有一个window w 就只有一个对象 obj=w this就是唯一的windowSate的对象w
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (ticket > 0) {
					System.out.println(Thread.currentThread().getName() + " have :" + ticket);
					ticket--;
				} else {
					break;
				}
			}
		}
	}

}

public class WindowTest2_safe1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WindowSafe2 w = new WindowSafe2();

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
