package silver.api.sellOrder.dao;

import silver.api.sellOrder.entity.SellOrder;

public interface SellOrderDao {
	  	SellOrder selectBySocode(String socode);
	
	  	int deleteByPrimaryKey(Integer id);

	    int insert(SellOrder record);

	    int insertSelective(SellOrder record);

	    SellOrder selectByPrimaryKey(Integer id);

	    int updateByPrimaryKeySelective(SellOrder record);

	    int updateByPrimaryKey(SellOrder record);
}
