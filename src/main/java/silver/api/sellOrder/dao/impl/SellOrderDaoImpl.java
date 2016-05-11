package silver.api.sellOrder.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import silver.api.sellOrder.dao.SellOrderDao;
import silver.api.sellOrder.entity.SellOrder;
import silver.api.sellOrder.mapper.SellOrderMapper;

@Component
public class SellOrderDaoImpl implements SellOrderDao {
	@Autowired
	private SellOrderMapper som;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return som.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SellOrder record) {
		return som.insert(record);
	}

	@Override
	public int insertSelective(SellOrder record) {
		return som.insertSelective(record);
	}

	@Override
	public SellOrder selectByPrimaryKey(Integer id) {
		return som.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(SellOrder record) {
		return som.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SellOrder record) {
		return som.updateByPrimaryKey(record);
	}

	@Override
	public SellOrder selectBySocode(String socode) {
		return som.selectBySocode(socode);
	}

	@Override
	public List<SellOrder> selectByState(String state) {
		return som.selectByState(state);
	}

}
