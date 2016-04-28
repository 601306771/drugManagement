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

import silver.api.inventory.entity.Inventory;
import silver.api.orders.biz.OrdersBiz;
import silver.api.orders.entity.Orders;
import silver.api.ordersDetails.entity.OrdersDetails;

@Controller
@RequestMapping("/salesReturn")
public class SalesReturnController {
	@Autowired
	private OrdersBiz ob;
	
	@RequestMapping("/page")
	public String addSupplier(final ModelMap model,final HttpServletRequest request){
		//TODO 对页面的适配
		try{
			List<Orders> ordersList = ob.selectByState("STOCKIN");
			model.put("ordersList", ordersList);
			System.out.println(ordersList);
		}catch(Exception e){
			return "error";
		}
		return "pages/storeRoomStaff/salesReturn/salesReturnOrderList";
	}
	
	@RequestMapping("/return")
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
		
		
		try{
			ob.updateByPrimaryKeySelective(record);
		}catch(Exception e){
			return new ModelAndView( "error");
		}
		return new ModelAndView("redirect:/salesReturn/page");
		
	}
}
