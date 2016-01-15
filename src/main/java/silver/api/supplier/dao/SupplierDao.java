package silver.api.supplier.dao;

import java.util.List;

import silver.api.supplier.entity.Supplier;

public interface SupplierDao {
		List<Supplier> selectAll();
	
	    int deleteByPrimaryKey(Integer id);

	    int insert(Supplier record);

	    int insertSelective(Supplier record);

	    Supplier selectByPrimaryKey(Integer id);

	    int updateByPrimaryKeySelective(Supplier record);

	    int updateByPrimaryKey(Supplier record);
}
