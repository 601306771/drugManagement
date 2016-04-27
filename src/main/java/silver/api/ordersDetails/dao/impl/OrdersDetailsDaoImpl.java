package silver.api.ordersDetails.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import silver.api.ordersDetails.dao.OrdersDetailsDao;
import silver.api.ordersDetails.entity.OrdersDetails;
import silver.api.ordersDetails.mapper.OrdersDetailsMapper;

@Component
public class OrdersDetailsDaoImpl implements OrdersDetailsDao {
	@Autowired
	OrdersDetailsMapper odm;
	
	
	@Override
	public List<OrdersDetails> selectByOcode(String Ocode) {
		return odm.selectByOcode(Ocode);
	}



	@Override
	public int insert(OrdersDetails record) {
		return odm.insert(record);
	}

	@Override
	public int insertSelective(OrdersDetails record) {
		return odm.insertSelective(record);
	}



	@Override
	public int updateByPrimaryKeySelective(OrdersDetails record) {
		return odm.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(OrdersDetails record) {
		return odm.updateByPrimaryKey(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return odm.deleteByPrimaryKey(id);
	}

	@Override
	public OrdersDetails selectByPrimaryKey(Integer id) {
		return odm.selectByPrimaryKey(id);
	}

}
