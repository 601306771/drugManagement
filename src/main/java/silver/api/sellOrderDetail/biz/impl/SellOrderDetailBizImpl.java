package silver.api.sellOrderDetail.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import silver.api.sellOrderDetail.biz.SellOrderDetailBiz;
import silver.api.sellOrderDetail.dao.SellOrderDetailDao;
import silver.api.sellOrderDetail.entity.SellOrderDetail;

@Service
public class SellOrderDetailBizImpl implements SellOrderDetailBiz{
	@Autowired 
	private SellOrderDetailDao sodd;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return sodd.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SellOrderDetail record) {
		return sodd.insert(record);
	}

	@Override
	public int insertSelective(SellOrderDetail record) {
		return sodd.insertSelective(record);
	}

	@Override
	public SellOrderDetail selectByPrimaryKey(Integer id) {
		return sodd.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(SellOrderDetail record) {
		return sodd.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SellOrderDetail record) {
		return sodd.updateByPrimaryKey(record);
	}

	@Override
	public List<SellOrderDetail> selectBySocode(String socode) {
		return sodd.selectBySocode(socode);
	}
}
