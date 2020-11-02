/**
 * 
 */
package daiMaKuai;

/**
 * @author ChristinaXinny
 * @date 2020_10_24 14:50:52
 */

/*
 * 1. 代码块对作用：用来初始化 类/对象 
 * 2. 代码块 如果有修饰对话 只能用static 
 * 3. 分类： 静态 vs 非静态
 * 
 * 
 * 4. 静态 
 * 内部可以有输出语句 
 * 随着《类》的加载而执行，而且只执行一次 
 * 如果一个类中定义多个静态 则按照先后顺序执行 
 * 静态 优先级 高于 非静态【先创建类才有对象】 
 * 只能调用静态 不可调用非静态【不管是方法 属性】 
 * 作用：初始化类对信息
 * 
 * 
 * 5. 非静态 
 * 内部可以有输出语句 
 * 随着《对象》的创建而执行 
 * 每创建一个对象就执行一次非静态 
 * 如果一个对象中定义多个静态 则按照先后顺序执行 
 * 能调用静态 非静态【不管是方法 属性】都可以调 
 * 作用：可以在创建对象的时候 对对象对属性进行初始化
 * 
 * 
 * 
 * 
 */
public class BlockTest {
	public static void main(String[] args) {
		String de = Person.de;
		
		Person p1 = new Person();
		System.out.println("*********");
		Person p2 = new Person();
		System.out.println(p1.age);
		Person.fun();
		p2.fun();
	}
}

class Person {
//	属性
	String name;
	int age;
	static int ageS;
	static String de = "ddd";

//	构造器 
	public Person() {

	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
//	代码块
	static {
		System.out.println("static block");
		ageS =22;
	}
	{
		System.out.println("fei block");
		age = 1;
	}
	
	
//	方法
	public void eat() {
		System.out.println("eatttttt");
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	public static void fun() {
		System.out.println("static fun");
	}
	
	
	
	
}
