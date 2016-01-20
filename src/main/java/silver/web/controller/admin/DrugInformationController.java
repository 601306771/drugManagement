package silver.web.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import silver.api.drugInformation.biz.DrugInformationBiz;
import silver.api.drugInformation.entity.DrugInformation;

@Controller
@RequestMapping("/drugIfo")
public class DrugInformationController {
	@Autowired
	private DrugInformationBiz di;
	
	/**
	 * 根据总分类的标识TCODE来获取此药品信息
	 * @param tcode
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/selectTcode")
	public String selectTcode(final String tcode,final ModelMap model,
			final HttpServletRequest request){
		//TODO 适配界面
		try{
			List<DrugInformation> drugInformationList = di.selectByTcode(tcode);
			System.out.println(drugInformationList);
		}catch(Exception e){
			return "error";
		}
		return "userget";
	}
	
	
	/**
	 * 根据细分类的标识DCODE来获取此药品信息
	 * @param scode
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/selectDcode")
	public String selectDcode(final String dcode,final ModelMap model,
			final HttpServletRequest request){
		//TODO 适配界面
		
		try{
			List<DrugInformation> drugInformationList = di.selectByDcode(dcode);
			System.out.println(drugInformationList);
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
	@RequestMapping("/addIfo")
	public String addIfo(final String dsuitable,final String dindications,final String dcode,
			final String dexpirationdate,final String dusage,final String tcode,final String dname,
			final String ddiscribe,final ModelMap model,
			final HttpServletRequest request){
		//TODO 适配界面
		
		DrugInformation record = new DrugInformation();
		record.setDsuitable(dsuitable);
		record.setDindications(dindications);
		record.setDexpirationdate(dexpirationdate);
		record.setDusage(dusage);
		record.setDcode(dcode);
		record.setTcode(tcode);
		record.setDname(dname);
		record.setDdiscribe(ddiscribe);
		
		try{
			di.insertSelective(record);
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
	@RequestMapping("/delectIfo")
	public String delectIfo(final Integer id,final ModelMap model,
			final HttpServletRequest request){
		//TODO 适配页面
		
		try{
			di.deleteByPrimaryKey(id);
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
	@RequestMapping("/updateIfo")
	public String updateIfo(final Integer id,final String dsuitable,final String dindications,final String dcode,
			final String dexpirationdate,final String dusage,final String tcode,final String dname,
			final String ddiscribe,final ModelMap model,
			final HttpServletRequest request){
		//TODO 适配界面
		
		DrugInformation record = new DrugInformation();
		record.setId(id);
		record.setDsuitable(dsuitable);
		record.setDindications(dindications);
		record.setDexpirationdate(dexpirationdate);
		record.setDusage(dusage);
		record.setDcode(dcode);
		record.setTcode(tcode);
		record.setDname(dname);
		record.setDdiscribe(ddiscribe);
		
		try{
			di.updateByPrimaryKeySelective(record);
		}catch(Exception e){
			return "error";
		}
		return "userget";
	}

}
