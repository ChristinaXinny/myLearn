/**
 * 
 */
package fanShe;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

/**
 * @author ChristinaXinny
 * @date 2020_10_24 18:28:02
 */

public class ReflectionTest {

//	反射之前 可以的操作
	@Test
	public void rtest1() {

//		1.创建person的对象
		Person p = new Person("Tom", 12);

//		2.通过对象 调用内部属性，方法
		p.age = 10;
		System.out.println(p.toString());

		p.show();

//		在person外部不可以调用私有的属性 方法 构造器

	}

//	反射之后
	@Test
	public void rtest2() throws Exception {
		Class<Person> clazz = Person.class;

//		1.通过反射 创建person对象
		Constructor<Person> cons = clazz.getConstructor(String.class, int.class);
		Object obj = cons.newInstance("Tom", 13);
		Person p = (Person) obj;// 强转类型转换
		System.out.println(p.toString());

//		2.通过反射 调用对象指定的属性 方法
//		调用属性
		Field a = clazz.getDeclaredField("age");
		a.set(p, 10);
		System.out.println(p.toString());
//		调用方法
		Method show = clazz.getDeclaredMethod("show");
		show.invoke(p);

//		同过反射 调用私有的属性 方法 构造器
//		调用构造器
		Constructor<Person> cons1 = clazz.getDeclaredConstructor(String.class);
		cons1.setAccessible(true);
		Person p1 = (Person) cons1.newInstance("jeni");
		System.out.println(p1);

//		调用私有属性
		Field name = clazz.getDeclaredField("name");
		name.setAccessible(true);
		name.set(p1, "han");
		System.out.println(p1);

//		调用私有方法
		Method showNaa = clazz.getDeclaredMethod("showNaa", String.class);
		showNaa.setAccessible(true);
		showNaa.invoke(p1, "zzNaa");

	}

//	获取Class实例的方法
	@Test
	public void test3() throws ClassNotFoundException {
//		法1.调用运行时类的属性：Class
		Class clazz1 = Person.class;
		System.out.println(clazz1);

//		法2.通过运行时类的对象 调用getClass（）
		Person p = new Person();
		Class clazz2 = p.getClass();
		System.out.println(clazz2);

//		法3.调用Class静态方法：forName（String ClassPath）类的路径
		Class clazz3 = Class.forName("fanShe.Person");
//		clazz3 = Class.forName("java.lang.String");
		System.out.println(clazz3);

		System.out.println(clazz1 == clazz2);// true
		System.out.println(clazz1 == clazz3);// t
//		这三个clazz1 2 3均指向同一个运行时类

//		法4.使用类的加载器：ClassLoader
		ClassLoader cl = ReflectionTest.class.getClassLoader();
		Class clazz4 = cl.loadClass("fanShe.Person");// person的路径
		System.out.println(clazz4);

	}

	@Test
	public void test4() {
		Class c1 = Object.class ;
		Class c2 = Comparable.class ;
		Class c3  =String[].class ;
		Class c4 = int[][].class ;
		Class c5 = ElementType.class ;
		Class c6 =  Override.class;
		Class c7 =int.class ;
		Class c8  =void.class ;
		Class c9 = Class.class ;
		int[] a =  new int [10];
		int[] b = new int [ 100];
		Class c10 =  a.getClass();
		Class c11 = b.getClass();
//		只要数组的元素类型与维度一样,就是同一个Class
		System.out.println (c10== c11 );//t
		
	}

}
