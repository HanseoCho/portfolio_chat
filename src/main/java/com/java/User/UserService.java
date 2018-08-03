package com.java.User;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.java.Controller.HomeController;
import com.java.DAO.Dao;
import com.java.DAO.DaoInterface;
import com.java.Util.MapUtil;
import com.java.VO.UserVo;

@Service
public class UserService implements UserServiceInterface {
	@Inject
	DaoInterface di;
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);	
	@Override
	public String selectid(String id) {
		try {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("sql", "selectOne");
		param.put("sqlType", "user.selectId");
		UserVo user = new UserVo();
		user.setuId(id);
		return (HashMap<String, Object>) di.userCall(param,user) == null?"비중복":"중복";
		}
		catch (Exception e) {
			e.printStackTrace();
			logger.info("selectid메소드 문제발생");
			return "101";
		}
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
	@Override
	public String update(UserVo user) {
		try {
		Map<String, Object> param = MapUtil.makeParam("update", "user.update");
		String result = (int) di.userCall(param, user)==1?"성공":"실패";
		return result;
		}catch (Exception e) {
			e.printStackTrace();
			return "102";
		}
	}
	@Override
	public String delete(UserVo user) {
		try {
		Map<String, Object> param = MapUtil.makeParam("delete", "user.update");
		String result = (int) di.userCall(param, user)==1?"성공":"실패";
		return result;
		}catch (Exception e) {
			e.printStackTrace();
			return "103";
		}
	}

}
