package gao.mybatis.dao;
import java.util.List;

import gao.mybatis.po.User;
/**
 * 操作数据库接口，原始Dao开发方式
 * @author DELL
 *
 */
public interface UserDao {
	// 根据id查询用户信息
	public User findUserById(int id) throws Exception;
	
	// 根据用户名查询用户列表信息
	public List<User> findUserByName(String name) throws Exception;
	
	// 添加用户信息
	public void insertUser(User user) throws Exception;
	
	// 更新用户信息
	public void updateUser(User user) throws Exception;
	
	// 删除用户信息
	public void deleteUser(int id) throws Exception;
}
