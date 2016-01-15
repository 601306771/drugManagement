package silver.api.totalDrugType.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import silver.api.totalDrugType.biz.TotalDrugTypeBiz;
import silver.api.totalDrugType.dao.TotalDrugTypeDao;
import silver.api.totalDrugType.entity.TotalDrugType;

@Service
public class TotalDrugTypeBizImpl implements TotalDrugTypeBiz {

	@Autowired
	private TotalDrugTypeDao tDao;
	
	
	@Override
	public List<TotalDrugType> selectAll(){
		return tDao.selectAll();
	}
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return tDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(TotalDrugType record) {
		return tDao.insert(record);
	}

	@Override
	public int insertSelective(TotalDrugType record) {
		return tDao.insertSelective(record);
	}

	@Override
	public TotalDrugType selectByPrimaryKey(Integer id) {
		return tDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(TotalDrugType record) {
		return tDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TotalDrugType record) {
		return tDao.updateByPrimaryKey(record);
	}

}
