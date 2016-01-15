package silver.api.supplier.biz;

import java.util.List;

import silver.api.supplier.entity.Supplier;

public interface SupplierBiz {
	List<Supplier> selectAll();
	
	int deleteByPrimaryKey(Integer id);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    Supplier selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);
}
