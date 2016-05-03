package silver.api.sellOrder.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import silver.api.sellOrder.biz.SellOrderBiz;
import silver.api.sellOrder.dao.SellOrderDao;
import silver.api.sellOrder.entity.SellOrder;

@Service
public class SellOrderBizImpl implements SellOrderBiz{
	@Autowired
	private SellOrderDao sod;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return sod.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SellOrder record) {
		return sod.insert(record);
	}

	@Override
	public int insertSelective(SellOrder record) {
		return sod.insertSelective(record);
	}

	@Override
	public SellOrder selectByPrimaryKey(Integer id) {
		return sod.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(SellOrder record) {
		return sod.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SellOrder record) {
		return sod.updateByPrimaryKey(record);
	}

	@Override
	public SellOrder selectBySocode(String socode) {
		return sod.selectBySocode(socode);
	}

}
