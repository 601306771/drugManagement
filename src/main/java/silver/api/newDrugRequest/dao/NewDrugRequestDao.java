package silver.api.newDrugRequest.dao;

import java.util.List;

import silver.api.newDrugRequest.entity.NewDrugRequestEntity;

public interface NewDrugRequestDao {
	List<NewDrugRequestEntity> selectByStatus(String status);
}
