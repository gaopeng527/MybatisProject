package gao.mybatis.mapper;

import java.util.List;

import gao.mybatis.po.Orders;
import gao.mybatis.po.OrdersCustom;
import gao.mybatis.po.User;

public interface OrdersMapperCustom {
//	resultType：使用resultType实现较为简单，如果pojo中没有包括查询出来的列名，需要增加列名对应的属性，即可完成映射。
//	如果没有查询结果的特殊要求建议使用resultType。
//	resultMap：需要单独定义resultMap，实现有点麻烦，如果对查询结果有特殊的要求，使用resultMap可以完成将关联查询映射pojo的属性中。
//	resultMap可以实现延迟加载，resultType无法实现延迟加载。
	
	// 查询订单关联查询用户信息（使用resultType）
	public List<OrdersCustom> findOrdersUser() throws Exception;
	
	// 使用resultMap查询订单关联用户信息
	public List<Orders> findOrdersUserResultMap() throws Exception;
	
	// 使用resultMap查询订单关联用户和订单明细信息
	public List<Orders> findOrdersAndOrderdetailResultMap() throws Exception;
	
	// 使用resultMap查询用户关联查询商品信息
	public List<User> findUserAndItemsResultMap() throws Exception;
	
	// 使用resultMap查询订单关联用户，延迟加载用户信息
	public List<Orders> findOrdersUserLazyLoading() throws Exception;
}
