package silver.web.controller.storeRoomStaff;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import silver.api.orders.biz.OrdersBiz;
import silver.api.orders.entity.Orders;
import silver.api.ordersDetails.biz.OrdersDetailsBiz;
import silver.api.ordersDetails.entity.OrdersDetails;

@Controller
@RequestMapping("/purchasePlan")
public class PurchasePlanController {
	@Autowired
	private OrdersBiz ob;
	@Autowired
	private OrdersDetailsBiz odb;
	
	@RequestMapping("/page")
	public String page(final ModelMap model, 
			final HttpServletRequest request){
		return "pages/storeRoomStaff/purchasePlan/purchasePlanPage";   
	}
	
	@RequestMapping("/newPlan")
	public String newPlan(final ModelMap model, 
			final HttpServletRequest request){
		//TODO  PLS ADD METHOD DELET ORDERS WHICH PRICES = 0
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new java.util.Date();
		String ocode = sdf.format(date);
		Orders record = new Orders();
		record.setOcode(ocode);
		record.setDate(date);
		record.setPrices(0);
		record.setState("NEW");
		ob.insert(record);
		model.put("order", record);
		return "pages/storeRoomStaff/purchasePlan/purchasePlanAddOrder";   
	}

	@RequestMapping("/addItems")
	public String addItems(final String order_ocode, final String order_date,
			final Integer order_prices, final String order_state, final String dname, 
			final Integer prices,final Integer quantity,final ModelMap model, 
			final HttpServletRequest request){
		System.out.print(order_date);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date myDate = new Date();
		try {
			myDate = dateFormat.parse(order_date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		Orders order = new Orders();
		order.setOcode(order_ocode);
		order.setDate(myDate);
		order.setPrices(order_prices);
		order.setState(order_state);
		
		String ocode = order_ocode;
		
		OrdersDetails record = new OrdersDetails();
		record.setDname(dname);
		record.setPrices(prices);
		record.setQuantity(quantity);
		record.setOcode(ocode);
		
		List<OrdersDetails> ordersDetailsList= new ArrayList<OrdersDetails>();
		ordersDetailsList = odb.selectByOcode(ocode);
		
		model.put("order", order);
		model.put("ocode", ocode);
		model.put("ordersDetailsList", ordersDetailsList);
		System.out.print("purchasePlanAddOrder");
		return "pages/storeRoomStaff/purchasePlan/purchasePlanAddOrder";   
	}
	
	
}
