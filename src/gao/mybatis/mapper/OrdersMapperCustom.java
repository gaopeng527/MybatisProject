package gao.mybatis.mapper;

import java.util.List;

import gao.mybatis.po.Orders;
import gao.mybatis.po.OrdersCustom;
import gao.mybatis.po.User;

public interface OrdersMapperCustom {
//	resultType��ʹ��resultTypeʵ�ֽ�Ϊ�򵥣����pojo��û�а�����ѯ��������������Ҫ����������Ӧ�����ԣ��������ӳ�䡣
//	���û�в�ѯ���������Ҫ����ʹ��resultType��
//	resultMap����Ҫ��������resultMap��ʵ���е��鷳������Բ�ѯ����������Ҫ��ʹ��resultMap������ɽ�������ѯӳ��pojo�������С�
//	resultMap����ʵ���ӳټ��أ�resultType�޷�ʵ���ӳټ��ء�
	
	// ��ѯ����������ѯ�û���Ϣ��ʹ��resultType��
	public List<OrdersCustom> findOrdersUser() throws Exception;
	
	// ʹ��resultMap��ѯ���������û���Ϣ
	public List<Orders> findOrdersUserResultMap() throws Exception;
	
	// ʹ��resultMap��ѯ���������û��Ͷ�����ϸ��Ϣ
	public List<Orders> findOrdersAndOrderdetailResultMap() throws Exception;
	
	// ʹ��resultMap��ѯ�û�������ѯ��Ʒ��Ϣ
	public List<User> findUserAndItemsResultMap() throws Exception;
	
	// ʹ��resultMap��ѯ���������û����ӳټ����û���Ϣ
	public List<Orders> findOrdersUserLazyLoading() throws Exception;
}
