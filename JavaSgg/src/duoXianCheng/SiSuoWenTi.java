/**
 * 
 */
package duoXianCheng;

/**
 * @author ChristinaXinny
 * @date 2020_10_17 11:05:25
 * 
 * 我们使用同步时 要避免死锁现象 
 * 
 * 解决：
 * 专门的算法 原则
 * 尽量减少同步资源的定义
 * 尽量减少嵌套同步
 * 
 * 
 * 
 */
public class SiSuoWenTi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		StringBuffer s1 = new StringBuffer();
		StringBuffer s2 = new StringBuffer();

		
		new Thread(){
			
		}  .start();
		
		
//		匿名继承方式 
		new Thread() {
			@Override
			public void run() {
				
//				这个线程 先拿着s1这个锁进入后
				synchronized (s1) {
					s1.append("a");
					s2.append("1");
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
//					得在拿到s2这个锁才能执行到后面的
					synchronized (s2) {
						s1.append("b");
						s2.append("2");
						
						System.out.println(s1);
						System.out.println(s2);
					}
				}

			
			}
		}.start();
		
		
		
//		匿名实现runnable接口
		new Thread(new Runnable() {
			
			@Override
			public void run() {
//				这个线程 先拿着s2这个锁进入后
				synchronized (s2) {
					s1.append("c");
					s2.append("3");
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
//					得在拿到s1这个锁才能执行到后面的
					synchronized (s1) {
						s1.append("d");
						s2.append("4");
						
						System.out.println(s1);
						System.out.println(s2);
					}
				}
			}
		}).start();
	}

}
