package silver.web.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import silver.api.supplier.biz.SupplierBiz;
import silver.api.supplier.entity.Supplier;

@Controller
@RequestMapping("/supplier")
public class SupplierController {
	
	@Autowired
	private SupplierBiz sb;
	
	/**
	 * 添加供应商
	 * @param scode
	 * @param sname
	 * @param sphone
	 * @param saddress
	 * @param sdiscribe
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/addSupplier")
	public ModelAndView addSupplier(final String scode,final String sname,final String sphone,
			final String saddress,final String sdiscribe,final ModelMap model,
			final HttpServletRequest request){
		//TODO 适配界面
		Supplier record = new Supplier();
		record.setScode(scode);
		record.setSname(sname);
		record.setSphone(sphone);
		record.setSaddress(saddress);
		record.setSdiscribe(sdiscribe);
		
		try{
			sb.insertSelective(record);
		}catch(Exception e){
			return new ModelAndView( "error");
		}
	    	
		return new ModelAndView("redirect:/supplier/supplierList");
	}
	
	
	/**
	 * 获取所有供应商
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/supplierList")
	public String supplierList(final ModelMap model,final HttpServletRequest request){
		//TODO 适配页面
		
		try{
			List<Supplier> suplierList = sb.selectAll();
			System.out.println(suplierList);
			model.put("suplierList", suplierList);
			model.put("index", 1);
		}catch(Exception e){
			return "error";
		}
		return "pages/admin/supplierManage/supplierList";
	}
	
	
	/**
	 * 根据id获得供应商
	 * @param id
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/selectByid")
	public String selectByid(final Integer id ,final ModelMap model,final HttpServletRequest request){
		//TODO 适配页面
		try{
			Supplier suplier = sb.selectByPrimaryKey(id);
			System.out.println(suplier);
			if(suplier==null){
				return "error";
			}
		}catch(Exception e){
			return "error";
		}
		
		return "userget";
	}
	
	/**
	 * 修改供应商数据，根据id定位
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateSupplier")
	public ModelAndView updateSupplier(final Integer id,final String scode,final String sname,
			final String sphone,final String saddress,final String sdiscribe,final ModelMap model,
			final HttpServletRequest request){
		//TODO 适配页面
		Supplier record = new Supplier();
		record.setId(id);
		record.setScode(scode);
		record.setSname(sname);
		record.setSphone(sphone);
		record.setSaddress(saddress);
		record.setSdiscribe(sdiscribe);
		
		try{
			sb.updateByPrimaryKeySelective(record);
		}catch(Exception e){
			return new ModelAndView( "error");
		}
	    	
		return new ModelAndView("redirect:/supplier/supplierList");
	}
	
	/**.
	 * 根据id删除
	 * @param id
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/delectSupplier")
	public ModelAndView delectSupplier(final Integer id,final ModelMap model,
			final HttpServletRequest request){
		//TODO 适配页面
		
		try{
			sb.deleteByPrimaryKey(id);
		}catch(Exception e){
			return new ModelAndView( "error");
		}
	    	
		return new ModelAndView("redirect:/supplier/supplierList");
	}

	/**
	 * edit页面跳转
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit(final Integer id,final String scode,final String sname,
			final String sphone,final String saddress,final String sdiscribe,
			final ModelMap model, final HttpServletRequest request){
		Supplier record = new Supplier();
		record.setId(id);
		record.setScode(scode);
		record.setSname(sname);
		record.setSphone(sphone);
		record.setSaddress(saddress);
		record.setSdiscribe(sdiscribe);
		
		model.put("supplier", record);
		return "pages/admin/supplierManage/editSupplier";
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
	 * 新增页面跳转
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/addpage")
	public String addpage(final ModelMap model, final HttpServletRequest request){
		return "pages/admin/supplierManage/addSupplier";
	}
	
}
