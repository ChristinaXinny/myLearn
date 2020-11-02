/**
 * 
 */
package duoXianCheng;

/**
 * @author ChristinaXinny 2020_10_16 16:19:27
 */
class Window1_safe1 extends Thread {

//	private int ticket = 100;  这个的话 就是三个窗口每个窗口都有100张票
	private static int ticket = 100; // 这个的话 就是三个窗口总共100张票

//	private static Object obj = new Object();//要有一个static 保证锁唯一

	@Override
	public void run() {

		while (true) {
			
//			synchronized (obj) {//法1
//				synchronized (this) {//这里就不可以用this 因为在后面有new3个windowsafe的对象 即对象不唯一 锁不唯一
			
			synchronized (Window1_safe1.class) {//法2 用类充当对象 即充当锁 因为只有一个类 也就保证了锁的唯一性
//				有种写法： Class c = Window1_safe.class 
//				[Class:这是一个类  c：这是类的一个对象  Window1_safe.class：就是被声明为类是c 因为c是对象，所有，也可以看出Window1_safe.class是个对象]
//				Window1_safe.class：这个也是唯一的 因为类Window1_safe只会加载一次 
				
				if (ticket > 0) {

					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//				System.out.println(Thread.currentThread().getName() + ":you :" + ticket);
					System.out.println(getName() + ":卖出的票号是 :" + ticket);
					ticket--;
				} else {
					break;
				}
			}
		}
	}
}

public class WindowTest1_safe1{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Window1_safe1 t1 = new Window1_safe1();
		Window1_safe1 t2 = new Window1_safe1();
		Window1_safe1 t3 = new Window1_safe1();

		t1.setName("窗口1：");
		t2.setName("窗口2：");
		t3.setName("窗口3：");

		t1.start();
		t2.start();
		t3.start();
	}

}
