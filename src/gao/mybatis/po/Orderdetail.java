package gao.mybatis.po;
/**
 * 订单详细信息
 * @author DELL
 *
 */
public class Orderdetail {
	private int id;
	private int ordersId;
	private int itemsId;
	private int itemsNum; // 商品数量
	private Items items; // 商品信息
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrdersId() {
		return ordersId;
	}
	public void setOrdersId(int ordersId) {
		this.ordersId = ordersId;
	}
	public int getItemsId() {
		return itemsId;
	}
	public void setItemsId(int itemsId) {
		this.itemsId = itemsId;
	}
	public int getItemsNum() {
		return itemsNum;
	}
	public void setItemsNum(int itemsNum) {
		this.itemsNum = itemsNum;
	}
	public Items getItems() {
		return items;
	}
	public void setItems(Items items) {
		this.items = items;
	}
}
