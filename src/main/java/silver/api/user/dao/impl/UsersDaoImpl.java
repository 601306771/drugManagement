package silver.api.user.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import silver.api.user.dao.UsersDao;
import silver.api.user.entity.Users;
import silver.api.user.mapper.UsersMapper;

@Component
public class UsersDaoImpl implements UsersDao {
	
	@Autowired
	private UsersMapper uMapper;
	

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return uMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Users record) {
		return uMapper.insert(record);
	}

	@Override
	public int insertSelective(Users record) {
		System.out.print("dao"+record);
		return uMapper.insertSelective(record);
	}

	@Override
	public Users selectByPrimaryKey(Integer id) {
		return uMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Users record) {
	
		return uMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Users record) {
		return uMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Users> selectByUtype(Integer utype) {
		return uMapper.selectByUtype(utype);
	}

	@Override
	public Users selectByName(String name) {
		return uMapper.selectByName(name);
	}

}
