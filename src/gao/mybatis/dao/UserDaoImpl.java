package gao.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import gao.mybatis.po.User;
/**
 * �û������ӿ�ʵ����
 * @author DELL
 *
 */
public class UserDaoImpl implements UserDao {

	// ��Ҫע�빤������
	private SqlSessionFactory sqlSessionFactory;
	
	// ���ù��췽��ע��
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public User findUserById(int id) throws Exception {
		// ����һ������
		SqlSession session = sqlSessionFactory.openSession();
		User user = session.selectOne("test.findUserById", id);
		// �ͷ�����
		session.close();
		return user;
	}

	@Override
	public List<User> findUserByName(String name) throws Exception {
		// ����һ������
		SqlSession session = sqlSessionFactory.openSession();
		List<User> list = session.selectList("test.findUserByName", name);
		// �ͷ�����
		session.close();
		return list;
	}
	
	@Override
	public void insertUser(User user) throws Exception {
		// ����һ������
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("test.insertUser", user);
		// �ύ����
		session.commit();
		// �ͷ�����
		session.close();

	}

	@Override
	public void updateUser(User user) throws Exception {
		// ����һ������
		SqlSession session = sqlSessionFactory.openSession();
		session.update("test.updateUser", user);
		// �ύ����
		session.commit();
		// �ͷ�����
		session.close();

	}

	@Override
	public void deleteUser(int id) throws Exception {
		// ����һ������
		SqlSession session = sqlSessionFactory.openSession();
		session.delete("test.deleteUser", id);
		// �ύ����
		session.commit();
		// �ͷ�����
		session.close();

	}


}
