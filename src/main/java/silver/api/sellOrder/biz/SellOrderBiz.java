package silver.api.sellOrder.biz;

import java.util.List;

import silver.api.sellOrder.entity.SellOrder;

public interface SellOrderBiz {
		List<SellOrder> selectByState(String state);
	
		SellOrder selectBySocode(String socode);	
	
		int deleteByPrimaryKey(Integer id);

	    int insert(SellOrder record);

	    int insertSelective(SellOrder record);

	    SellOrder selectByPrimaryKey(Integer id);

	    int updateByPrimaryKeySelective(SellOrder record);

	    int updateByPrimaryKey(SellOrder record);
}
