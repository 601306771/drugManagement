package silver.api.user.biz;

import silver.api.user.entity.Users;

public interface UsersBiz {
	    int deleteByPrimaryKey(Integer id);

	    int insert(Users record);

	    int insertSelective(Users record);

	    Users selectByPrimaryKey(Integer id);

	    int updateByPrimaryKeySelective(Users record);

	    int updateByPrimaryKey(Users record);
}
