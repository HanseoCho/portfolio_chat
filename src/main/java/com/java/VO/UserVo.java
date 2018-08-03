package com.java.VO;

public class UserVo {
	private String uId;
	private String uPw;
	private String uName;
	private String uInfo;
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getuPw() {
		return uPw;
	}
	public void setuPw(String uPw) {
		this.uPw = uPw;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuInfo() {
		return uInfo;
	}
	public void setuInfo(String uInfo) {
		this.uInfo = uInfo;
	}
	@Override
	public String toString() {
		return "UserVo [uId=" + uId + ", uPw=" + uPw + ", uName=" + uName + ", uInfo=" + uInfo + "]";
	}
}
