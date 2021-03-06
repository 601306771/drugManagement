package silver.web.controller.PharmacyStaff;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import silver.api.orders.entity.Orders;
import silver.api.ordersDetails.entity.OrdersDetails;
import silver.api.sellOrder.biz.SellOrderBiz;
import silver.api.sellOrder.entity.SellOrder;
import silver.api.sellOrderDetail.biz.SellOrderDetailBiz;
import silver.api.sellOrderDetail.entity.SellOrderDetail;


@Controller
@RequestMapping("/dispensing")
public class DispensingContorller {
	
	@Autowired
	private SellOrderBiz sob;
	@Autowired
	private SellOrderDetailBiz sodb;
	@Autowired
	private InventoryBiz ib;
	
	@RequestMapping("/page")
	public String page(final ModelMap model,final HttpServletRequest request){
		
		List<SellOrder> sellOrderList = sob.selectByState("NEW");
		model.put("sellOrderList", sellOrderList);
		
		return "pages/pharmacyStaff/dispensing/newDispensing";
	}
	
	
	
	@RequestMapping("/done")
	public String dispensing(final Integer id , final ModelMap model,final HttpServletRequest request){
		//修改已发药的状态
		SellOrder record = sob.selectByPrimaryKey(id);
		record.setState("DONE");
		sob.updateByPrimaryKey(record);
		
		//更新库存
		List<SellOrderDetail> sellOrderDetailList= new ArrayList<SellOrderDetail>();
		sellOrderDetailList = sodb.selectBySocode(record.getSoCode());
		for(int i=0; i<sellOrderDetailList.size(); i++){
			String dname = sellOrderDetailList.get(i).getDrugName();
			int quantity = sellOrderDetailList.get(i).getQuantity();
			
			Inventory it = ib.selectByDname(dname);
			int newQuantity = it.getQuantity() - quantity;
			it.setQuantity(newQuantity);
			ib.updateByPrimaryKey(it);
		}
		
		
		//查询没有发药的列表
		List<SellOrder> sellOrderList = sob.selectByState("NEW");
		model.put("sellOrderList", sellOrderList);
		
		return "pages/pharmacyStaff/dispensing/newDispensing";
	}
	
	@RequestMapping("/show")
	public String show(final Integer id , final ModelMap model,final HttpServletRequest request){
		//订单信息
		SellOrder record = sob.selectByPrimaryKey(id);
		String socode = record.getSoCode();
		
		//查看所有的条目
		List<SellOrderDetail> sellOrderDetailList= new ArrayList<SellOrderDetail>();
		sellOrderDetailList = sodb.selectBySocode(socode);
		
		model.put("sellOrder", record);
		model.put("sellOrderDetailList", sellOrderDetailList);
		
		return "pages/pharmacyStaff/dispensing/show";
	}

	
	@RequestMapping("/addItems")
	public String addItems(final Integer sellOrderId, //维持订单信息
			final String dname, final Integer price,final Integer quantity,final ModelMap model, 
			final HttpServletRequest request){

		
		//订单信息更新
		SellOrder sellOrder = sob.selectByPrimaryKey(sellOrderId);
		String socode = sellOrder.getSoCode();
		Float totalPrice = sellOrder.getPrice();
		totalPrice += price*quantity;
		sellOrder.setPrice(totalPrice);
		sob.updateByPrimaryKey(sellOrder);
		
		Date day = sellOrder.getDay();
		
		//添加的条目信息
		SellOrderDetail record = new SellOrderDetail();
		record.setDrugName(dname);
		record.setPrice((float)price);
		record.setQuantity(quantity);
		record.setSoCode(socode);
		sodb.insertSelective(record);
		
		//查看所有的条目
		List<SellOrderDetail> sellOrderDetailList= new ArrayList<SellOrderDetail>();
		sellOrderDetailList = sodb.selectBySocode(socode);
		for(int i = 0; i < sellOrderDetailList.size() ; i++){
			System.out.println(sellOrderDetailList.get(i));
		}
		
		model.put("sellOrder", sellOrder);
		model.put("sellOrderDetailList", sellOrderDetailList);
		return "pages/pharmacyStaff/dispensing/newDispensing";   
	}

	
	@RequestMapping("/deleteItems")
	public String deleteItems(final Integer sellOrderId, final Integer sellOrderDetailId,
			final ModelMap model, final HttpServletRequest request){
		
		//订单信息
		SellOrder sellOrder = sob.selectByPrimaryKey(sellOrderId);
		
		//要删除的条目价格移除
		Float totalPrice = sellOrder.getPrice();
		SellOrderDetail oneRecord = sodb.selectByPrimaryKey(sellOrderDetailId);
		totalPrice -= oneRecord.getPrice()*oneRecord.getQuantity();
		sellOrder.setPrice(totalPrice);
		sob.updateByPrimaryKey(sellOrder);
		
		
		//删除一个条目
		sodb.deleteByPrimaryKey(sellOrderDetailId);
		
		
		//查看所有的条目
		List<SellOrderDetail> sellOrderDetailList= new ArrayList<SellOrderDetail>();
		sellOrderDetailList = sodb.selectBySocode(sellOrder.getSoCode());
		
		
		model.put("sellOrder", sellOrder);
		model.put("sellOrderDetailList", sellOrderDetailList);
		return "pages/pharmacyStaff/dispensing/newDispensing";    
	}
	
	@RequestMapping("/finish")
	public ModelAndView finish(final Integer sellOrderId,
			final ModelMap model, final HttpServletRequest request){
		//所有的条目
		SellOrder sellOrder = sob.selectByPrimaryKey(sellOrderId);
		List<SellOrderDetail> sellOrderDetailList= new ArrayList<SellOrderDetail>();
		sellOrderDetailList = sodb.selectBySocode(sellOrder.getSoCode());
		
		for(int i=0; i<sellOrderDetailList.size(); i++){
			String dname = sellOrderDetailList.get(i).getDrugName();
			int quantity = sellOrderDetailList.get(i).getQuantity();
			
			Inventory it = ib.selectByDname(dname);
			int newQuantity = it.getQuantity() - quantity;
			it.setQuantity(newQuantity);
			ib.updateByPrimaryKey(it);
		}
		
		return new ModelAndView("redirect:/welCome/pharmacyStaff");
	}


}
