package silver.web.controller.doctor;

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
import silver.api.sellOrder.biz.SellOrderBiz;
import silver.api.sellOrder.entity.SellOrder;
import silver.api.sellOrderDetail.biz.SellOrderDetailBiz;
import silver.api.sellOrderDetail.entity.SellOrderDetail;


@Controller
@RequestMapping("/prescribe")
public class DoctorContorller {
	
	@Autowired
	private SellOrderBiz sob;
	@Autowired
	private SellOrderDetailBiz sodb;
	@Autowired
	private InventoryBiz ib;

	
	@RequestMapping("/select")
	public String select(final ModelMap model,final HttpServletRequest request){
		return "pages/doctor/prescribe/select";
	}
	
	
	@RequestMapping("/page")
	public String page(final ModelMap model,final HttpServletRequest request){
		
		//新建一个药方
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new java.util.Date();
		String so_code = sdf.format(date);
		SellOrder record = new SellOrder();
		record.setSoCode(so_code);
		record.setDay(date);
		sob.insert(record);
		
		//获得库存
		List<Inventory> inventoryList = ib.selectAll();
		model.put("inventoryList", inventoryList);
		
		record = sob.selectBySocode(so_code);
		model.put("sellOrder", record);
		  
		
		return "pages/doctor/prescribe/prescribe";
	}

	
	@RequestMapping("/addItems")
	public String addItems(final Integer sellOrderId, //维持订单信息
			final String dname,final Integer quantity,final ModelMap model, 
			final HttpServletRequest request){

		
		//订单信息更新
		SellOrder sellOrder = sob.selectByPrimaryKey(sellOrderId);
		String socode = sellOrder.getSoCode();
		sob.updateByPrimaryKey(sellOrder);
		
		Date day = sellOrder.getDay();
		
		//添加的条目信息
		SellOrderDetail record = new SellOrderDetail();
		record.setDrugName(dname);
		record.setQuantity(quantity);
		record.setSoCode(socode);
		sodb.insertSelective(record);
		
		//查看所有的条目
		List<SellOrderDetail> sellOrderDetailList= new ArrayList<SellOrderDetail>();
		sellOrderDetailList = sodb.selectBySocode(socode);
		for(int i = 0; i < sellOrderDetailList.size() ; i++){
			System.out.println(sellOrderDetailList.get(i));
		}
		
		
		//获得库存
		List<Inventory> inventoryList = ib.selectAll();
				
		model.put("inventoryList", inventoryList);
		model.put("sellOrder", sellOrder);
		model.put("sellOrderDetailList", sellOrderDetailList);
		return "pages/doctor/prescribe/prescribe";   
	}

	
	@RequestMapping("/deleteItems")
	public String deleteItems(final Integer sellOrderId, final Integer sellOrderDetailId,
			final ModelMap model, final HttpServletRequest request){
		
		//订单信息
		SellOrder sellOrder = sob.selectByPrimaryKey(sellOrderId);
		
		//删除一个条目
		sodb.deleteByPrimaryKey(sellOrderDetailId);
		
		
		//查看所有的条目
		List<SellOrderDetail> sellOrderDetailList= new ArrayList<SellOrderDetail>();
		sellOrderDetailList = sodb.selectBySocode(sellOrder.getSoCode());
		
		//获得库存
		List<Inventory> inventoryList = ib.selectAll();
				
		model.put("inventoryList", inventoryList);
		model.put("sellOrder", sellOrder);
		model.put("sellOrderDetailList", sellOrderDetailList);
		return "pages/doctor/prescribe/prescribe";    
	}
	
	@RequestMapping("/finish")
	public ModelAndView finish(final Integer sellOrderId,
			final ModelMap model, final HttpServletRequest request){
		//根据订单号获取所有的条目
		SellOrder sellOrder = sob.selectByPrimaryKey(sellOrderId);

		
		//更新订单状态
		sellOrder.setState("NEW");
		sob.updateByPrimaryKey(sellOrder);
		
		
		
		
		return new ModelAndView("redirect:/welCome/pharmacyStaff");
	}


}
