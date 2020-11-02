/**
 * 
 */
package duoXianCheng;

/**
 * @author ChristinaXinny
 * @date 2020_10_18 15:53:02
 * 
 * 
 * 线程通信
 *	使用两个线程交替打印1-100数字 
 *
 *	会用到的3个方法：
 *1.wait():一旦执行此方法 当前线程会进入阻塞状态 并且释放同步监视器
 *2.notify():一但执行此方法 会唤醒被wait但随机一个线程 如果有优先级高的 会优先唤醒
 *3.notifyAll():唤醒所有wait的线程
 *
 *	注意：
 *	1.wait(),notify(),notifyAll():这三个方法必须使用在同步代码活同步方法中 不可以用子啊Lock里面
 *	2.这三个方法的调用者必须是同步代码或是同步方法 的同步监视器 否则会出现IllegalMonitorStateException异常
 *【IllegalMonitorStateException：抛出该异常表明某一线程已经试图等待对象的监视器，或者试图通知其他正在等待对象的监视器，然而本身没有指定的监视器的线程。】
 *	3.这三个方法其实是定义在java.Lang.Object类中 
 *
 *
 面试题：
 	sleep和wait的区别：
 		相同：都可以让线程进入阻塞状态
 		不同：1.两个方法的声明位置不同：sleep在Thread类 wait在Object类
 			 2.调用位置不同：sleep在任意位置 wait只能在同步代码块/同步方法内
 			 3.释放同步监视器：如果都在同步代码块/方法中  sleep不会释放  wait会释放
 			
 			
 *
 *
 */

class Number implements Runnable{
	
	private int num = 1;
	
	Object obj = new Object();

	@Override
	public void run() {
		while(true) {
			
			synchronized (this) {
//			synchronized (obj) {//这里的同步监视器不可以是任意对象 因为后面的 
				
				
				if(num <= 100) {
					
//					随机唤醒除自身外的一个线程 
//					唤醒线程之后也进不来 因为本线程拿着监视器
					notify();
//					this.notify();//其实this忽略掉了
					
//					唤醒其他所有线程
//					notifyAll();
					
					try {
//						阻塞的同时 不会释放锁
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					System.out.println(Thread.currentThread().getName() + " : " + num);
					num++;
					
					try {
//						wait: 阻塞的同时 释放锁
						wait();
//						this.wait();//其实this忽略掉了
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				else {
					break;
				}
				
			}
			
		}
		
	}
	
}

public class CommunicationTest {
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Number n = new Number();
		
		Thread t1 = new Thread(n);
		Thread t2 = new Thread(n);
		
		t1.setName("XC1");
		t2.setName("XC2");
		
		t1.start();
		t2.start();

	}

}
