/**
 * 
 */
package duoXianCheng;

/**
 * @author ChristinaXinny
 * 2020_09_29 13:40:22
 * 
 * Thread常见方法
 * 1.start()：启动当前线程 调用当前线程的run（）
 * 2.run()：通常需要重写run  将要次线程执行的操作写在run里面
 * 3.currentThread()：静态方法  返回当前线程
 * 4.getName()：获取当前线程的名字
 * 5.setName()：设置当前线程名字
 * 6.yield():  释放当前CPU正在执行的线程  停止当前线程 让他休息一会 
 * 7.join()： 在线程1中调用线程2的join（） 此时线程1 就进入阻塞状态 直到线程2完全执行完只会 线程1
 * 				才结束阻塞状态
 * 8.stop() :已过时
 * 9.sleep(s):让当前线程睡眠 即每s秒执行一次
 * 
 * 
 * 两种创建线程的方式：
 * 优先选择：实现Runnable接口的方式
 * 1.实现的方式没有类的单继承性的局限性
 * 2.实现的方式更加适合来处理多个线程共享数据的情况
 * 两种之间的联系：
 *  因为本身上来说Thread类在源文件中就是实现runnable接口的 其thread类里面的
 *  run函数也是重写了runnable的run函数
 *  那么不如直接在需要的时候创建一个直接实现runnable接口的类 不用通过
 *  thread父类来重写run函数
 *  两种方式都重写了run方法
 * 
 * 
 */
class TMethod extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			if(i%2 == 0) {
//				MAX_PRIORITY
//				MIN_PRIORITY
//				NORM_PRIORITY
				try {
					sleep(100);
					//这里的异常不可以在run那被抛出  
//					因为run为重写的 父类没有异常抛出 子类的异常不可以比父类大
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+": "+ i);
				System.out.println(getName()+": "+ i);//在线程的类里面可以直接写getName
			}
//			if( i % 20 == 0) {
////				上下两种等价的 this === currentThread（）
////				直接调用yield（）可以
////				this.yield();//该线程的对象 调用yield（）
// 				yield();
//			}
		}		
	}
}

public class ThreadMethod {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		TMethod t1 = new TMethod();
		t1.start();
//		给主线程命名
		Thread.currentThread().setName("主线程：");
		for (int i = 0; i < 50; i++) {
			if(i%2 == 0) {
				System.out.println(Thread.currentThread().getName()+":   "+ i);
			}
			if (i==20) {
				try {
					t1.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
