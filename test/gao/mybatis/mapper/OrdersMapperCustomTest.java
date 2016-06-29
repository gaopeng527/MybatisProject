package gao.mybatis.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import gao.mybatis.po.Orders;
import gao.mybatis.po.OrdersCustom;
import gao.mybatis.po.User;

public class OrdersMapperCustomTest {

	// 会话工厂
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void setUp() throws Exception {
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建会话工厂，传入mybatis的配置文件信息
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindOrdersUser() throws Exception {
		// 创建会话
		SqlSession session = sqlSessionFactory.openSession();
		// 根据会话创建代理对象
		OrdersMapperCustom ordersMapperCustom = session.getMapper(OrdersMapperCustom.class);
		// 进行查询(返回的字段名与OrdersCustom的属性名一致时才可以完成映射为属性赋值）
		List<OrdersCustom> ordersCustoms = ordersMapperCustom.findOrdersUser();
		// 释放资源
		session.close();
		System.out.println(ordersCustoms);
	}
	
	@Test
	public void testFindOrdersUserResultMap() throws Exception {
		// 创建会话
		SqlSession session = sqlSessionFactory.openSession();
		// 根据会话创建代理对象
		OrdersMapperCustom ordersMapperCustom = session.getMapper(OrdersMapperCustom.class);
		// 进行查询(返回的字段名与OrdersCustom的属性名一致时才可以完成映射为属性赋值）
		List<Orders> ordersList = ordersMapperCustom.findOrdersUserResultMap();
		// 释放资源
		session.close();
		System.out.println(ordersList);
	}
	
	@Test
	public void testfindOrdersAndOrderdetailResultMap() throws Exception {
		// 创建会话
		SqlSession session = sqlSessionFactory.openSession();
		// 根据会话创建代理对象
		OrdersMapperCustom ordersMapperCustom = session.getMapper(OrdersMapperCustom.class);
		// 进行查询(返回的字段名与OrdersCustom的属性名一致时才可以完成映射为属性赋值）
		List<Orders> ordersList = ordersMapperCustom.findOrdersAndOrderdetailResultMap();
		// 释放资源
		session.close();
		System.out.println(ordersList);
	}
	
	@Test
	public void testfindUserAndItemsResultMap() throws Exception {
		// 创建会话
		SqlSession session = sqlSessionFactory.openSession();
		// 根据会话创建代理对象
		OrdersMapperCustom ordersMapperCustom = session.getMapper(OrdersMapperCustom.class);
		// 进行查询
		List<User> users = ordersMapperCustom.findUserAndItemsResultMap();
		// 释放资源
		session.close();
		System.out.println(users);
	}
	
	@Test
	public void testfindOrdersUserLazyLoading() throws Exception {
		// 创建会话
		SqlSession session = sqlSessionFactory.openSession();
		// 根据会话创建代理对象
		OrdersMapperCustom ordersMapperCustom = session.getMapper(OrdersMapperCustom.class);
		// 查询订单信息（单表）
		List<Orders> ordersList = ordersMapperCustom.findOrdersUserLazyLoading();
		// 遍历查询出的订单列表
		for(Orders orders:ordersList){
			// 执行getUser()方法，实现按需加载用户信息
			User user = orders.getUser();
			System.out.println(user);
		}
		// 释放资源
		session.close();
		System.out.println(ordersList);
	}

}
