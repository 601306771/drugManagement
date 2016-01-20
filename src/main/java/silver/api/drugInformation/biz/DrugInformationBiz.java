package silver.api.drugInformation.biz;

import java.util.List;

import silver.api.drugInformation.entity.DrugInformation;

public interface DrugInformationBiz {
	
		List<DrugInformation> selectByTcode(String tcode);
	
		List<DrugInformation> selectByDcode(String dcode);
	
		List<DrugInformation> selectAll();
		
	 	int deleteByPrimaryKey(Integer id);

	    int insert(DrugInformation record);

	    int insertSelective(DrugInformation record);

	    DrugInformation selectByPrimaryKey(Integer id);

	    int updateByPrimaryKeySelective(DrugInformation record);

	    int updateByPrimaryKey(DrugInformation record);
}
