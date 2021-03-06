package silver.api.user.dao;

import java.util.List;

import silver.api.user.entity.Users;

public interface UsersDao {
		Users selectByName(String name);
		
		List<Users> selectByUtype(Integer utype);
		
	    int deleteByPrimaryKey(Integer id);

	    int insert(Users record);

	    int insertSelective(Users record);

	    Users selectByPrimaryKey(Integer id);

	    int updateByPrimaryKeySelective(Users record);

	    int updateByPrimaryKey(Users record);
}
