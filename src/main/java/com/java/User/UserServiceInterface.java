package com.java.User;

import java.util.Map;

import com.java.VO.UserVo;

public interface UserServiceInterface {
	public String selectid(String id);
	public String insert(UserVo user);
	public String update(UserVo user);
	public String delete(UserVo user);
}
