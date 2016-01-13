package silver.api.user.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import silver.api.user.biz.userDao;
import silver.api.user.entity.user;
import silver.api.user.mapper.userMapper;

@Service("userService") 
public class userDaoImpl implements userDao {

	@Autowired
	private userMapper user;
	
	@Override
	public user selectByPrimaryKey() {
		// TODO Auto-generated method stub
		return user.query();
	}

}
