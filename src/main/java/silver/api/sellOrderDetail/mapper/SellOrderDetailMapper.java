package silver.api.sellOrderDetail.mapper;

import java.util.List;

import silver.api.sellOrderDetail.entity.SellOrderDetail;

public interface SellOrderDetailMapper {
	List<SellOrderDetail> selectBySocode(String socode);
	
    int deleteByPrimaryKey(Integer id);

    int insert(SellOrderDetail record);

    int insertSelective(SellOrderDetail record);

    SellOrderDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SellOrderDetail record);

    int updateByPrimaryKey(SellOrderDetail record);
}