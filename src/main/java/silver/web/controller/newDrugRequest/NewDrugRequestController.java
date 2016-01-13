package silver.web.controller.newDrugRequest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import silver.api.newDrugRequest.biz.NewDrugRequestBiz;
import silver.api.newDrugRequest.entity.NewDrugRequestEntity;

@Controller
@RequestMapping("/newDrugRequest")
public class NewDrugRequestController {
	
	@Autowired
	private NewDrugRequestBiz newDrugRequestBiz ;
	
	
	@RequestMapping("/manageRequest")
	public String manageRequest(final String status,final ModelMap model, 
			final HttpServletRequest request){
		List<NewDrugRequestEntity> entityList = newDrugRequestBiz.selectByStatus("new");
		model.put("newDrugRequestList", entityList);
		return "manageRequest";
	}
	
	
	
}
