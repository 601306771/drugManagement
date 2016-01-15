package silver.api.supplier.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import silver.api.supplier.dao.SupplierDao;
import silver.api.supplier.entity.Supplier;
import silver.api.supplier.mapper.SupplierMapper;

@Component
public class SupplierDaoImpl implements SupplierDao {
	
	@Autowired
	private SupplierMapper sMapper;
	
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return sMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Supplier record) {
		return sMapper.insert(record);
	}

	@Override
	public int insertSelective(Supplier record) {
		return sMapper.insertSelective(record);
	}

	@Override
	public Supplier selectByPrimaryKey(Integer id) {
		return sMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Supplier record) {
		return sMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Supplier record) {
		return sMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Supplier> selectAll() {
		return sMapper.selectAll();
	}

}
