package com.java.DAO;

import java.util.HashMap;
import java.util.Map;

import com.java.VO.UserVo;

public interface DaoInterface {
	public Object call(HashMap<String, Object> param);
	public Object userCall(Map<String, Object> param,UserVo user);
}
