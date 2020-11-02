/**
 * 
 */
package duoXianCheng;


/**
 * @author ChristinaXinny
 * @date 2020_10_17 19:27:56
 * 
 * 有一个账户 两个用户向同一个账户里面存钱 
 * 一人存3000 每次存1000 分为3次存
 * 每次存完打印余额
 * 
 * 
 * 分析：
 * 1.是否是多线程问题？是 2个用户
 * 2.是多线程就一定有安全问题？ 不 有无安全问题取决于是否有‘共享数据’
 * 3.有共享数据？ 有 账户
 * 4.有安全问题 ？ 有 
 * 5.考虑如何解决？同步机制 三种方法
 *  
 * 
 * 
 */

class  Account{
	
	private double balance;
	
	public Account(double balance){
		this.balance = balance;
	}
	
//	存钱方法：
	public synchronized void deposit(double amt) {
//	public void deposit(double amt) {
		if(amt>0) {
			balance += amt;
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(Thread.currentThread().getName() + " 存钱了 现在余额有： "+balance);
			
		}
	}
	
	
	
}
class Customer extends Thread {
	
	private Account acct;
	
	public Customer(Account acct) {
		this.acct = acct;
	}
	
	
	
	@Override
	public void run() {
		for (int i=0; i<3;i++) {
			acct.deposit(1000);
		}
		
	}



	
}






public class AccountTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Account acct = new Account(0);
		Customer c1 = new Customer(acct);
		Customer c2 = new Customer(acct);
		
		c1.setName("cst1");
		c2.setName("cst2");
		
		c1.start();
		c2.start();
	}

}
