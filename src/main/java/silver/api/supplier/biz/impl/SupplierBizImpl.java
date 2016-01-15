package silver.api.supplier.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import silver.api.supplier.biz.SupplierBiz;
import silver.api.supplier.dao.SupplierDao;
import silver.api.supplier.entity.Supplier;
@Service
public class SupplierBizImpl implements SupplierBiz {

	@Autowired
	private SupplierDao sDao;
	
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return sDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Supplier record) {
		return sDao.insert(record);
	}

	@Override
	public int insertSelective(Supplier record) {
		return sDao.insertSelective(record);
	}

	@Override
	public Supplier selectByPrimaryKey(Integer id) {
		return sDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Supplier record) {
		return sDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Supplier record) {
		return sDao.updateByPrimaryKey(record);
	}

	@Override
	public List<Supplier> selectAll() {
		return sDao.selectAll();
	}

}
