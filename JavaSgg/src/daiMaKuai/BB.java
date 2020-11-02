/**
 * 
 */
package daiMaKuai;

/**
 * @author ChristinaXinny
 * @date 2020_10_24 15:44:35
 */


class AA{
	static {
		
		System.out.println("A-----s");
	}
	{
		
		System.out.println("A-----f");
	}
	AA(){
		System.out.println("A-----g");
	}
}

public class BB extends AA{
	static {
		
		System.out.println("B-----s");
	}
	{
		System.out.println("B-----f");
		
	}
	BB(){
		System.out.println("B-----wG");
		
	}
	BB(String s){
		this();
		System.out.println("B-----yG");
	}
	public static void main(String[] args) {
		System.out.println("B-----main");
		System.out.println("**************");
		new BB();
		System.out.println("**************");
		new BB();
		System.out.println("**************");
		new AA();
	}
}

/*


A-----s
B-----s
B-----main
**************
A-----f
A-----g
B-----f
B-----wG
**************
A-----f
A-----g
B-----f
B-----wG
**************
A-----f
A-----g

 * 
 */
 
