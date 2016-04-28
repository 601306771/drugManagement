package silver.api.inventory.dao;

import silver.api.inventory.entity.Inventory;

public interface InventoryDao {
	 Inventory selectByDname(String dname);
		
	    int deleteByPrimaryKey(Integer id);

	    int insert(Inventory record);

	    int insertSelective(Inventory record);

	    Inventory selectByPrimaryKey(Integer id);

	    int updateByPrimaryKeySelective(Inventory record);

	    int updateByPrimaryKey(Inventory record);
}
