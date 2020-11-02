/**
 * 
 */
package danLiMoShi;

import javax.print.attribute.standard.MediaSize.Other;

/**
 * @author ChristinaXinny
 * @date 2020_10_24 14:06:44
 */
public class singletonTest2 {
	
	public static void main(String[] args) {
		Order o1 = Order.getInc();
		Order o2 = Order.getInc();
		System.out.println(o1 ==o2);
	}

}


//不可以是Bank：
//同一个包下不有相同的class
class Order{
	
	private Order(){
		
	}
	
//	懒汉式 在一开始创建是时候 就不new 
	private static Order inc = null;
	
	public static Order getInc() {
		if(inc == null) {
			inc = new Order();
		}
		return inc;
	}
	
	
}
