package silver.api.totalDrugType.dao;

import java.util.List;

import silver.api.totalDrugType.entity.TotalDrugType;

public interface TotalDrugTypeDao {
	
	List<TotalDrugType> selectAll();

	int deleteByPrimaryKey(Integer id);

    int insert(TotalDrugType record);

    int insertSelective(TotalDrugType record);

    TotalDrugType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TotalDrugType record);

    int updateByPrimaryKey(TotalDrugType record);
}
