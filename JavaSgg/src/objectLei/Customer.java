/**
 * 
 */
package objectLei;

/**
 * @author ChristinaXinny
 * @date 2020_10_24 08:24:07
 */
public class Customer {
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @param name
	 * @param age
	 */
	public Customer(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	/**
	 * 
	 */
	public Customer() {
		super();
	}
	
	
	 
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
	        return true;
	    }
		if(obj instanceof Customer) {
			Customer cust = (Customer)obj;
//			这里要强转一波 因为传递进来的 参数是object类的 无法访问到customer类里面的name  age
			
//			if(this.age == cust.age && this.name.equals(cust.name)) {
////				这里的name也是 不可以直接用==  要equal
//				return true;
//			}
//			else {
//				return false;
//			}
			
			return this.age == cust.age && this.name.equals(cust.name);
		}
		return false;
	}

}
