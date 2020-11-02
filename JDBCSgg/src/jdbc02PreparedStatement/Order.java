/**
 * 
 */
package jdbc02PreparedStatement;

import java.sql.Date;

/**
 * @author ChristinaXinny
 * @date 2020_10_26 15:47:12
 */
public class Order {

	 private int orderId;
	 private String orderName;
	 private Date orderDate;
	/**
	 * 
	 */
	public Order() {
		super();
	}
	/**
	 * @param orderId
	 * @param orderName
	 * @param orderDate
	 */
	public Order(int orderId, String orderName, Date orderDate) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
		this.orderDate = orderDate;
	}
	public int getOrderId() {
		return orderId;
	}
	public String getOrderName() {
		return orderName;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderName=" + orderName + ", orderDate=" + orderDate + "]";
	}
	 
	
}
