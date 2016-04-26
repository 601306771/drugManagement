package silver.api.ordersDetails.dao;

import java.util.List;

import silver.api.ordersDetails.entity.OrdersDetails;
import silver.api.ordersDetails.entity.OrdersDetailsKey;

public interface OrdersDetailsDao {
	List<OrdersDetails> selectByOcode(String Ocode);
	
    int deleteByPrimaryKey(OrdersDetailsKey key);

    int insert(OrdersDetails record);

    int insertSelective(OrdersDetails record);

    OrdersDetails selectByPrimaryKey(OrdersDetailsKey key);

    int updateByPrimaryKeySelective(OrdersDetails record);

    int updateByPrimaryKey(OrdersDetails record);
}
