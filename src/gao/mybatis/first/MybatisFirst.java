package gao.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import gao.mybatis.po.User;

public class MybatisFirst {

	// ����id��ѯ�û���Ϣ���õ�һ����¼���
	@Test
	public void findUserByIdTest() throws IOException {

		// mybatis�����ļ�
		String resource = "SqlMapConfig.xml";
		// �õ������ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// �����Ự����������mybatis�������ļ���Ϣ
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);

		// ͨ�������õ�SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ͨ��SqlSession�������ݿ�
		// ��һ��������ӳ���ļ���statement��id������=namespace+"."+statement��id
		// �ڶ���������ָ����ӳ���ļ�����ƥ���parameterType���͵Ĳ���
		// sqlSession.selectOne��� ����ӳ���ļ�����ƥ���resultType���͵Ķ���
		// selectOne��ѯ��һ����¼
		User user = sqlSession.selectOne("test.findUserById", 1);

		System.out.println(user);

		// �ͷ���Դ
		sqlSession.close();

	}

	// �����û�����ģ����ѯ�û��б�
	@Test
	public void findUserByNameTest() throws IOException {
		// mybatis�����ļ�
		String resource = "SqlMapConfig.xml";
		// �õ������ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// �����Ự����������mybatis�������ļ���Ϣ
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);

		// ͨ�������õ�SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// list�е�user��ӳ���ļ���resultType��ָ��������һ��
		List<User> list = sqlSession.selectOne("test.findUserByName", "С��");
		System.out.println(list);
		sqlSession.close();

	}

	// ����û���Ϣ
	@Test
	public void insertUserTest() throws IOException {
		// mybatis�����ļ�
		String resource = "SqlMapConfig.xml";
		// �õ������ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// �����Ự����������mybatis�������ļ���Ϣ
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);

		// ͨ�������õ�SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// �����û�����
		User user = new User();
		user.setUsername("��С��");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("����֣��");

		sqlSession.insert("test.insertUser", user);

		// �ύ����
		sqlSession.commit();

		// ��ȡ�û���Ϣ����
		System.out.println(user.getId());
		// �رջỰ
		sqlSession.close();

	}

	// ����idɾ�� �û���Ϣ
	@Test
	public void deleteUserTest() throws IOException {
		// mybatis�����ļ�
		String resource = "SqlMapConfig.xml";
		// �õ������ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// �����Ự����������mybatis�������ļ���Ϣ
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);

		// ͨ�������õ�SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// ����idɾ�� �û�
		sqlSession.delete("test.deleteUser", 39);

		// �ύ����
		sqlSession.commit();

		// �رջỰ
		sqlSession.close();

	}

	// �����û���Ϣ
	@Test
	public void updateUserTest() throws IOException {
		// mybatis�����ļ�
		String resource = "SqlMapConfig.xml";
		// �õ������ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// �����Ự����������mybatis�������ļ���Ϣ
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);

		// ͨ�������õ�SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// �����û���Ϣ
		
		User user = new User();
		//��������id
		user.setId(41);
		user.setUsername("�����");
		user.setBirthday(new Date());
		user.setSex("2");
		user.setAddress("����֣��");

		sqlSession.update("test.updateUser", user);
		
		// �ύ����
		sqlSession.commit();

		// �رջỰ
		sqlSession.close();

	}

}
