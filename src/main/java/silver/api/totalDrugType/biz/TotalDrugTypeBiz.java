package silver.api.totalDrugType.biz;

import java.util.List;

import silver.api.totalDrugType.entity.TotalDrugType;

public interface TotalDrugTypeBiz {
	List<TotalDrugType> selectAll();
	
	int deleteByPrimaryKey(Integer id);

    int insert(TotalDrugType record);

    int insertSelective(TotalDrugType record);

    TotalDrugType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TotalDrugType record);

    int updateByPrimaryKey(TotalDrugType record);
}
