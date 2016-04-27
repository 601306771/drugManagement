package silver.api.ordersDetails.mapper;

import java.util.List;

import silver.api.ordersDetails.entity.OrdersDetails;

public interface OrdersDetailsMapper {
	List<OrdersDetails> selectByOcode(String Ocode);
	
	 int deleteByPrimaryKey(Integer id);

	    int insert(OrdersDetails record);

	    int insertSelective(OrdersDetails record);

	    OrdersDetails selectByPrimaryKey(Integer id);

	    int updateByPrimaryKeySelective(OrdersDetails record);

	    int updateByPrimaryKey(OrdersDetails record);
}