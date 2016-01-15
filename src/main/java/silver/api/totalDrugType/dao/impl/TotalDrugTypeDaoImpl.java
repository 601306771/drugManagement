package silver.api.totalDrugType.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import silver.api.totalDrugType.dao.TotalDrugTypeDao;
import silver.api.totalDrugType.entity.TotalDrugType;
import silver.api.totalDrugType.mapper.TotalDrugTypeMapper;
@Component
public class TotalDrugTypeDaoImpl implements TotalDrugTypeDao {
	@Autowired
	private TotalDrugTypeMapper tMapper;
	
	@Override
	public List<TotalDrugType> selectAll(){
		return tMapper.selectAll();
	}
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return tMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(TotalDrugType record) {
		return tMapper.insert(record);
	}

	@Override
	public int insertSelective(TotalDrugType record) {
		return tMapper.insertSelective(record);
	}

	@Override
	public TotalDrugType selectByPrimaryKey(Integer id) {
		return tMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(TotalDrugType record) {
		return tMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TotalDrugType record) {
		return tMapper.updateByPrimaryKey(record);
	}

}
