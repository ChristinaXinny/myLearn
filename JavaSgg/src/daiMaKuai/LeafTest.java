/**
 * 
 */
package daiMaKuai;

/**
 * @author ChristinaXinny
 * @date 2020_10_24 15:39:11
 */

class A{
	static {
		
		System.out.println("A-----s");
	}
	{
		
		System.out.println("A-----f");
	}
	A(){
		System.out.println("A-----g");
	}
}

class B extends A{
	static {
		
		System.out.println("B-----s");
	}
	{
		System.out.println("B-----f");
		
	}
	B(){
		System.out.println("B-----wG");
		
	}
	B(String s){
		this();
		System.out.println("B-----yG");
	}
}
class C extends B{
	static {
		
		System.out.println("C-----s");
	}
	{
		System.out.println("C-----f");
	}
	C(){
		super("dd");
		System.out.println("C-----g");
		
	}
	
}




public class LeafTest {

	public static void main(String[] args) {
		new C();
	}

}

/*
A-----s
B-----s
C-----s
A-----f
A-----g
B-----f
B-----wG
B-----yG
C-----f
C-----g

*/




