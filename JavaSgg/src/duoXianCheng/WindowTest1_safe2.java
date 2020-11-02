/**
 * 
 */
package duoXianCheng;

/**
 * @author ChristinaXinny
 * @date 2020_10_16 17:30:29
 */


class Window1_safe2 extends Thread {

	private static int ticket = 100; //这个的话 就是三个窗口总共100张票

	@Override
	public void run() {

		while (true) {
			show();//把要执行的代码块提取出来
		}
	}
	
	//把这个代码块变成一个synchronized方法
//	private synchronized void show() {////这样写 其实同步监视器就相当于this 不可以
	private static synchronized void show() {	//static之后的同步监视器：	Window1_safe2.class 当前类的对象

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (ticket > 0) {
//			System.out.println(getName() + " 卖出的票号是 :" + ticket);这里的getName（）方法不是静态的 所有报错了
			System.out.println(Thread.currentThread().getName() + " 卖出的票号是 :" + ticket);//可以用Thread.currentThread()表示使用的是当前线程的getName
			ticket--;
		} 
	}
}



public class WindowTest1_safe2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Window1_safe2 t1 = new Window1_safe2();
		Window1_safe2 t2 = new Window1_safe2();
		Window1_safe2 t3 = new Window1_safe2();
		
		t1.setName("窗口1");
		t2.setName("窗口2");
		t3.setName("窗口3");
		
		t1.start();
		t2.start();
		t3 .start();
	}

}
