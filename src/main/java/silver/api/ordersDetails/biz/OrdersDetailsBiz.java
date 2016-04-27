package silver.api.ordersDetails.biz;

import java.util.List;

import silver.api.ordersDetails.entity.OrdersDetails;

public interface OrdersDetailsBiz {
	List<OrdersDetails> selectByOcode(String Ocode);
	
	 int deleteByPrimaryKey(Integer id);

	    int insert(OrdersDetails record);

	    int insertSelective(OrdersDetails record);

	    OrdersDetails selectByPrimaryKey(Integer id);

	    int updateByPrimaryKeySelective(OrdersDetails record);

	    int updateByPrimaryKey(OrdersDetails record);
}
