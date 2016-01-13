package silver.api.newDrugRequest.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import silver.api.newDrugRequest.biz.NewDrugRequestBiz;
import silver.api.newDrugRequest.dao.NewDrugRequestDao;
import silver.api.newDrugRequest.entity.NewDrugRequestEntity;

@Service
public class NewDrugRequestBizImpl implements NewDrugRequestBiz {

	@Autowired
	private NewDrugRequestDao newDrugRequestDao;
	
	@Override
	public List<NewDrugRequestEntity> selectByStatus(String status){
		return newDrugRequestDao.selectByStatus(status);
	}

}
