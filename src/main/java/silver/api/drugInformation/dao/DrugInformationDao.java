package silver.api.drugInformation.dao;

import java.util.List;

import silver.api.drugInformation.entity.DrugInformation;

public interface DrugInformationDao {

	
	List<DrugInformation> selectAll();
	
    int deleteByPrimaryKey(Integer id);

    int insert(DrugInformation record);

    int insertSelective(DrugInformation record);

    DrugInformation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DrugInformation record);

    int updateByPrimaryKey(DrugInformation record);
}
