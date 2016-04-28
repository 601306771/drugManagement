package silver.api.inventory.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import silver.api.inventory.biz.InventoryBiz;
import silver.api.inventory.dao.InventoryDao;
import silver.api.inventory.entity.Inventory;
import silver.api.inventory.mapper.InventoryMapper;

@Service
public class InventoryBizImpl implements InventoryBiz {

	@Autowired
	private InventoryDao idao;
	
	@Override
	public Inventory selectByDname(String dname) {
		return idao.selectByDname(dname);
	}

	

	@Override
	public int insert(Inventory record) {
		return idao.insert(record);
	}

	@Override
	public int insertSelective(Inventory record) {
		return idao.insertSelective(record);
	}

	@Override
	public Inventory selectByPrimaryKey(Integer id) {
		return idao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Inventory record) {
		return idao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Inventory record) {
		return idao.updateByPrimaryKey(record);
	}



	@Override
	public int deleteByPrimaryKey(Integer id) {
		return idao.deleteByPrimaryKey(id);
	}

}
