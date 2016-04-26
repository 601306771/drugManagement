package silver.web.controller.admin;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/reports")
public class ReportsController {
	
	@RequestMapping("/total")
	public String supplierList(final ModelMap model,final HttpServletRequest request){
		
		return "pages/admin/reports";
	}

}
