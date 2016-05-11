package silver.web.controller.storeRoomStaff;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import silver.api.inventory.biz.InventoryBiz;
import silver.api.inventory.entity.Inventory;
import silver.api.orders.entity.Orders;

@Controller
@RequestMapping("/breakage")
public class BreakageControllor {
	@Autowired
	private InventoryBiz ib;
	
	@RequestMapping("/page")
	public String page(final ModelMap model,final HttpServletRequest request){
		//获得库存
		List<Inventory> inventoryList = ib.selectAll();
		model.put("inventoryList", inventoryList);
		return "pages/storeRoomStaff/breakage/breakagePage";
	}
	
	@RequestMapping("/sureBreak")
	public String sureBreak(final String dname, final Integer quantity,
			final ModelMap model,final HttpServletRequest request){	
		if(dname!=null && quantity!=null){
			Inventory it = ib.selectByDname(dname);
			int newQuantity = it.getQuantity() - quantity;
			it.setQuantity(newQuantity);
			ib.updateByPrimaryKey(it);
			//获得库存
			List<Inventory> inventoryList = ib.selectAll();
			model.put("inventoryList", inventoryList);
			
			model.put("it", it);
			model.put("breakOk", "breakOk");
			return "pages/storeRoomStaff/breakage/breakagePage";
		}
		//获得库存
		List<Inventory> inventoryList = ib.selectAll();
		model.put("inventoryList", inventoryList);
		model.put("breakFail", "breakFail");
		return "pages/storeRoomStaff/breakage/breakagePage";
	}
	
}
