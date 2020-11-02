/**
 * 
 */
package jdbc02PreparedStatement;

import java.util.Date;

//import java.sql.Date;

//import javax.xml.crypto.Data;

/**
 * @author ChristinaXinny
 * @date 2020_10_26 10:42:54
 */



/*
 * ORM思想（object relational mapping）
 * 一个数据表对应一个java类
 * 表中的一条数据对应java类的一个对象
 * 表中的一个字段对应java类的一个属性
 */
public class Customer {
	private int id;
	private String name ;
	private String email;
	private Date birth;
	/**
	 * 
	 */
	public Customer() {
		super();
	}
	/**
	 * @param id
	 * @param name
	 * @param email
	 * @param birth
	 */
	public Customer(int id, String name, String email, Date birth) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.birth = birth;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public Date getBirth() {
		return birth;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", birth=" + birth + "]";
	}
	
	

}
