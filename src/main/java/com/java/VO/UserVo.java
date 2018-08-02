package com.java.VO;

public class UserVo {
	String regId;
	String regPw;
	String regName;
	String regInfo;
	
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	public String getRegPw() {
		return regPw;
	}
	public void setRegPw(String regPw) {
		this.regPw = regPw;
	}
	public String getRegName() {
		return regName;
	}
	public void setRegName(String regName) {
		this.regName = regName;
	}
	public String getRegInfo() {
		return regInfo;
	}
	public void setRegInfo(String regInfo) {
		this.regInfo = regInfo;
	}
	
	@Override
	public String toString() {
		return "UserVo [regId=" + regId + ", regPw=" + regPw + ", regName=" + regName + ", regInfo=" + regInfo + "]";
	}
	
	
}
