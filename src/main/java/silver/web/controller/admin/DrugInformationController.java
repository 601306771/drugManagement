package silver.web.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import silver.api.detailDrugType.biz.DetailDrugTypeBiz;
import silver.api.detailDrugType.entity.DetailDrugType;
import silver.api.drugInformation.biz.DrugInformationBiz;
import silver.api.drugInformation.entity.DrugInformation;
import silver.api.totalDrugType.biz.TotalDrugTypeBiz;
import silver.api.totalDrugType.entity.TotalDrugType;

@Controller
@RequestMapping("/drugIfo")
public class DrugInformationController {
	@Autowired
	private DrugInformationBiz di;
	@Autowired
	private DetailDrugTypeBiz db;

	
	/**
	 * 根据总分类的标识TCODE来获取此药品信息
	 * @param tcode
	 * @param model
	 * @param request
	 * @return
	 */
//	@RequestMapping("/selectTcode")
//	public String selectTcode(final String tcode,final ModelMap model,
//			final HttpServletRequest request){
//		//TODO 适配界面
//		try{
//			List<DrugInformation> drugInformationList = di.selectByTcode(tcode);
//			System.out.println(drugInformationList);
//		}catch(Exception e){
//			return "error";
//		}
//		return "userget";
//	}
	
	
	/**
	 * 根据细分类的标识DCODE来获取此药品信息
	 * @param scode
	 * @param model
	 * @param request
	 * @return
	 */
//	@RequestMapping("/selectDcode")
//	public String selectDcode(final String dcode,final ModelMap model,
//			final HttpServletRequest request){
//		//TODO 适配界面
//		
//		try{
//			List<DrugInformation> drugInformationList = di.selectByDcode(dcode);
//			System.out.println(drugInformationList);
//		}catch(Exception e){
//			return "error";
//		}
//		return "userget";
//	}
	
	
	/**
	 * 根据id查询
	 * @param id
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/selectById")
	public String selectById(final Integer id,final ModelMap model,
			final HttpServletRequest request){
		//TODO 适配界面
		
		try{
			DrugInformation drugInformation = di.selectByPrimaryKey(id);
			System.out.println(drugInformation);
			if(drugInformation==null){
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
	@RequestMapping("/ifoList")
	public String ifoList(final ModelMap model,final HttpServletRequest request){
		//TODO 适配页面
		
		try{
			List<DrugInformation> drugInformationList = di.selectAll();
			System.out.println(drugInformationList);
			model.put("ifoList", drugInformationList);
		}catch(Exception e){
			return "error";
		}
		return "pages/admin/drugManage/drugIfo/drugList";
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
	@RequestMapping("/addIfo")
	public ModelAndView addIfo(final String dsuitable,final String dindications,final String dtype,
			final String dexpirationdate,final String dusage,final String tcode,final String dname,
			final Integer price, final String ddiscribe,final ModelMap model,
			final HttpServletRequest request){
		//TODO 适配界面
		DrugInformation record = new DrugInformation();
		record.setDsuitable(dsuitable);
		record.setDindications(dindications);
		record.setDexpirationdate(dexpirationdate);
		record.setDusage(dusage);
		record.setDtype(dtype);
		record.setDname(dname);
		record.setDdiscribe(ddiscribe);
		record.setPrice(price);
		
		System.out.println(record);
		
		try{
			di.insert(record);
		}catch(Exception e){
			return new ModelAndView("redirect:/drugIfo/error");
		}
	    	
		return new ModelAndView("redirect:/drugIfo/ifoList");
	}
	
	/**
	 * 由id删除一个药品总分类
	 * @param id
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/delectIfo")
	public ModelAndView delectIfo(final Integer id,final ModelMap model,
			final HttpServletRequest request){
		//TODO 适配页面
		
		try{
			di.deleteByPrimaryKey(id);
		}catch(Exception e){
			return new ModelAndView("redirect:/drugIfo/error");
		}
	    	
		return new ModelAndView("redirect:/drugIfo/ifoList");
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
	@RequestMapping("/updateIfo")
	public ModelAndView updateIfo(final Integer id,final String dsuitable,final String dindications,
			final String dcode,final Integer price,final String dtype,
			final String dexpirationdate,final String dusage,final String dname,
			final String ddiscribe,final ModelMap model,
			final HttpServletRequest request){
		//TODO 适配界面
		DrugInformation record = new DrugInformation();
		record.setId(id);
		record.setDsuitable(dsuitable);
		record.setDindications(dindications);
		record.setDexpirationdate(dexpirationdate);
		record.setDusage(dusage);
		record.setDtype(dtype);
		record.setDname(dname);
		record.setDdiscribe(ddiscribe);
		record.setPrice(price);
		System.out.println(record);
		try{
			di.updateByPrimaryKeySelective(record);
		}catch(Exception e){
			return new ModelAndView("redirect:/drugIfo/error");
		}
	    	
		return new ModelAndView("redirect:/drugIfo/ifoList");
	}
	
	/**
	 * 新增页面跳转
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/addpage")
	public String addpage(final ModelMap model, final HttpServletRequest request){
		try{
			List<DetailDrugType> detailType = db.selectAll();
			model.put("detailType",detailType);
		}catch(Exception e){
			return "error";
		}
		return "pages/admin/drugManage/drugIfo/addIfo";
	}
	
	/**
	 * 编辑页面跳转
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit(final Integer id,final String dname,final String dcode,final Integer price,
			final String dusage,final String dexpirationdate,final String dindications,final String dsuitable,
			final String ddiscribe,final ModelMap model, 
			final HttpServletRequest request){
		DrugInformation record = new DrugInformation();
		record.setId(id);
		record.setDsuitable(dsuitable);
		record.setDindications(dindications);
		record.setDexpirationdate(dexpirationdate);
		record.setDusage(dusage);
		record.setDtype(dcode);
		record.setDname(dname);
		record.setDdiscribe(ddiscribe);
		record.setPrice(price);
		
		System.out.print(record);
		//总分类列表
		try{
			List<DetailDrugType> detailType = db.selectAll();
			model.put("detailType",detailType);
		}catch(Exception e){
			return "error";
		}
		model.put("drugIfo", record);
		return "pages/admin/drugManage/drugIfo/editIfo";
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
	
	/**
	 * 添加测试数据
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/addDatas")
	public String addDatas(final ModelMap model,final HttpServletRequest request){
		//TODO 适配界面
		for(int i=1;i<2000;i++){
			String data = String.valueOf(i);
			DrugInformation record = new DrugInformation();
			record.setDsuitable(data);
			record.setDindications(data);
			record.setDexpirationdate(data);
			record.setDusage(data);
			record.setDtype(data);
			record.setDname(data);
			record.setDdiscribe(data);
			di.insertSelective(record);
		}
	
		return "error";
	}

}
