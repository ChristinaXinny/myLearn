/**
 * 
 */
package duoXianCheng;

/**
 * 
 * 多线程创建：
 * 法1: 继承与Thread父类
 * 1.创建子类继承与Thread
 * 2.重写run（）方法 -----> 将此线程的操作放到run（）里面执行
 * 3.创建子类的对象
 * 4.对象调用的start（）方法
 * 
 * 
 * @author ChristinaXinny
 * 2020_09_28 11:12:09
 */

class MyThread extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			if(i%2==0) {
				System.out.println("ttttttt: "+i);
				
//				获取线程的名字
//				System.out.println(Thread.currentThread().getName());
//				System.out.println(Thread.currentThread().g );
			}
		}
	}
	
}

public class Thread1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MyThread my = new MyThread();//这里是主线程在做
		my.start();//这里开启了一个新的线程start
//		通过对象调用start方法 1.启动线程 2.调用当前线程的run方法
//		不可用my直接调用run 否则只会是先执行完my对象的run函数以后才会乡下执行下面的操作
		
		
//		不可以直接调用run
//		my.run();
		
		
//		在新建一个线程
		MyThread my2 = new MyThread();
		my2.start();
		
		
		
//		下面的操作是在mian线程中执行
		for (int i = 0; i < 100; i++) {
			if(i%2==0) {
				System.out.println("mmmmmm:" + i);
			}
		}
		System.out.println("Hello");//这里是和start同时开始运行的 是主线程在做
		
	}

}
