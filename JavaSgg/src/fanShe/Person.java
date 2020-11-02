/**
 * 
 */
package fanShe;

/**
 * @author ChristinaXinny
 * @date 2020_10_24 18:29:10
 */
public class Person {
	private String name;
	public int age;

	public Person() {
		
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	private Person(String name) {
		this.name = name;
	}
	
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

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	public void show() {
		System.out.println("hello");
	}
	
	private String showN(String n) {
		System.out.println("showN it is " + n);
		return "re: " + n;
	}
	
}
