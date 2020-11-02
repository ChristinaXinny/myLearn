/**
 * 
 */
package duoXianCheng;

/**
 * @author ChristinaXinny
 * @date 2020_10_18 16:57:52
 * 
 *       线程通信的应用:经典例题:生产者/消费者问题
 * 
 *       生产者( Producer)将产品交给店员(Clerk ),而消费者(Customer客户 / Consumer消费者)从店员处取走产品,
 *       店员一次只能持有固定数量的产品(比如:20),如果生产者试图生产更多的产品,店员
 *       会叫生产者停一下,如果店中有空位放产品了再通知生产者继续生产;如果店中没有产品
 *       了,店员会告诉消费者等一下,如果店中有产品了再通知消费者来取走产品。
 * 
 *       1.是否是多线程？ 是 生产者，消费者 2.公用数据？ 店员（产品） 3.解决？同步代码块/同步方法/lock
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

class Clerk {

	private static int merchandise;
	private static int MAXNUM;

	Clerk(int max) {
		MAXNUM = max;
		merchandise = 0;
	}

	
	public synchronized void merProduct() {
		
		if(merchandise < MAXNUM) {
			merchandise++;
			System.out.println(Thread.currentThread().getName() + " 正在生产第 "+ merchandise +"个");
			
			notify();
		}
		else {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * 
	 */
	public synchronized void merConsume() {
		if(merchandise > 0) {
			System.out.println(Thread.currentThread().getName() + " 正在消费第 "+ merchandise +"个");
			merchandise--;
			
			notify();
		}
		else {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

class Producer extends Thread {

	private Clerk clerk;

	Producer(Clerk clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {

		System.out.println("开始生产。。。");

		while (true) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			clerk.merProduct();

		}

	}

}

class Consumer extends Thread {

	private Clerk clerk;

	Consumer(Clerk clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {
		System.out.println("开始消费。。。");

		while (true) {
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			clerk.merConsume();

		}
	}

	public Clerk getClerk() {
		return clerk;
	}

	public void setClerk(Clerk clerk) {
		this.clerk = clerk;
	}

}

public class ProductTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Clerk cl = new Clerk(20);

		Producer p = new Producer(cl);
		p.setName("producer");

		Consumer c = new Consumer(cl);
		c.setName("consumer");
		
		p.start();
		c.start();
		
		

	}

}
