package silver.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import silver.api.user.entity.Users;

@Controller
@RequestMapping("/signIn")
public class SignInController {
	
	@RequestMapping("/page")
	public String page(final ModelMap model, 
			final HttpServletRequest request){	
		return "pages/login";   
	}
	
	@RequestMapping("/loading")
	public String loading(final Integer utype,final ModelMap model, 
			final HttpServletRequest request){
		if(utype==1){
			return "pages/admin/adminWelcome";
		}else if(utype==2){
			return "pages/storeRoomStaff/storeRoomStaffWelcome";
		}else if(utype==1){
			return "error";
		}
		return "pages/login";   
	}
}
