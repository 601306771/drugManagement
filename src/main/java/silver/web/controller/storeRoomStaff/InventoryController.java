package silver.web.controller.storeRoomStaff;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import silver.api.inventory.biz.InventoryBiz;
import silver.api.inventory.entity.Inventory;

@Controller
@RequestMapping("/Inventory")
public class InventoryController {
	@Autowired
	private InventoryBiz ib;
	
	@RequestMapping("/page")
	public String page(final ModelMap model,final HttpServletRequest request){
		List<Inventory> records =  ib.selectAll();
		model.put("inventoryList", records);
 		
		return "pages/storeRoomStaff/inventory/InventoryPage";
	}
	
}
