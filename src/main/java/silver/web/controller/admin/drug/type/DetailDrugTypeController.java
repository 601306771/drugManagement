package silver.web.controller.admin.drug.type;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import silver.api.detailDrugType.biz.DetailDrugTypeBiz;
import silver.api.detailDrugType.entity.DetailDrugType;
import silver.api.totalDrugType.biz.TotalDrugTypeBiz;

@Controller
@RequestMapping("/detailDrugType")
public class DetailDrugTypeController {
	@Autowired
	private DetailDrugTypeBiz db;
	
	/**
	 * 根据总分类的标识TCODE来获取此总分类的细分类
	 * @param tcode
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/selectByTcode")
	public String selectTypeTcode(final String tcode,final ModelMap model,
			final HttpServletRequest request){
		//TODO 适配界面
		
		try{
			List<DetailDrugType> detailDrugTypelist = db.selectByTcode(tcode);
			System.out.println(detailDrugTypelist);
		}catch(Exception e){
			return "error";
		}
		return "userget";
	}
	
	
	/**
	 * 根据id查询
	 * @param id
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/selectById")
	public String selectTypeById(final Integer id,final ModelMap model,
			final HttpServletRequest request){
		//TODO 适配界面
		
		try{
			DetailDrugType detailDrugType = db.selectByPrimaryKey(id);
			System.out.println(detailDrugType);
			if(detailDrugType==null){
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
			List<DetailDrugType> typeList = db.selectAll();
			System.out.println(typeList);
			
		}catch(Exception e){
			return "error";
		}
		return "userget";
	}
	

	/**
	 * 添加新的药品总分类
	 * @param dcode
	 * @param dname
	 * @param ddiscribe
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/addType")
	public String addType(final String dcode,final String tcode,final String dname,
			final String ddiscribe,final ModelMap model,
			final HttpServletRequest request){
		//TODO 适配界面
		DetailDrugType record = new DetailDrugType();
		record.setDcode(dcode);
		record.setTcode(tcode);
		record.setDname(dname);
		record.setDdiscribe(ddiscribe);
		
		try{
			db.insertSelective(record);
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
			db.deleteByPrimaryKey(id);
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
	public String updateSupplier(final Integer id,final String dcode,final String tcode,final String dname,
			final String ddiscribe,final ModelMap model,
			final HttpServletRequest request){
		//TODO 适配页面
		DetailDrugType record = new DetailDrugType();
		record.setId(id);
		record.setTcode(tcode);
		record.setDcode(dcode);
		record.setDname(dname);
		record.setDdiscribe(ddiscribe);
		
		try{
			db.updateByPrimaryKeySelective(record);
		}catch(Exception e){
			return "error";
		}
		return "userget";
	}
}
