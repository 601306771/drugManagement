package silver.api.orders.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import silver.api.orders.dao.OrdersDao;
import silver.api.orders.entity.Orders;
import silver.api.orders.mapper.OrdersMapper;

@Component
public class OrdersDaoImpl implements OrdersDao {

	@Autowired
	private OrdersMapper om;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return om.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Orders record) {
		return om.insert(record);
	}

	@Override
	public int insertSelective(Orders record) {
		return om.insertSelective(record);
	}

	@Override
	public Orders selectByPrimaryKey(Integer id) {
		return om.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Orders record) {
		return om.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Orders record) {
		return om.updateByPrimaryKey(record);
	}

	@Override
	public List<Orders> selectByState(String state) {
		return om.selectByState(state);
	}

	@Override
	public Orders selectByOcode(String ocode) {
		return om.selectByOcode(ocode);
	}
	
	

}
