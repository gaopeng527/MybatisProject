package gao.mybatis.po;

import java.util.List;

/**
 * 用户包装类型，在这里包装所需要的查询条件
 * @author DELL
 *
 */
public class UserQueryVo {

	// 传入多个id
	private List<Integer> ids;
	
	// 用户查询条件
	private UserCustom userCustom;

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	
	// 可以包装其他查询条件，比如订单、商品
	// ...
}
