package silver.web.controller.storeRoomStaff;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/purchasePlan")
public class PurchasePlanController {
	
	@RequestMapping("/page")
	public String page(final ModelMap model, 
			final HttpServletRequest request){
		return "pages/storeRoomStaff/purchasePlan/purchasePlanPage";   
		
	}
	
	
}
