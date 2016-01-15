package silver.api.user.mapper;

import java.util.List;

import silver.api.user.entity.Users;

public interface UsersMapper {
	List<Users> selectByUtype(Integer utype);
	
    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}