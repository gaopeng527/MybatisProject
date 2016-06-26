package gao.mybatis.mapper;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import gao.mybatis.po.User;
import gao.mybatis.po.UserCustom;
import gao.mybatis.po.UserQueryVo;
/**
 * 操作数据库接口，相当于Dao接口（mapper代理开发）
 * 只有遵循开发规范，mybatis才可以自动生成mapper接口实现类代理对象
 * 开发规范：
 * 1.UserMapper.xml中的namespace要与UserMapper.java一致
 * 2.UserMapper.java方法名要与UserMapper.xml中statement的id一致
 * 3.UserMapper.java方法中的参数类型要与UserMapper.xml中statement的parameterType指定的类型一致
 * 4.UserMapper.java方法中的返回值类型要与UserMapper.xml中statement的resultType指定的类型一致
 * @author DELL
 *
 */
public interface UserMapper {
	// 用户信息的综合查询
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
	
	// 用户信息综合查询总数
	public int findUserCount(UserQueryVo userQueryVo) throws Exception;
	
	// 根据id查询用户信息
	public User findUserById(int id) throws Exception;
	
	// 使用ResultMap作输出映射
	public User findUserByIdResultMap(int id) throws Exception;
	
	// 根据用户名查询用户列表信息
	public List<User> findUserByName(String name) throws Exception;
	
	// 添加用户信息
	public void insertUser(User user) throws Exception;
	
	// 更新用户信息
	public void updateUser(User user) throws Exception;
	
	// 删除用户信息
	public void deleteUser(int id) throws Exception;
}
