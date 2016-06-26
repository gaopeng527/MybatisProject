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
	public void testFindUserList() throws Exception {
		// �����Ự
		SqlSession session = sqlSessionFactory.openSession();
		// ����UserMapper������mybatis�Զ�����mapper�������
		UserMapper userMapper = session.getMapper(UserMapper.class);
		// �����ѯ�İ�װ����
		UserCustom userCustom = new UserCustom();
		// ��������ʹ���˶�̬sql�����������ĳ��ֵ����������ƴ�ӵ�sql��
		userCustom.setSex("1");
		userCustom.setUsername("����");
		// ����Ҫ��ѯ�Ķ��id
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(2);
		ids.add(3);
		UserQueryVo userQueryVo = new UserQueryVo();
		userQueryVo.setUserCustom(userCustom);
		userQueryVo.setIds(ids);
		// ���÷���
		List<UserCustom> users = userMapper.findUserList(userQueryVo);
		// �ͷ���Դ
		session.close();
		System.out.println(users);
	}
	
	@Test
	public void testFindUserCount() throws Exception {
		// �����Ự
		SqlSession session = sqlSessionFactory.openSession();
		// ����UserMapper������mybatis�Զ�����mapper�������
		UserMapper userMapper = session.getMapper(UserMapper.class);
		// �����ѯ�İ�װ����
		UserCustom userCustom = new UserCustom();
		// ��������ʹ���˶�̬sql�����������ĳ��ֵ����������ƴ�ӵ�sql��
		userCustom.setSex("1");
		userCustom.setUsername("����");
		UserQueryVo userQueryVo = new UserQueryVo();
		userQueryVo.setUserCustom(userCustom);
		// ���÷���
		int count = userMapper.findUserCount(userQueryVo);
		// �ͷ���Դ
		session.close();
		System.out.println(count);
	}
	
	@Test
	public void testFindUserById() throws Exception {
		// �����Ự
		SqlSession session = sqlSessionFactory.openSession();
		// ����UserMapper������mybatis�Զ�����mapper�������
		UserMapper userMapper = session.getMapper(UserMapper.class);
		// ���÷���
		User user = userMapper.findUserById(1);
		// �ͷ���Դ
		session.close();
		System.out.println(user);
	}
	
	@Test
	public void testFindUserByIdResultMap() throws Exception {
		// �����Ự
		SqlSession session = sqlSessionFactory.openSession();
		// ����UserMapper������mybatis�Զ�����mapper�������
		UserMapper userMapper = session.getMapper(UserMapper.class);
		// ���÷���
		User user = userMapper.findUserByIdResultMap(1);
		// �ͷ���Դ
		session.close();
		System.out.println(user);
	}

	@Test
	public void testFindUserByName() throws Exception {
		// �����Ự
		SqlSession session = sqlSessionFactory.openSession();
		// ����UserMapper������mybatis�Զ�����mapper�������
		UserMapper userMapper = session.getMapper(UserMapper.class);
		// ���÷���
		List<User> users = userMapper.findUserByName("����");
		// �ͷ���Դ
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
