package silver.web.controller.admin.drug.type;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import silver.api.totalDrugType.biz.TotalDrugTypeBiz;
import silver.api.totalDrugType.entity.TotalDrugType;

@Controller
@RequestMapping("/totalDrugType")
public class TotalDrugTypeController {
	@Autowired
	private TotalDrugTypeBiz tb;
	
	
	/**
	 * 根据id查询
	 * @param id
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/selectTypeById")
	public String selectTypeById(final Integer id,final ModelMap model,
			final HttpServletRequest request){
		//TODO 适配界面
		
		try{
			TotalDrugType totalDrugType = tb.selectByPrimaryKey(id);
			System.out.println(totalDrugType);
			if(totalDrugType==null){
				return "error";
			}
		}catch(Exception e){
			return "error";
		}
		
		return "userget";
	}
	
	/**
	 * 查询所有药品总分类
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/typeList")
	public String typeList(final ModelMap model,final HttpServletRequest request){
		//TODO 适配页面
		
		try{
			List<TotalDrugType> typeList = tb.selectAll();
			System.out.println(typeList);
			
		}catch(Exception e){
			return "error";
		}
		return "userget";
	}
	

	/**
	 * 添加新的药品总分类
	 * @param tcode
	 * @param tname
	 * @param tdiscribe
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/addType")
	public String addType(final String tcode,final String tname,
			final String tdiscribe,final ModelMap model,
			final HttpServletRequest request){
		//TODO 适配界面
		TotalDrugType record = new TotalDrugType();
		record.setTcode(tcode);
		record.setTname(tname);
		record.setTdiscribe(tdiscribe);
		
		try{
			tb.insertSelective(record);
		}catch(Exception e){
			return "error";
		}
	    	
		return "userget";
	}
	
	/**
	 * 由id删除一个药品总分类
	 * @param id
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/delectType")
	public String delectType(final Integer id,final ModelMap model,
			final HttpServletRequest request){
		//TODO 适配页面
		
		try{
			tb.deleteByPrimaryKey(id);
		}catch(Exception e){
			return "error";
		}
		return "userget";
	}
	
	
	/**
	 * 修改一个药品总分类
	 * @param id
	 * @param tcode
	 * @param tname
	 * @param tdiscribe
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateType")
	public String updateSupplier(final Integer id,final String tcode,final String tname,
			final String tdiscribe,final ModelMap model,
			final HttpServletRequest request){
		//TODO 适配页面
		TotalDrugType record = new TotalDrugType();
		record.setId(id);
		record.setTcode(tcode);
		record.setTname(tname);
		record.setTdiscribe(tdiscribe);
		
		try{
			tb.updateByPrimaryKeySelective(record);
		}catch(Exception e){
			return "error";
		}
		return "userget";
	}
	
	/**
	 * 新增页面跳转
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/addpage")
	public String addpage(final ModelMap model, final HttpServletRequest request){
		return "pages/admin/drugManage/drugType/addType";
	}
	
}
