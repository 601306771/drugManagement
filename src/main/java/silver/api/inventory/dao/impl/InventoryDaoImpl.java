package silver.api.inventory.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import silver.api.inventory.dao.InventoryDao;
import silver.api.inventory.entity.Inventory;
import silver.api.inventory.mapper.InventoryMapper;

@Component
public class InventoryDaoImpl implements InventoryDao {
	
	@Autowired
	private InventoryMapper im;
	
	@Override
	public Inventory selectByDname(String dname) {
		return im.selectByDname(dname);
	}

	

	@Override
	public int insert(Inventory record) {
		return im.insert(record);
	}

	@Override
	public int insertSelective(Inventory record) {
		return im.insertSelective(record);
	}

	@Override
	public Inventory selectByPrimaryKey(Integer id) {
		return im.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Inventory record) {
		return im.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Inventory record) {
		return im.updateByPrimaryKey(record);
	}



	@Override
	public int deleteByPrimaryKey(Integer id) {
		return im.deleteByPrimaryKey(id);
	}



	@Override
	public List<Inventory> selectAll() {
		return im.selectAll();
	}

}
