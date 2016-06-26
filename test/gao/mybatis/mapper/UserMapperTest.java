package gao.mybatis.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import gao.mybatis.po.User;
import gao.mybatis.po.UserCustom;
import gao.mybatis.po.UserQueryVo;

public class UserMapperTest {

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
	public void testFindUserList() throws Exception {
		// 创建会话
		SqlSession session = sqlSessionFactory.openSession();
		// 创建UserMapper对象，由mybatis自动生成mapper代理对象
		UserMapper userMapper = session.getMapper(UserMapper.class);
		// 构造查询的包装类型
		UserCustom userCustom = new UserCustom();
		// 由于这里使用了动态sql，如果不设置某个值，条件不会拼接到sql中
		userCustom.setSex("1");
		userCustom.setUsername("张三");
		// 传入要查询的多个id
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(2);
		ids.add(3);
		UserQueryVo userQueryVo = new UserQueryVo();
		userQueryVo.setUserCustom(userCustom);
		userQueryVo.setIds(ids);
		// 调用方法
		List<UserCustom> users = userMapper.findUserList(userQueryVo);
		// 释放资源
		session.close();
		System.out.println(users);
	}
	
	@Test
	public void testFindUserCount() throws Exception {
		// 创建会话
		SqlSession session = sqlSessionFactory.openSession();
		// 创建UserMapper对象，由mybatis自动生成mapper代理对象
		UserMapper userMapper = session.getMapper(UserMapper.class);
		// 构造查询的包装类型
		UserCustom userCustom = new UserCustom();
		// 由于这里使用了动态sql，如果不设置某个值，条件不会拼接到sql中
		userCustom.setSex("1");
		userCustom.setUsername("张三");
		UserQueryVo userQueryVo = new UserQueryVo();
		userQueryVo.setUserCustom(userCustom);
		// 调用方法
		int count = userMapper.findUserCount(userQueryVo);
		// 释放资源
		session.close();
		System.out.println(count);
	}
	
	@Test
	public void testFindUserById() throws Exception {
		// 创建会话
		SqlSession session = sqlSessionFactory.openSession();
		// 创建UserMapper对象，由mybatis自动生成mapper代理对象
		UserMapper userMapper = session.getMapper(UserMapper.class);
		// 调用方法
		User user = userMapper.findUserById(1);
		// 释放资源
		session.close();
		System.out.println(user);
	}
	
	@Test
	public void testFindUserByIdResultMap() throws Exception {
		// 创建会话
		SqlSession session = sqlSessionFactory.openSession();
		// 创建UserMapper对象，由mybatis自动生成mapper代理对象
		UserMapper userMapper = session.getMapper(UserMapper.class);
		// 调用方法
		User user = userMapper.findUserByIdResultMap(1);
		// 释放资源
		session.close();
		System.out.println(user);
	}

	@Test
	public void testFindUserByName() throws Exception {
		// 创建会话
		SqlSession session = sqlSessionFactory.openSession();
		// 创建UserMapper对象，由mybatis自动生成mapper代理对象
		UserMapper userMapper = session.getMapper(UserMapper.class);
		// 调用方法
		List<User> users = userMapper.findUserByName("张三");
		// 释放资源
		session.close();
		System.out.println(users);
	}

	@Test
	public void testInsertUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteUser() {
		fail("Not yet implemented");
	}

}
