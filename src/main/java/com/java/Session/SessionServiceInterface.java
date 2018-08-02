package com.java.Session;

import com.java.VO.UserVo;

public interface SessionServiceInterface {
	public boolean getSession(UserVo user);
	public boolean outSession();
}
