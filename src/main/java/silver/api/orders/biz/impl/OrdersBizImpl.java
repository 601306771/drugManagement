package silver.api.orders.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import silver.api.orders.biz.OrdersBiz;
import silver.api.orders.dao.OrdersDao;
import silver.api.orders.entity.Orders;

@Service
public class OrdersBizImpl implements OrdersBiz {
	
	@Autowired
	private OrdersDao od ;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return od.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Orders record) {
		return od.insert(record);
	}

	@Override
	public int insertSelective(Orders record) {
		return od.insertSelective(record);
	}

	@Override
	public Orders selectByPrimaryKey(Integer id) {
		return od.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Orders record) {
		return od.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Orders record) {
		return od.updateByPrimaryKey(record);
	}

	@Override
	public List<Orders> selectByState(String state) {
		return od.selectByState(state);
	}

	@Override
	public Orders selectByOcode(String ocode) {
		return od.selectByOcode(ocode);
	}

}
