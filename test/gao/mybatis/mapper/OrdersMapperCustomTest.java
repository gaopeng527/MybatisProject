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

	// �Ự����
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void setUp() throws Exception {
		// mybatis�����ļ�
		String resource = "SqlMapConfig.xml";
		// �õ������ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// �����Ự����������mybatis�������ļ���Ϣ
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindOrdersUser() throws Exception {
		// �����Ự
		SqlSession session = sqlSessionFactory.openSession();
		// ���ݻỰ�����������
		OrdersMapperCustom ordersMapperCustom = session.getMapper(OrdersMapperCustom.class);
		// ���в�ѯ(���ص��ֶ�����OrdersCustom��������һ��ʱ�ſ������ӳ��Ϊ���Ը�ֵ��
		List<OrdersCustom> ordersCustoms = ordersMapperCustom.findOrdersUser();
		// �ͷ���Դ
		session.close();
		System.out.println(ordersCustoms);
	}
	
	@Test
	public void testFindOrdersUserResultMap() throws Exception {
		// �����Ự
		SqlSession session = sqlSessionFactory.openSession();
		// ���ݻỰ�����������
		OrdersMapperCustom ordersMapperCustom = session.getMapper(OrdersMapperCustom.class);
		// ���в�ѯ(���ص��ֶ�����OrdersCustom��������һ��ʱ�ſ������ӳ��Ϊ���Ը�ֵ��
		List<Orders> ordersList = ordersMapperCustom.findOrdersUserResultMap();
		// �ͷ���Դ
		session.close();
		System.out.println(ordersList);
	}
	
	@Test
	public void testfindOrdersAndOrderdetailResultMap() throws Exception {
		// �����Ự
		SqlSession session = sqlSessionFactory.openSession();
		// ���ݻỰ�����������
		OrdersMapperCustom ordersMapperCustom = session.getMapper(OrdersMapperCustom.class);
		// ���в�ѯ(���ص��ֶ�����OrdersCustom��������һ��ʱ�ſ������ӳ��Ϊ���Ը�ֵ��
		List<Orders> ordersList = ordersMapperCustom.findOrdersAndOrderdetailResultMap();
		// �ͷ���Դ
		session.close();
		System.out.println(ordersList);
	}
	
	@Test
	public void testfindUserAndItemsResultMap() throws Exception {
		// �����Ự
		SqlSession session = sqlSessionFactory.openSession();
		// ���ݻỰ�����������
		OrdersMapperCustom ordersMapperCustom = session.getMapper(OrdersMapperCustom.class);
		// ���в�ѯ
		List<User> users = ordersMapperCustom.findUserAndItemsResultMap();
		// �ͷ���Դ
		session.close();
		System.out.println(users);
	}
	
	@Test
	public void testfindOrdersUserLazyLoading() throws Exception {
		// �����Ự
		SqlSession session = sqlSessionFactory.openSession();
		// ���ݻỰ�����������
		OrdersMapperCustom ordersMapperCustom = session.getMapper(OrdersMapperCustom.class);
		// ��ѯ������Ϣ������
		List<Orders> ordersList = ordersMapperCustom.findOrdersUserLazyLoading();
		// ������ѯ���Ķ����б�
		for(Orders orders:ordersList){
			// ִ��getUser()������ʵ�ְ�������û���Ϣ
			User user = orders.getUser();
			System.out.println(user);
		}
		// �ͷ���Դ
		session.close();
		System.out.println(ordersList);
	}
	
	// ����һ������(mybatisĬ�Ͽ���һ������)
	@Test
	public void testCache1() throws Exception {
		// �����Ự
		SqlSession session = sqlSessionFactory.openSession();
		// ���ݻỰ�����������
		UserMapper userMapper = session.getMapper(UserMapper.class);
		// �±ߵĲ�ѯʹ��һ��sqlSession��һ��������sqlSession����ģ�
		// ��һ�β�ѯ�û�idΪ1���û�
		User user1 = userMapper.findUserById(1);
		System.out.println(user1);
		
		// ����м�ִ����commit�������������ݿ�����˸��£�����ô�����һ������
		user1.setAddress("����");
		userMapper.updateUser(user1);
		// �ύ����
		session.commit();
		
		// �ڶ��β�ѯ�û�idΪ1���û�
		User user2 = userMapper.findUserById(1);
		System.out.println(user2);
	}
	
	// mybatis����������mapper�������ռ䣩��Χ����
	// ����Ҫ��SqlMapConfig.xml�����ö���������ܿ��أ�
	// ��Ҫ�ھ����mapper.xml�п�����������
	// ���Զ�������(mybatisĬ�ϲ�����)
	@Test
	public void testCache2() throws Exception {
		// �����Ự
		SqlSession session1 = sqlSessionFactory.openSession();
		SqlSession session2 = sqlSessionFactory.openSession();
		SqlSession session3 = sqlSessionFactory.openSession();
		
		// ���ݻỰ�����������
		UserMapper userMapper1 = session1.getMapper(UserMapper.class);
		// �±ߵĲ�ѯʹ��һ��sqlSession��һ��������sqlSession����ģ�
		// ��һ�β�ѯ�û�idΪ1���û�
		User user1 = userMapper1.findUserById(1);
		System.out.println(user1);
		// ֻ��ִ�йرղ�����SqlSession�е����ݲŻ�д���������
		session1.close();
		
//		// ����м�ִ����commit�������������ݿ�����˸��£�����ô����ն�������
//		UserMapper userMapper3 = session3.getMapper(UserMapper.class);
//		User user3 = userMapper3.findUserById(1);
//		user3.setBirthday(new Date());
//		userMapper3.updateUser(user3);
//		// �ύ����
//		session3.commit();	
//		session3.close();
		
		// �ڶ��β�ѯ�û�idΪ1���û�
		UserMapper userMapper2 = session2.getMapper(UserMapper.class);
		User user2 = userMapper2.findUserById(1);
		System.out.println(user2);
		session2.close();

	}

}
