package silver.api.drugInformation.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import silver.api.drugInformation.dao.DrugInformationDao;
import silver.api.drugInformation.entity.DrugInformation;
import silver.api.drugInformation.mapper.DrugInformationMapper;

@Component
public class DrugInformationDaoImpl implements DrugInformationDao {
	@Autowired
	private DrugInformationMapper dMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return dMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DrugInformation record) {
		return dMapper.insert(record);
	}

	@Override
	public int insertSelective(DrugInformation record) {
		return dMapper.insertSelective(record);
	}

	@Override
	public DrugInformation selectByPrimaryKey(Integer id) {
		return dMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(DrugInformation record) {
		return dMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DrugInformation record) {
		return dMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<DrugInformation> selectByTcode(String tcode) {
		return dMapper.selectByTcode(tcode);
	}

	@Override
	public List<DrugInformation> selectByDcode(String dcode) {
		return dMapper.selectByDcode(dcode);
	}

	@Override
	public List<DrugInformation> selectAll() {
		return dMapper.selectAll();
	}
	
}
