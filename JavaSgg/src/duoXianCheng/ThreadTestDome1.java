/**
 * 
 */
package duoXianCheng;

/**
 * @author ChristinaXinny
 * 2020_09_29 13:25:06
 * 
 * 
 * 练习：创建两个线程 其中一个线程遍历100以内的偶数 另一个遍历一百内奇数
 * 采用第一种 extends来创建线程
 * 
 * 
 * 
 */

class myThread1 extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			if(i%2 == 0) {
				System.out.println(Thread.currentThread().getName()+":  ww"+ i);
			}
		}
	}
	
}
class myThread2 extends Thread{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			if(i%2 != 0) {
				System.out.println(Thread.currentThread().getName()+":  rr"+ i);
			}
		}
	}
	
}
public class ThreadTestDome1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myThread1 t1 = new myThread1();
		myThread2 t2 = new myThread2();
		
		t1.start();
		t2.start();
		
//		也可以用匿名类调用 start
		new Thread() {
		
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					if(i%2 != 0) {
						System.out.println(Thread.currentThread().getName()+":  tt"+ i);
					}
				}
			};
		}.start();
		System.out.println("fffff");
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					if(i%2 == 0) {
						System.out.println(Thread.currentThread().getName()+":  pp"+ i);
					}
				}
			};
		}.start();
		

	}

}
