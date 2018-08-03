package com.java.User;

import javax.inject.Inject;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.VO.UserVo;

@RestController
public class UserController {
	@Inject
	UserServiceInterface usi;
	
	//유저아이디 확인
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET)
	public ResponseEntity<String> userSearch(@PathVariable("id") String id){
		return new ResponseEntity<String>(usi.selectid(id), HttpStatus.OK);
	}
	
	//회원가입
	@RequestMapping(value="/user",method=RequestMethod.POST)	
	public ResponseEntity<String> userinsert(UserVo user){
		return new ResponseEntity<String>(usi.insert(user), HttpStatus.OK);
	}
	
	//회원수정 (수정은 패스워드와 이름 자기소개 부분만 아이디로 구분)
	@RequestMapping(value="/user",method=RequestMethod.PUT)	
	public ResponseEntity<String> userUpdate(UserVo user){
		return new ResponseEntity<String>(usi.update(user), HttpStatus.OK);
	}	
	//회원탈퇴(아이디로 delYn확인후 삭제)
	@RequestMapping(value="/user/{id}",method=RequestMethod.DELETE)	
	public ResponseEntity<String> userDelete(UserVo user){
		return new ResponseEntity<String>(usi.delete(user), HttpStatus.OK);
	}	

	//로그인 (파라미터 ID와 PW)
	@RequestMapping(value="/Sesion",method=RequestMethod.POST)
	public ResponseEntity<Boolean> getSession(UserVo user) {
		
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	//로그아웃
	@RequestMapping(value="/Sesion",method=RequestMethod.GET)
	public ResponseEntity<Boolean> outSession() {
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
