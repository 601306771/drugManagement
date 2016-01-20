package silver.api.drugInformation.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import silver.api.drugInformation.biz.DrugInformationBiz;
import silver.api.drugInformation.dao.DrugInformationDao;
import silver.api.drugInformation.entity.DrugInformation;
@Service
public class DrugInformationBizImpl implements DrugInformationBiz {
	@Autowired
	private DrugInformationDao dDao;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return dDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DrugInformation record) {
		return dDao.insert(record);
	}

	@Override
	public int insertSelective(DrugInformation record) {
		return dDao.insertSelective(record);
	}

	@Override
	public DrugInformation selectByPrimaryKey(Integer id) {
		return dDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(DrugInformation record) {
		return dDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DrugInformation record) {
		return dDao.updateByPrimaryKey(record);
	}
	
	@Override
	public List<DrugInformation> selectByTcode(String tcode) {
		return dDao.selectByTcode(tcode);
	}

	@Override
	public List<DrugInformation> selectByDcode(String dcode) {
		return dDao.selectByDcode(dcode);
	}

	@Override
	public List<DrugInformation> selectAll() {
		return dDao.selectAll();
	}
}
