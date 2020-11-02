/**
 * 
 */
package danLiMoShi;

/**
 * @author ChristinaXinny
 * @date 2020_10_17 10:17:55
 * 
 * 所谓单例模式，就是保证类在内存中只有一个对象
 * 就是设计一个类，它在整个程序中只能有一个该类的实例存在，这就是单例模式。
 * 单例模式的特点：从系统启动到终止，整个过程只会产生一个实例。
 * 
 * 意图：保证一个类仅有一个实例，并提供一个访问它的全局访问点。
主要解决：一个全局使用的类频繁地创建与销毁。
何时使用：当您想控制实例数目，节省系统资源的时候。
如何解决：判断系统是否已经有这个单例，如果有则返回，如果没有则创建。
关键代码：构造函数是私有的。
 * 
 * eg
1、一个班级只有一个班主任。
2、Windows 是多进程多线程的，在操作一个文件的时候，就不可避免地出现多个进程或线程同时操作一个文件的现象，所以所有文件的处理必须通过唯一的实例来进行。
3、一些设备管理器常常设计为单例模式，比如一个电脑有两台打印机，在输出的时候就要处理不能两台打印机打印同一个文件。

 * 
 * ----------------------------------------
 * 单例模式一般有两种实现模式：
 * 
 * 饿汉模式：像一个饿汉一样，不管需不需要用到实例都要去创建实例，即在类产生的时候就创建好实例，这是一种空间换时间的做法。
 * 作为一个饿汉而言，体现了它的本质——“我全都要”。 
 * 
 * 懒汉模式：像一个懒汉一样，需要用到创建实例了程序再去创建实例，不需要创建实例程序就“懒得”去创建实例。
 * 这是一种时间换空间的做法，这体现了“懒汉的本性”。
 * 
 * 
 * 
 * ----------------------------------------
 * 饿汉模式：
 * 他的对象在类产生时候就创建了，一直到程序结束才会去释放。即作为一个单例类实例，它的生存周期和我们的程序一样长。
 * 因此该实例对象需要存储在全局数据区，所以肯定需要使用static来修饰，因为类内部的static成员是不属于每个对象的，而是属于整个类的。
 * 在加载类的时候，我们的实例对象就产生了。所以对于饿汉模式而言，是线程安全的，因为在线程创建之前实例已经被创建好了。
 * 
 * 
 * 懒汉模式
 * 	顾名思义，懒汉模式该只在你需要对象时才会生成单例对象，默认不会实例化，什么时候用什么时候new。
 * 
 * 
 */


/*
 
 应用场景
 网站计数器
 应用程序日志系统
 数据库连接池
 读取文件的类
 Application【进程】
 任务管理器
 回收站
 
 
 */


//饿汉模式
/*
class Singleton {
    //饿汉式单例
    private static Singleton person = new Singleton();
    private Singleton(){}

    public static Singleton getInstance(){
    return person;
    }
}
*/








/*
//懒汉模式   线程不安全

这种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。因为没有加锁 synchronized，所以严格意义上它并不算单例模式。
这种方式 lazy loading 很明显，不要求线程安全，在多线程不能正常工作。
*/

    
/* 
    class Singleton {  
    	//懒汉式单例，只有在调用getInstance时才会实例化一个单例对象
        private static Singleton instance;  
        private Singleton (){}  
      
        public static Singleton getInstance() {  
        if (instance == null) {  //step1
            instance = new Singleton();  //step2
        }  
        return instance;  
        }  
    }
*/
/*   
    非线程安全。假设当前有N个线程同时调用getInstance（）方法，
    由于当前还没有对象生成，所以一部分同时都进入step 2,那么就会由多个线程创建多个多个Singleton对象。
    
    
    
    使用双重锁定的方式解决线程安全问题
*/



//解决线程问题后的代码：
// /*
	class Singleton {
	    //懒汉式单例，只有在调用getInstance时才会实例化一个单例对象
	    public static Singleton user; 
	
	    public static Integer key  = new Integer(4);  //作为一个锁 
	    
	    private Singleton(){}
	
	    public static Singleton getInstance(){
	        //先判断该user变量是否为空，入股为空，进入同步代码块，该步假设为step1
	        if(user == null){    //step 1     
	//        想象一下，如果不判断，那么每次访问这个方法不管该对象是否已经创建都要进入同步代码块，线程数一多，资源消耗也是非常巨大的。
	            synchronized (key) {
	//                由于可能多个线程都进入了step1,由于锁定机制，一个线程进入该代码块时，
	// 其他线程仍在排队进入该代码块，如果不做判断，当前线程即使创造了实例，下一个线程也不知道，就会继续创建一个实例
	                if(user==null){
	                    user = new Singleton();
	                }
	            }
	        }
	        return user;
	    }
	}
//*/



public class ASummary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//分别实例化对象 s1，s2
				Singleton s1 = Singleton.getInstance();
				Singleton s2 = Singleton.getInstance();
				System.out.println(s1 == s2);


	}

}
