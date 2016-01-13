package silver.api.newDrugRequest.biz;

import java.util.List;

import silver.api.newDrugRequest.entity.NewDrugRequestEntity;

public interface NewDrugRequestBiz {
	
	List<NewDrugRequestEntity> selectByStatus(String status);
}
