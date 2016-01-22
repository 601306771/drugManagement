package silver.web.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import silver.api.user.biz.UsersBiz;
import silver.api.user.entity.Users;

@Controller
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UsersBiz ub;
	
	
	
	/**
	 * 新增用户
	 * @param uname
	 * @param upassword
	 * @param utype
	 * @param unickname
	 * @param discribe
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/addUsers")
	public String addUsers(final String uname,final String upassword,final Integer utype,
			final String unickname,final String discribe,final ModelMap model, 
			final HttpServletRequest request){	
		//TODO  对页面的适配
		Users record = new Users();
		record.setUname(uname);
		record.setUpassword(upassword);
		record.setUtype(utype);
		record.setUnickname(unickname);
		record.setDiscribe(discribe);
		
		try{
			int result = ub.insertSelective(record);
		}catch(Exception e){
			return "error";
		}
	    	
		return "userget";
	    	
	    
	}
	
	
	/**
	 * 用户列表，通过传入参数utype（用户类型）来显示不同类型的用户
	 * @param utype
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/userList")
	public String userList(final Integer utype,final ModelMap model, 
			final HttpServletRequest request){
		//TODO 对页面的适配
		System.out.println(utype);
		try{
			List<Users> usersList = ub.selectByUtype(utype);
			model.put("userList", usersList);
			model.put("index", 1);
			System.out.print(usersList);
		}catch(Exception e){
			return "error";
		}
		
		if(utype==3){
			return "pages/admin/usersManage/pharmacyStaffList";
		}else if(utype==2){
			return "pages/admin/usersManage/storeroomStaffList";
		}else{
			return "error";
		}
	}
	

	/**
	 * 根据id取得用户信息
	 * @param id
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/selectByid")
	public String selectByUid(final Integer id,final ModelMap model, 
			final HttpServletRequest request){
		//TODO 对页面的适配
		try{
			Users users = ub.selectByPrimaryKey(id);
			System.out.print(users);
		}catch(Exception e){
			return "error";
		}
    	return "userget";
	}
	
	
	
	
	/**
	 * 根据参数修改用户信息
	 * @param id
	 * @param uname
	 * @param upassword
	 * @param utype
	 * @param unickname
	 * @param discribe
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateIfo")
	public String updateIfo(final Integer id,final String upassword,
			final String unickname,final String discribe,final ModelMap model, 
			final HttpServletRequest request){
		//TODO 对页面的适配
		Users record = new Users();
		record.setId(id);
		record.setUpassword(upassword);
		record.setUnickname(unickname);
		record.setDiscribe(discribe);
		try{
			ub.updateByPrimaryKeySelective(record);
		}catch(Exception e){
			return "error";
		}
    	return "userget";
	}
	
	/**
	 * 删除传入id的记录
	 * @param id
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/deleteUsers")
	public ModelAndView deleteUsers(final Integer id,final Integer utype,final ModelMap model, 
			final HttpServletRequest request){
		//TODO 对页面的适配
		try{
			System.out.println("id:" +id +",utype:" +utype );
			ub.deleteByPrimaryKey(id);
		}catch(Exception e){
			return new ModelAndView( "error");
		}
		if(utype==3){
			return new ModelAndView("redirect:/users/userList?utype=3");
		}else if(utype==2){
			return new ModelAndView("redirect:/users/userList?utype=2");
		}else{
			return new ModelAndView( "error");
		}
	}
	
	
	/**
	 * 编辑页面跳转
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit(final Integer id,final String uname,final String upassword,
			final Integer utype,final String unickname,final String discribe,
			final ModelMap model, final HttpServletRequest request){
		Users record = new Users();
		record.setId(id);
		record.setUname(uname);
		record.setUpassword(upassword);
		record.setUtype(utype);
		record.setUnickname(unickname);
		record.setDiscribe(discribe);
		System.out.print(record);
		
		model.put("user", record);
		
		return "pages/admin/usersManage/editUsers";
	}
	
	/**
	 * error页面跳转
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/error")
	public String error(final ModelMap model, final HttpServletRequest request){
		return "error";
	}
	
	
	
	
}
