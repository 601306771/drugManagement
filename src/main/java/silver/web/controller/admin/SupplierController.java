package silver.web.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String addSupplier(final String scode,final String sname,final String sphone,
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
			return "error";
		}
	    	
		return "userget";
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
			
		}catch(Exception e){
			return "error";
		}
		return "userget";
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
	public String updateSupplier(final Integer id,final String scode,final String sname,
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
			return "error";
		}
		return "userget";
	}
	
	/**.
	 * 根据id删除
	 * @param id
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/delectSupplier")
	public String delectSupplier(final Integer id,final ModelMap model,
			final HttpServletRequest request){
		//TODO 适配页面
		
		try{
			sb.deleteByPrimaryKey(id);
		}catch(Exception e){
			return "error";
		}
		return "userget";
	}

}
