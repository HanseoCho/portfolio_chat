package com.java.User;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.java.DAO.Dao;
import com.java.DAO.DaoInterface;
import com.java.Util.MapUtil;
import com.java.VO.UserVo;

@Service
public class UserService implements UserServiceInterface {
	@Inject
	DaoInterface di;
	@Override
	public String selectid(String id) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("sql", "selectOne");
		param.put("sqlType", "user.selectId");
		UserVo user = new UserVo();
		user.setRegId(id);
		return (HashMap<String, Object>) di.userCall(param,user) == null?"비중복":"중복";
	}
	@Override
	public String insert(UserVo user) {
		try {
		Map<String, Object> param = MapUtil.makeParam("insert", "user.insert");
		di.userCall(param, user);
		return "가입성공";
		}catch (Exception e) {
			e.printStackTrace();
			return "가입실패";
		}
		
	}

}
