package silver.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/welCome")
public class WelcomePageController {

		@RequestMapping("admin")
		public String page1(final ModelMap model, 
				final HttpServletRequest request){	
			return "welcome";   
		}
		@RequestMapping("storeRoomStaff")
		public String page2(final ModelMap model, 
				final HttpServletRequest request){	
			return "welcome";   
		}
		
		@RequestMapping("pharmacyStaff")
		public String page3(final ModelMap model, 
				final HttpServletRequest request){	
			return "welcome";   
		}
		

}
