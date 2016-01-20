package silver.api.detailDrugType.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import silver.api.detailDrugType.biz.DetailDrugTypeBiz;
import silver.api.detailDrugType.dao.DetailDrugTypeDao;
import silver.api.detailDrugType.entity.DetailDrugType;

@Service
public class DetailDrugTypeBizImpl implements DetailDrugTypeBiz {

	@Autowired
	private DetailDrugTypeDao dDao;
	
	@Override
	public List<DetailDrugType> selectAll(){
		return dDao.selectAll();
	}
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return dDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(DetailDrugType record) {
		return dDao.insert(record);
	}

	@Override
	public int insertSelective(DetailDrugType record) {
		return dDao.insertSelective(record);
	}

	@Override
	public DetailDrugType selectByPrimaryKey(Integer id) {
		return dDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(DetailDrugType record) {
		return dDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DetailDrugType record) {
		return dDao.updateByPrimaryKey(record);
	}

	@Override
	public List<DetailDrugType> selectByTcode(String tcode) {
		return dDao.selectByTcode(tcode);
	}

}
