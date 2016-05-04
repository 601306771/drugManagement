package silver.api.user.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import silver.api.user.biz.UsersBiz;
import silver.api.user.dao.UsersDao;
import silver.api.user.entity.Users;

@Service
public class UsersBizImpl implements UsersBiz {

	@Autowired
	private UsersDao uDao;
	

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return uDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Users record) {
		return uDao.insert(record);
	}

	@Override
	public int insertSelective(Users record) {
		System.out.print("biz"+record);
		return uDao.insertSelective(record);
	}

	@Override
	public Users selectByPrimaryKey(Integer id) {
		return uDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Users record) {
		return uDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Users record) {
		return uDao.updateByPrimaryKey(record);
	}

	@Override
	public List<Users> selectByUtype(Integer utype) {
		return uDao.selectByUtype(utype);
	}

	@Override
	public Users selectByName(String name) {
		return uDao.selectByName(name);
	}

}
