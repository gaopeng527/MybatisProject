package gao.mybatis.po;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User implements Serializable {
	
	/**
	 * 二级缓存存储介质多种多样，不一定在内存中，所以其对应的pojo类要实现序列化接口
	 */
	private static final long serialVersionUID = 1728545236233563030L;
	private int id;
	private String username;
	private String sex;
	private Date birthday;
	private String address;
	private List<Orders> ordersList; // 订单列表，一个用户可以有多个订单
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", sex=" + sex
				+ ", birthday=" + birthday + ", address=" + address + "]";
	}
	public List<Orders> getOrdersList() {
		return ordersList;
	}
	public void setOrdersList(List<Orders> ordersList) {
		this.ordersList = ordersList;
	}


}
