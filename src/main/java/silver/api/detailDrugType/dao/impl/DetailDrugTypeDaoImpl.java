package silver.api.detailDrugType.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import silver.api.detailDrugType.dao.DetailDrugTypeDao;
import silver.api.detailDrugType.entity.DetailDrugType;
import silver.api.detailDrugType.mapper.DetailDrugTypeMapper;
@Component
public class DetailDrugTypeDaoImpl implements DetailDrugTypeDao {

	@Autowired
	private DetailDrugTypeMapper dMapper;
	
	@Override
	public List<DetailDrugType> selectAll(){
		return dMapper.selectAll();
	}
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return dMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DetailDrugType record) {
		return dMapper.insert(record);
	}

	@Override
	public int insertSelective(DetailDrugType record) {
		return dMapper.insertSelective(record);
	}

	@Override
	public DetailDrugType selectByPrimaryKey(Integer id) {
		return dMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(DetailDrugType record) {
		return dMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DetailDrugType record) {
		return dMapper.updateByPrimaryKey(record);
	}

}
