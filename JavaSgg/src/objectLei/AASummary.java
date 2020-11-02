/**
 * 
 */
package objectLei;

/**
 * @author ChristinaXinny
 * @date 2020_10_24 08:15:33
 */




/*

BlockTest：类中代码块







//-------------------------------------------
 * 
面试题：
	== 与 equals()
		
==的使用
	1.可以使用在基本数据类型变量和引用数据类型变量中
	2.如果比较的是基本数据类型变量，比较两个变量保存的数据是否相等（不一定是类型一要相等
				引用数据类型			两个对象的地址值是否相同【即指向的是不是同一个地址

!!

equal()的使用
1. 是一个方法 
2. 只能适用于引用数据类型
3. Object类中的equal（）的定义
	 public boolean equals(Object obj) {
        return (this == obj);
    }
	Object类中的定义equal方法 和 == 是一样的 比较的是两个对象啊的地址是否相同 
4.像是String Data File 包装类 都重写了equal的方法 
重写之后 比较的是两个对象的世纪内容 而不是是否指向同一处地址 


自定义类重写
可以看人家String的equal怎么写的

public boolean equals(Object anObject) {
    if (this == anObject) {
        return true;
    }
    if (anObject instanceof String) {
        String aString = (String)anObject;
        if (coder() == aString.coder()) {
            return isLatin1() ? StringLatin1.equals(value, aString.value)
                              : StringUTF16.equals(value, aString.value);
        }
    }
    return false;
}

！！！
if x.equal(y)-----true
		y.equal(x)-----true

x.equal(x)-----t

if  x.equal(y)-----true &&  y.equal(z)-----true
		z.equal(x) ------ t
x.equal(null)----false [ever]


//--------------------------------------------------------------------------


对属性对赋值：
1.默认初始化
2.显示初始化
3.构造器初始化
4.有了对象之后 通过‘对象.属性‘或是’对象.方法‘进行赋值
5.在代码块中赋值
【代码块比构造器优先级高】

类里面 
main执行之前 有static静态代码块 会先调用静态代码块 才到main





//-------------------代码块-------------------------------------------------------
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



 */



public class AASummary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
