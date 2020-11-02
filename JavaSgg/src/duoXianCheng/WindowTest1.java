/**
 * 
 */
package duoXianCheng;

/**
 * @author ChristinaXinny 
 * 2020_09_29 13:24:25
 */

class Window1 extends Thread {

//	private int ticket = 100;  这个的话 就是三个窗口每个窗口都有100张票
	private static int ticket = 100; //这个的话 就是三个窗口总共100张票

	@Override
	public void run() {

		while (true) {
			if (ticket > 0) {
//				System.out.println(Thread.currentThread().getName() + ":you :" + ticket);
				System.out.println(getName() + ":卖出的票号是 :" + ticket);
				ticket--;
			} else {
				break;
			}
		}
	}
}

public class WindowTest1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Window1 t1 = new Window1();
		Window1 t2 = new Window1();
		Window1 t3 = new Window1();
		
		t1.setName("窗口1：");
		t2.setName("窗口2：");
		t3.setName("窗口3：");
		
		t1.start();
		t2.start();
		t3 .start();
	}

}
