/**
 * 
 */
package danLiMoShi;

/**
 * @author ChristinaXinny
 * @date 2020_10_24 13:42:57
 */




//单例设计模式：
// 保证程序从始至终都只生成一个实例对象
//因此在类 里面会把所有都设置为private
//那要如何创建一个对象
//就只能是用类都本身来调用
//想要用类可以调用的 就只有是static的方法或是变量【属性】
//ps：原来变量就是属性的意思


//如果是想调用类里面的属性时候 怎么办？【毕竟不是所有的属性都会设成是static 
//那就只能是在类里面去创建一个对象
//在用一个方法设成是public 来get到这个对象 从而可以去调用类的属性

public class SingletonTest1 {

	
	

	public static void main(String[] args) {
		 Bank b1 = Bank.getInc();
		 Bank b2 = Bank.getInc();
//		  这里的b1和b2就为同一个对象 就是类内部创建的那个对象
		 
		 System.out.println(b1==b2);
		 
	}

}

class Bank{
	
//	1.私有化类的构造器
	private Bank() {
		
	}
	
//	2.内部创建类的对象
//	private Bank inc = new Bank();
	private static Bank inc = new Bank();
	
//	3.提供public方法 返回对象
//	public Bank getInc() {//如果仅仅是这样就会造成一个后果 想要调用这个方法 只能先创建一个对象 然而这个方法就是为了创建对象的
	public static Bank getInc() {
	
		return inc;
	}
	
	
}
