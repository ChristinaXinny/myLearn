/**
 * 
 */
package duoXianCheng;

/**
 * @author ChristinaXinny
 * 2020_10_12 16:38:51
 */


/*
 * 
 * Thread1:继承Thread类
 * Thread2:继承Runnable接口
 * 
 * ThreadMethod：一些Thread常见方法
 * ThreadTestDome1   练习：创建两个线程 其中一个线程遍历100以内的偶数 另一个遍历一百内奇数  采用第一种 extends来创建线程
 * 
 * 卖票窗口：
 * WindowTest1：不安全的继承Thread方法
 * WindowTest2:不安全的实现Runnable接口的方法
 * 
 * WindowTest1_safe1：安全的Thread--法1实现代码块synchronized
 * WindowTest2_safe1：安全的Runnable--法1实现代码块synchronized
 * 
 * BankTest：单例----懒汉模式 解决线程安全问题
 * 
 * SiSuoWenTi：死锁问题
 * 
 * LockTest：Lock方法解决线程安全问题
 * 
 * AccountTest：同步机制案例 同一账户存钱
 * CommunicationTest：线程通信案例  使用两个线程交替打印1-100数字 
 * ProductTest：线程通信案例
 *
 *	
 * 
---------------------------------------------
 * 
 * 产生线程
 * 1.继承Thread类
 * 2.实现Runnable接口
 * 
 * 解决线程安全问题：
 * 1.Synchronized同步代码块
 * 2.Synchronized同步方法
 * 3.Lock锁
 * 
 * 
 * 
法1:
	继承Thread类
	1。创建一个继承Thread类对子类
	2.重写Thread类法run（）----》 将此线程执行对操作声明在run（）中
	3.创建Thread类对子类对象
	4.通过此对象调用start（）；启动当前线程，调用当前线程对run（）
	
！！：
	1。启动线程 必须调用start（），不能调用run（）对方式启动线程
	2.如果在启动一个线程，必须重新创建一个thread子类对对象，在来调用Start（）
	

	
法2:
	实现Runnable接口 
	
	
两者都要重写run方法 并且都要把要干的事写在run方法里面
最后都要调用start方法来启动线程  并且调用对是同一个start【是在thread类里面的】
	
	
	
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
	
		
		
		
		
法3.	实现Callable接口
	1.创建callable的实现类	
	2.实现call方法，将此线程需要执行的操作声明在call中
	3.创建callable接口实现类的对象
	4.将此Callable接口实现类的对象作为传递到FutrueTask构造器中，创建FutureTask的对象
	5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread的对象，最后调用start（）
	6.【可要可不要，如果对返回值不敢兴趣可以不要】获取Callable中的call方法的返回值
	
	新增方式一:实现Callable 接口
		与使用Runnable 相比,Callable 功能更强大些
			相比run()方法,可以有返回值
			方法可以抛出异常
			支持泛型的返回值
			需要借助Future 类,比如获取返回结果
			
			Future 接口
				可以对具体Runnable 、Callable 任务的执行结果进行取消、查询是否完成、获取结果等。
				Future Task 是Future 接口的唯一的实现类
				Future Task 同时实现了Runnable ,Future 接口。它既可以作为Runnable 被线程执行,又可以作为Future 得到Callable 的返回值


		https://www.cnblogs.com/dolphin0520/p/3949310.html

		
		
---------------------------------------------
线程通信：
	wait（） /notify（）/ notifyAll（）：这个三个方法定义子啊object的类中
	
	
线程的分类：
	1。用户线程：main
	2.守护线程：【垃圾回收的；他依附于main 当main结束时 守护线程会结束
		如果JVM都是守护线程，JVM将退出
	
线程的生命周期：
	新建
	就绪：被start（）之后  具备运行条件 但没有分配CPU资源
	运行：获得CPU资源 run
	堵塞
	死亡
	
	
	【就绪】<---—sleep()时间到/join结束/获取到了同步锁/notify（）notifyAll（）/resume（）—--【阻塞】《---sleep（long time）/join（）/等待同步锁/wait（）/ suspend（挂起）
	
			【就绪】<----失去CPU执行权 或者 调用yield()---【运行】
	【新建】----调用start---->【就绪】---获得CPU执行权--->【运行】
	----——执行完run；或者 调用stop（）或者 出现Error/Exception------->【死亡】
	
	
	
---------------------------------------------------------------------------	

例子：创建买票系统实现runnable接口

1，问题：卖票过程中出现重票【卖出2张33】错票【卖出0票 -1票】--->出现线程安全问题
2.原因：当某个线程操作车票时，尚未操作完成时，其他线程参与进来，耶操作车票
3.如何解决：当一个线程a在操作ticket时，其他线程不能参与进来，直到线程a操作完。即使a出现堵塞 也不可改变
4.在java中实现：同步机制 解决线程安全问题
5. 同步的方法之后 但是速度变慢 在操作代码的部分 就相当与是单线程的过程 效率相当比较慢




	解决安全问题方法：
法1:同步代码块  
	
	synchronized(同步监视器){
		//需要被同步的代码
	}
	
	 1.操作共享数据的代码，既 需要被同步的代码
	 2.共享数据： 多个线程共同操作同一个数据的变量，eg ticket
	 3.同步监视器：就是 锁。 任何一个类的对象，都可以充当锁  在开始就可以直接object obj = new object
	 	！！：多个线程必须是只用一个锁 公用同一把锁！！！锁的唯一性
	 	
	 补充： 在法1 可以是Window1_safe.class来充当对象
	 		法2 可以考虑用this来充当，但如果不止有一个类被调用的话 就不行
	 	
	 	
	 	
法2:同步方法：
	同步方法依然会涉及到同步监视器 只是不用现式的去调用
	private synchronized void show(){//非静态方法 一般调用的同步监视器是this 
		//要执行的代码块
	}
	private static synchronized void show(){//静态方法 一般调用的同步监视器是 当前类本身 
		//要执行的代码块
	}
	
	
法3:Lock锁：jdk5.0新增
1.面试题：synchronized和lock的异同？
	相同：都可以解决线程安全问题
	不同：synchronized是在执行完相应的代码块之后 才会释放同步监视器
		lock：手动启动同步【lock（）】可以根据需要 在任意地释放同步监视器
			但synchronized是自动释放 lock需要人为手动释放【unlock（）】
	实际开发：lock更加灵活 其实两者无区别
	优先使用：lock--->同步代码块----->同步方法
	
2.面试题：如何解决线程安全问题？



法4: 线程池

好比：从南山去到龙华 
		每次去：安装一辆自行车 【创建线程
		到了目的地之后 把车烧了【销毁线程
		过于麻烦
	就有了线程池：
		去：借个共享单车
		到了之后还共享单车
	就相当与 每次创建线程时候 去线程池借一条已经创建好的线程 
	
	背景:经常创建和销毁、使用量特别大的资源,比如并发情况下的线程,对性能影响很大。
	思路:提前创建好多个线程,放入线程池中,使用时直接获取,使用完放回池中。
		可以避免频繁创建销毁、实现重复利用。
		类似生活中的公共交通工具。
	好处:提高响应速度(减少了创建新线程的时间)
		降低资源消耗(重复利用线程池中线程,不需要每次都创建）
		便于线程管理
			corePoolsize :核心池的大小
			maximumPoolSize :最大线程数
			keepAliveTime :线程没有任务时最多保持多长时间后会终止
			
			
			
			
			
线程池相关API： ExecutorService 和 Executors




～～～～～～～
Executor、ExecutorService、Executors三者的区别：---------eor es eors  
https://www.cnblogs.com/whx20100101/p/9862392.html


public interface ExecutorService extends Executor {}
public abstract class AbstractExecutorService implements ExecutorService {}
public interface ScheduledExecutorService extends ExecutorService {}
public class ThreadPoolExecutor extends AbstractExecutorService {}
public class ScheduledThreadPoolExecutor extends ThreadPoolExecutor implements ScheduledExecutorService {}

	1.ExecutorService 接口继承了Executor 接口，是Executor 的子接口。
 
　　2.Executor接口中定义了execute()方法，用来接收一个Runnable接口的对象，
　　  　　 而ExecutorService接口中定义的submit()方法可以接收Runnable和Callable接口对象。
 
　　3.Executor接口中execute()方法不返回任何结果，而ExecutorService接口中submit()方法可以通过一个 Future 对象返回运算结果。
 
　　4.Executor和ExecutorService除了允许客户端提交一个任务，ExecutorService 还提供用来控制线程池的方法。
　　   　　比如：调用 shutDown() 方法终止线程池。
 
　　5.Executors 类提供工厂方法用来创建不同类型的线程池。比如: 
		Executors.newSingleThreadExecutor() 创建一个只有一个线程的线程池，
		Executors.newFixedThreadPool(int numOfThreads)来创建固定线程数的线程池，
		Executors.newCachedThreadPool()创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
		Executors.newScheduledThreadPool(int corePoolSize) 创建一个线程池，它可安排在给定延迟后运行命令或者定期地执行。
～～～～～～


	 
	 
---------------------------------------------------------------------------	
单例-----懒汉模式【本身 不安全 这里主要讲解 如何解决不安全问题，不是说明懒汉式是干啥用的】
解决线程安全问题： 
	 BankTest
	

～～～～～～～～这里科普下 懒汉与饿汉	 
单例模式（Singleton Pattern）是 Java 中最简单的设计模式之一。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。

这种模式涉及到一个单一的类，该类负责创建自己的对象，同时确保只有单个对象被创建。这个类提供了一种访问其唯一的对象的方式，
可以直接访问，不需要实例化该类的对象。	 

1、单例类只能有一个实例。
2、单例类必须自己创建自己的唯一实例。
3、单例类必须给所有其他对象提供这一实例。
	
	
	
饿汉式天生就是线程安全的，可以直接用于多线程而不会出现问题，
饿汉就是类一旦加载，就把单例初始化完成，保证getInstance的时候，单例是已经存在的了。

懒汉式本身是非线程安全的，为了实现线程安全有几种写法。
而懒汉比较懒，只有当调用getInstance的时候，才回去初始化这个单例。
	
---------------------------------------------------------------------------	
	死锁问题：
	不同的程序占用对方的同步资源（锁）都在等待对方放弃
	不会出现异常 只会堵塞
	
	
	
---------------------------------------------------------------------------	

线程通信

https://zhuanlan.zhihu.com/p/129374075

线程通信的目标是使线程间能够互相发送信号。另一方面，线程通信使线程能够等待其他线程的信号。
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
 *【IllegalMonitorStateException：抛出该异常表明某一线程已经试图等待对象的监视器，
 *或者试图通知其他正在等待对象的监视器，然而本身没有指定的监视器的线程。】
 *	3.这三个方法其实是定义在java.Lang.Object类中 
 *
	 面试题：
 	sleep和wait的区别：
 		相同：都可以让线程进入阻塞状态
 		不同：1.两个方法的声明位置不同：sleep在Thread类 wait在Object类
 			 2.调用位置不同：sleep在任意位置 wait只能在同步代码块/同步方法内
 			 3.释放同步监视器：如果都在同步代码块/方法中  sleep不会释放  wait会释放
 			 
 		关于释放与不释放锁：
 			小结释放锁的操作:释放锁的操作
 				1.当前线程的同步方法、同步代码块执行结束。
				2.当前线程在同步代码块、同步方法中遇到break 、return 终止了该代码块、该方法的继续执行。
				3.当前线程在同步代码块、同步方法中出现了未处理的JError 或Exception ,导致异常结束。
				4.当前线程在同步代码块、同步方法中执行了线程对象的wait(方法,当前线程暂停,并释放锁。
				
				 
			小结不会释放锁的操作:不会释放锁的操作
				1.线程执行同步代码块或同步方法时,程序调用Thread .sleep () Thread .yied()方法暂停当前线程的执行
				2.线程执行同步代码块时,其他线程调用了该线程的suspend ()方法将该线程挂起,该线程不会释放锁(同步监视器)
					``应尽量避免使用suspend ()和resume 来控制线程
				 			
 			
 ---------------------------------------------------------------------------	

 Callable、Future和FutureTask：
 
 https://www.cnblogs.com/dolphin0520/p/3949310.html
 
 callable比runnable要强大：
 1.call（）可以返回值
 2.call（）可以抛出异常，在函数外面捕获
 3.Callable是支持泛型
	
	
	
	
	
	
---------------------------------------------------------------------------	
线程池

好比：从南山去到龙华 
		每次去：安装一辆自行车 【创建线程
		到了目的地之后 把车烧了【销毁线程
		过于麻烦
	就有了线程池：
		去：借个共享单车
		到了之后还共享单车
	就相当与 每次创建线程时候 去线程池借一条已经创建好的线程 
	
	背景:经常创建和销毁、使用量特别大的资源,比如并发情况下的线程,对性能影响很大。
	思路:提前创建好多个线程,放入线程池中,使用时直接获取,使用完放回池中。
		可以避免频繁创建销毁、实现重复利用。
		类似生活中的公共交通工具。
	好处:提高响应速度(减少了创建新线程的时间)
		降低资源消耗(重复利用线程池中线程,不需要每次都创建）
		便于线程管理
			corePoolsize :核心池的大小
			maximumPoolSize :最大线程数
			keepAliveTime :线程没有任务时最多保持多长时间后会终止
			
			
			
			
			
线程池相关API： ExecutorService 和 Executors




～～～～～～～
Executor、ExecutorService、Executors三者的区别：---------eor es eors  
https://www.cnblogs.com/whx20100101/p/9862392.html


public interface ExecutorService extends Executor {}
public abstract class AbstractExecutorService implements ExecutorService {}
public interface ScheduledExecutorService extends ExecutorService {}
public class ThreadPoolExecutor extends AbstractExecutorService {}
public class ScheduledThreadPoolExecutor extends ThreadPoolExecutor implements ScheduledExecutorService {}

	1.ExecutorService 接口继承了Executor 接口，是Executor 的子接口。
 
　　2.Executor接口中定义了execute()方法，用来接收一个Runnable接口的对象，
　　  　　 而ExecutorService接口中定义的submit()方法可以接收Runnable和Callable接口对象。
 
　　3.Executor接口中execute()方法不返回任何结果，而ExecutorService接口中submit()方法可以通过一个 Future 对象返回运算结果。
 
　　4.Executor和ExecutorService除了允许客户端提交一个任务，ExecutorService 还提供用来控制线程池的方法。
　　   　　比如：调用 shutDown() 方法终止线程池。
 
　　5.Executors 类提供工厂方法用来创建不同类型的线程池。比如: 
		Executors.newSingleThreadExecutor() 创建一个只有一个线程的线程池，
		Executors.newFixedThreadPool(int numOfThreads)来创建固定线程数的线程池，
		Executors.newCachedThreadPool()创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
		Executors.newScheduledThreadPool(int corePoolSize) 创建一个线程池，它可安排在给定延迟后运行命令或者定期地执行。
～～～～～～



同步&异步：
同步：同一时间只能存在一个线程在工作 其他线程要在线外等待这个线程完成工作后 进入
异步：同一时间 多个线程可以并行 
一个卫生间多个人 ： 同步等待方式 线程：人    线：门
几个人十几个卫生间： 异步  线程：人  一个人上洗手间的同时其他人也可以上其他的洗手间 相互不干扰
 
	
	
	
	
*/
public class AASummary {
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
