package silver.web.controller.newDrugRequest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import silver.api.user.biz.userDao;
import silver.api.user.entity.user;
import silver.api.user.mapper.userMapper;

@Controller
@RequestMapping("/user")
public class userController {
	@Autowired
	private userDao um;
	
	@RequestMapping("/get")
	public String manageRequest(final String status,final ModelMap model, 
			final HttpServletRequest request){
		user u = um.selectByPrimaryKey();
		System.out.print(u.getUserName());
		return "userget";
	}
}
