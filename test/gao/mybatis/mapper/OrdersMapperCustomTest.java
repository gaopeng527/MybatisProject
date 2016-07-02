package gao.mybatis.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

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
	
	// 测试一级缓存(mybatis默认开启一级缓存)
	@Test
	public void testCache1() throws Exception {
		// 创建会话
		SqlSession session = sqlSessionFactory.openSession();
		// 根据会话创建代理对象
		UserMapper userMapper = session.getMapper(UserMapper.class);
		// 下边的查询使用一个sqlSession（一级缓存是sqlSession级别的）
		// 第一次查询用户id为1的用户
		User user1 = userMapper.findUserById(1);
		System.out.println(user1);
		
		// 如果中间执行了commit操作（即对数据库进行了更新），那么会清空一级缓存
		user1.setAddress("北京");
		userMapper.updateUser(user1);
		// 提交事务
		session.commit();
		
		// 第二次查询用户id为1的用户
		User user2 = userMapper.findUserById(1);
		System.out.println(user2);
	}
	
	// mybatis二级缓存是mapper（命名空间）范围级别，
	// 除了要在SqlMapConfig.xml中设置二级缓存的总开关，
	// 还要在具体的mapper.xml中开启二级缓存
	// 测试二级缓存(mybatis默认不开启)
	@Test
	public void testCache2() throws Exception {
		// 创建会话
		SqlSession session1 = sqlSessionFactory.openSession();
		SqlSession session2 = sqlSessionFactory.openSession();
		SqlSession session3 = sqlSessionFactory.openSession();
		
		// 根据会话创建代理对象
		UserMapper userMapper1 = session1.getMapper(UserMapper.class);
		// 下边的查询使用一个sqlSession（一级缓存是sqlSession级别的）
		// 第一次查询用户id为1的用户
		User user1 = userMapper1.findUserById(1);
		System.out.println(user1);
		// 只有执行关闭操作，SqlSession中的内容才会写入二级缓存
		session1.close();
		
//		// 如果中间执行了commit操作（即对数据库进行了更新），那么会清空二级缓存
//		UserMapper userMapper3 = session3.getMapper(UserMapper.class);
//		User user3 = userMapper3.findUserById(1);
//		user3.setBirthday(new Date());
//		userMapper3.updateUser(user3);
//		// 提交事务
//		session3.commit();	
//		session3.close();
		
		// 第二次查询用户id为1的用户
		UserMapper userMapper2 = session2.getMapper(UserMapper.class);
		User user2 = userMapper2.findUserById(1);
		System.out.println(user2);
		session2.close();

	}

}
