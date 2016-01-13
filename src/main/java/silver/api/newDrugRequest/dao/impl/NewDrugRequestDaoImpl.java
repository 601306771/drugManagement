package silver.api.newDrugRequest.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import silver.api.newDrugRequest.dao.NewDrugRequestDao;
import silver.api.newDrugRequest.entity.NewDrugRequestEntity;
import silver.api.newDrugRequest.mapper.NewDrugRequestMapper;

@Component
public class NewDrugRequestDaoImpl implements NewDrugRequestDao {
	@Autowired
	private NewDrugRequestMapper newDrugRequestMapper;
	
	
	@Override
	public List<NewDrugRequestEntity> selectByStatus(String status){
		return newDrugRequestMapper.selectByStatus(status);
	}

}
