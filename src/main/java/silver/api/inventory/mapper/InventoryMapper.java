package silver.api.inventory.mapper;

import java.util.List;

import silver.api.inventory.entity.Inventory;

public interface InventoryMapper {
	List<Inventory> selectAll();
	
	 Inventory selectByDname(String dname);
	
    int deleteByPrimaryKey(Integer id);

    int insert(Inventory record);

    int insertSelective(Inventory record);

    Inventory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Inventory record);

    int updateByPrimaryKey(Inventory record);
}