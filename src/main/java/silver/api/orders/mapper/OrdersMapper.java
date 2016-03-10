package silver.api.orders.mapper;

import java.util.List;

import silver.api.orders.entity.Orders;

public interface OrdersMapper {
	List<Orders> selectByState(String state);
	
    int deleteByPrimaryKey(Integer id);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
}