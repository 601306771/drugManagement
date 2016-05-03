package silver.api.sellOrderDetail.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import silver.api.sellOrderDetail.dao.SellOrderDetailDao;
import silver.api.sellOrderDetail.entity.SellOrderDetail;
import silver.api.sellOrderDetail.mapper.SellOrderDetailMapper;

@Component
public class SellOrderDetailDaoImpl implements SellOrderDetailDao {
	@Autowired 
	private SellOrderDetailMapper sodm;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return sodm.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SellOrderDetail record) {
		return sodm.insert(record);
	}

	@Override
	public int insertSelective(SellOrderDetail record) {
		return sodm.insertSelective(record);
	}

	@Override
	public SellOrderDetail selectByPrimaryKey(Integer id) {
		return sodm.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(SellOrderDetail record) {
		return sodm.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SellOrderDetail record) {
		return sodm.updateByPrimaryKey(record);
	}

	@Override
	public List<SellOrderDetail> selectBySocode(String socode) {
		return sodm.selectBySocode(socode);
	}

}
