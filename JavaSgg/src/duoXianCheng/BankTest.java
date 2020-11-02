/**
 * 
 */
package duoXianCheng;

/**
 * @author ChristinaXinny
 * @date 2020_10_17 10:48:21
 */
public class BankTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


//懒汉式
class Bank{
	
	private Bank(){};
	private static Bank instance = null;
	
//	public static synchronized Bank getInstance() {
	public static Bank getInstance() {
		
//		法1:
//		效率差：每次一个线程进来时候 都样进行synchronized判断 耗时
//		除了第一个要用到if里面的东西 要new耗时一点 之后的线程只是拿一个创建好的instance
//		synchronized (Bank.class) {
//			if (instance == null) {
//				instance = new Bank();
//			}
//			return instance;
//		}
		
//		法2:效率高些
		if(instance == null) {
			synchronized (Bank.class) {
				if (instance == null) {
					instance = new Bank();
				}
			}
		}
		return instance;
	}
	
	
}
	
