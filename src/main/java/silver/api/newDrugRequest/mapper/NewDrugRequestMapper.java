package silver.api.newDrugRequest.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import silver.api.newDrugRequest.entity.NewDrugRequestEntity;

@Repository
public interface NewDrugRequestMapper {
	List<NewDrugRequestEntity> selectByStatus(String status);
}