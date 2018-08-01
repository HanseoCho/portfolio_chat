package com.java.User;

import java.util.HashMap;

import com.java.DAO.Dao;
import com.java.DAO.DaoInterface;

public class UserService implements UserServiceInterface {
	DaoInterface di;
	@Override
	public String selectid(String id) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("sql", "selectOne");
		param.put("sqltype", "user.selectId");
		param.put("id",id);
		return (String) di.call(param) == null?"비중복":"중복";
	}

}
