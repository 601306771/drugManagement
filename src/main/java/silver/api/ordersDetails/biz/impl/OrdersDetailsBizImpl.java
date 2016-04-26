package silver.api.ordersDetails.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import silver.api.ordersDetails.biz.OrdersDetailsBiz;
import silver.api.ordersDetails.dao.OrdersDetailsDao;
import silver.api.ordersDetails.entity.OrdersDetails;
import silver.api.ordersDetails.entity.OrdersDetailsKey;
import silver.api.ordersDetails.mapper.OrdersDetailsMapper;

@Service
public class OrdersDetailsBizImpl implements OrdersDetailsBiz {
	@Autowired
	OrdersDetailsDao odd;
	
	
	@Override
	public List<OrdersDetails> selectByOcode(String Ocode) {
		return odd.selectByOcode(Ocode);
	}

	@Override
	public int deleteByPrimaryKey(OrdersDetailsKey key) {
		return odd.deleteByPrimaryKey(key);
	}

	@Override
	public int insert(OrdersDetails record) {
		return odd.insert(record);
	}

	@Override
	public int insertSelective(OrdersDetails record) {
		return odd.insertSelective(record);
	}

	@Override
	public OrdersDetails selectByPrimaryKey(OrdersDetailsKey key) {
		return odd.selectByPrimaryKey(key);
	}

	@Override
	public int updateByPrimaryKeySelective(OrdersDetails record) {
		return odd.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(OrdersDetails record) {
		return odd.updateByPrimaryKey(record);
	}

}
