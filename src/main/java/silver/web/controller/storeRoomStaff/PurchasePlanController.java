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
		record = ob.selectByOcode(ocode);
		model.put("order", record);
		return "pages/storeRoomStaff/purchasePlan/purchasePlanAddOrder";   
	}

	@RequestMapping("/addItems")
	public String addItems(final Integer order_id, //维持订单信息
			final String dname, final Integer prices,final Integer quantity,final ModelMap model, 
			final HttpServletRequest request){

		
		//订单信息
		Orders order = ob.selectByPrimaryKey(order_id);
		String order_ocode = order.getOcode();
		int totalPrice = order.getPrices();
		totalPrice += prices*quantity;
		order.setPrices(totalPrice);
		ob.updateByPrimaryKey(order);
		
		//添加的条目信息
		OrdersDetails record = new OrdersDetails();
		System.out.println(dname);
		record.setDname(dname);
		record.setPrices(prices);
		record.setQuantity(quantity);
		record.setOcode(order_ocode);
		odb.insertSelective(record);
		
		//查看所有的条目
		List<OrdersDetails> ordersDetailsList= new ArrayList<OrdersDetails>();
		ordersDetailsList = odb.selectByOcode(order_ocode);
		for(int i = 0; i < ordersDetailsList.size() ; i++){
			System.out.println(ordersDetailsList.get(i));
		}
		
		model.put("order", order);
		model.put("ordersDetailsList", ordersDetailsList);
		return "pages/storeRoomStaff/purchasePlan/purchasePlanAddOrder";   
	}
	
	
	
	@RequestMapping("/deleteItems")
	public String deleteItems(final Integer orderId, final Integer orderDetailId,
			final ModelMap model, final HttpServletRequest request){
		
		//订单信息
		Orders order = ob.selectByPrimaryKey(orderId);
		
		//删除一个条目
		odb.deleteByPrimaryKey(orderDetailId);
		
		//查看所有的条目
		List<OrdersDetails> ordersDetailsList= new ArrayList<OrdersDetails>();
		ordersDetailsList = odb.selectByOcode(order.getOcode());
		
		
		model.put("order", order);
		model.put("ordersDetailsList", ordersDetailsList);
		return "pages/storeRoomStaff/purchasePlan/purchasePlanAddOrder";   
	}
	
	@RequestMapping("/show")
	public String show(final Integer orderId, 
			final ModelMap model, final HttpServletRequest request){
		
		//订单信息
		Orders order = ob.selectByPrimaryKey(orderId);
		
		
		//查看所有的条目
		List<OrdersDetails> ordersDetailsList= new ArrayList<OrdersDetails>();
		ordersDetailsList = odb.selectByOcode(order.getOcode());
		
		
		model.put("order", order);
		model.put("ordersDetailsList", ordersDetailsList);
		return "pages/storeRoomStaff/purchasePlan/purchasePlanShow";   
	}
	
	
}
