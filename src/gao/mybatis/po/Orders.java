package gao.mybatis.po;

import java.util.Date;
import java.util.List;

/**
 * 订单类
 * @author DELL
 *
 */
public class Orders {
	private int id;
	private int userId;
	private String number; // 订单号
	private Date createtime; // 创建时间
	private String note; // 备注
	private User user; // 用户信息，在采用resultMap时使用
	private List<Orderdetail> orderdetails; // 订单明细信息（一个订单可能有多个订单明细）
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "id: "+this.getId()+", userId: "+this.getUserId()+", number: "+this.getNumber()+
				", createtime: "+this.getCreatetime()+", note: "+this.getNote()+
				", username: "+user.getUsername()+", sex: "+user.getSex()+", address: "+user.getAddress();
	}
	public List<Orderdetail> getOrderdetails() {
		return orderdetails;
	}
	public void setOrderdetails(List<Orderdetail> orderdetails) {
		this.orderdetails = orderdetails;
	}
	
}
