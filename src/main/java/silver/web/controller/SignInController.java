package silver.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.axis.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import silver.api.user.biz.UsersBiz;
import silver.api.user.entity.Users;

@Controller
@RequestMapping("/signIn")
public class SignInController {
	@Autowired
	private UsersBiz ub;
	
	
	@RequestMapping("/signOut")
	public String out(final ModelMap model, 
			final HttpServletRequest request){
		
		return "pages/login";   
	}
	
	@RequestMapping("/page")
	public String page(final ModelMap model, 
			final HttpServletRequest request){
		
		HttpSession session  = request.getSession() ;
		session.invalidate();
		
		return "pages/login";   
	}
	
	@RequestMapping("/loading")
	public String loading(final String name, final String password ,final ModelMap model, 
			final HttpServletRequest request){
		Users user = ub.selectByName(name);
		
		//用户存在
		if(user != null){
			String uPassword =user.getUpassword();
			//密码正确
			if(password.equals(uPassword)){
				int utype = user.getUtype();
				HttpSession session  = request.getSession() ;
				session.setAttribute("session_uname", user.getUname());  
			    session.setAttribute("session_unickname", user.getUnickname());  
			    session.setAttribute("session_utype",utype);
			    session.setMaxInactiveInterval(0);
				if(utype==1){
					return "pages/admin/adminWelcome";
				}else if(utype==2){
					return "pages/storeRoomStaff/storeRoomStaffWelcome";
				}else if(utype==3){
					return "pages/pharmacyStaff/pharmacyStaffWelcome";
				}else if(utype==4){
					return "pages/doctor/doctorWelcome";
				}
			}else{
				model.put("message", "密码错误");
				return "pages/login";   
			}
		}
		model.put("message", "用户名不存在");
		return "pages/login";   
	}
}
