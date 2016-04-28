package silver.web.controller.storeRoomStaff;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import silver.api.inventory.biz.InventoryBiz;
import silver.api.inventory.entity.Inventory;
import silver.api.orders.biz.OrdersBiz;
import silver.api.orders.entity.Orders;
import silver.api.ordersDetails.biz.OrdersDetailsBiz;
import silver.api.ordersDetails.entity.OrdersDetails;
import silver.api.user.entity.Users;


@Controller
@RequestMapping("/stockOut")
public class StoreOutContorller {
	
	@Autowired
	private OrdersBiz ob;
	@Autowired
	private OrdersDetailsBiz odb;
	@Autowired
	private InventoryBiz ib;
	
	@RequestMapping("/stockOutList")
	public String addSupplier(final ModelMap model,final HttpServletRequest request){
		//TODO 对页面的适配
		try{
			List<Orders> ordersList = ob.selectByState("SALESRETURN");
			model.put("ordersList", ordersList);
			System.out.println(ordersList);
		}catch(Exception e){
			return "error";
		}
		return "pages/storeRoomStaff/stockOut/stockOutOrderList";
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
	@RequestMapping("/out")
	public ModelAndView updateOrders(final Integer id,final String ocode,final Integer prices,
			final String date,final String state,final ModelMap model, 
			final HttpServletRequest request){
		
		//TODO 对页面的适配
		Calendar c = Calendar.getInstance();//获得一个日历的实例   
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
	    Date times = null;   
	    try{   
	    	times = sdf.parse(date);//初始日期   
	    }catch(Exception e){  

	    }   
	    c.setTime(times);//设置日历时间 
		Orders record = new Orders();
		record.setId(id);
		record.setOcode(ocode);
		record.setPrices(prices);
		record.setDate(c.getTime());
		record.setState(state);
		System.out.println(record);
		
		List<OrdersDetails> odtlist = odb.selectByOcode(ocode);
		
		for(int i=0; i<odtlist.size(); i++){
			String dname = odtlist.get(i).getDname();
			int quantitySubtract = odtlist.get(i).getQuantity();
			int quantityOld = ib.selectByDname(dname).getQuantity();
			int quantity = quantityOld - quantitySubtract; 
			
			Inventory it = new Inventory();
			it.setDname(dname);
			it.setQuantity(quantity);
			
			if(ib.selectByDname(dname)!=null){
				it.setId(ib.selectByDname(dname).getId());
				ib.updateByPrimaryKey(it);
			}
		}
		
		try{
			ob.updateByPrimaryKeySelective(record);
		}catch(Exception e){
			return new ModelAndView( "error");
		}
		return new ModelAndView("redirect:/stockOut/stockOutList");
		
	}

	


}
