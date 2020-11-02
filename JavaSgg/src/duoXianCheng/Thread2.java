/**
 * 
 */
package duoXianCheng;

/**
 * @author ChristinaXinny
 * 2020_09_29 06:53:45
 * 
 * 多线程实现法2:实现Runnable接口
 * 1.创建一个实现Runnable接口的类
 * 2.实现类里面实现一个Runnable中的抽象方法：run（）
 * 3.创建实现类的对象
 * 4.将此对象作为参数传递到Tread类的构造器中，创建Tread类的对象
 * 5.通过Tread类的对象调用start（）
 * 
 * 
 * 例子：WindowTest2
 * 
 * 
 * 比较创建线程的两种方式。
 * 
 */

/*默写一次
class m2 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			if(i%2==0) {
				System.out.println(i);
			}
		}
	}
}

*/



class mTread implements Runnable {

	@Override
	public void run() {
			
		for (int i = 0; i < 100; i++) {
			if (i % 2 ==0) {
				System.out.println(Thread.currentThread().getName() + ":" +i);
			}
		}
	}
	
}


public class Thread2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		创建实现类的对象
		mTread m = new mTread();
//		将此对象作为参数传递到Thread类的构造器 创建Tread对象
		Thread t = new Thread(m);
//		通过创建出的对象 调用start方法 开始线程
		t.start();
//		start()方法
//		1.启动线程   
//		2.调用当前线程的run()--->
//			这个run源码中是调用类一个runnable类型的target的rubn（）
		
//		这里在开启一个线程
		Thread t2 = new Thread(m);
		t2.start();
	}

}
