package Coffee.info.dao;

import java.sql.Timestamp;

/**
 * UserOrder entity. @author MyEclipse Persistence Tools
 */

public class UserOrder implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private Integer userid;
	private String orderBusiness;
	private Timestamp orderTime;
	private Short orderState;

	// Constructors

	/** default constructor */
	public UserOrder() {
	}

	/** full constructor */
	public UserOrder(Integer userid, String orderBusiness, Timestamp orderTime,
			Short orderState) {
		this.userid = userid;
		this.orderBusiness = orderBusiness;
		this.orderTime = orderTime;
		this.orderState = orderState;
	}

	// Property accessors

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getOrderBusiness() {
		return this.orderBusiness;
	}

	public void setOrderBusiness(String orderBusiness) {
		this.orderBusiness = orderBusiness;
	}

	public Timestamp getOrderTime() {
		return this.orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}

	public Short getOrderState() {
		return this.orderState;
	}

	public void setOrderState(Short orderState) {
		this.orderState = orderState;
	}

}