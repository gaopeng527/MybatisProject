package gao.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import gao.mybatis.po.User;
/**
 * 用户操作接口实现类
 * @author DELL
 *
 */
public class UserDaoImpl implements UserDao {

	// 需要注入工厂方法
	private SqlSessionFactory sqlSessionFactory;
	
	// 采用构造方法注入
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public User findUserById(int id) throws Exception {
		// 创建一个连接
		SqlSession session = sqlSessionFactory.openSession();
		User user = session.selectOne("test.findUserById", id);
		// 释放连接
		session.close();
		return user;
	}

	@Override
	public List<User> findUserByName(String name) throws Exception {
		// 创建一个连接
		SqlSession session = sqlSessionFactory.openSession();
		List<User> list = session.selectList("test.findUserByName", name);
		// 释放连接
		session.close();
		return list;
	}
	
	@Override
	public void insertUser(User user) throws Exception {
		// 创建一个连接
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("test.insertUser", user);
		// 提交事务
		session.commit();
		// 释放连接
		session.close();

	}

	@Override
	public void updateUser(User user) throws Exception {
		// 创建一个连接
		SqlSession session = sqlSessionFactory.openSession();
		session.update("test.updateUser", user);
		// 提交事务
		session.commit();
		// 释放连接
		session.close();

	}

	@Override
	public void deleteUser(int id) throws Exception {
		// 创建一个连接
		SqlSession session = sqlSessionFactory.openSession();
		session.delete("test.deleteUser", id);
		// 提交事务
		session.commit();
		// 释放连接
		session.close();

	}


}
