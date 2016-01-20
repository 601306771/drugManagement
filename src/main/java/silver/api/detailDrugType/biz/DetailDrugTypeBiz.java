package silver.api.detailDrugType.biz;

import java.util.List;

import silver.api.detailDrugType.entity.DetailDrugType;

public interface DetailDrugTypeBiz {
		List<DetailDrugType> selectByTcode(String tcode);
	
		List<DetailDrugType> selectAll();
	 
		int deleteByPrimaryKey(Integer id);

	    int insert(DetailDrugType record);

	    int insertSelective(DetailDrugType record);

	    DetailDrugType selectByPrimaryKey(Integer id);

	    int updateByPrimaryKeySelective(DetailDrugType record);

	    int updateByPrimaryKey(DetailDrugType record);

}
