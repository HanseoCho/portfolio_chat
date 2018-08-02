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
	
	//유저확인
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET)
	public ResponseEntity<String> userSearch(@PathVariable("id") String id){
		return new ResponseEntity<String>(usi.selectid(id), HttpStatus.OK);
	}
	
	//회원가입
	@RequestMapping(value="/user",method=RequestMethod.POST)	
	public ResponseEntity<String> userinsert(UserVo user){
		return new ResponseEntity<String>(usi.insert(user), HttpStatus.OK);
	}
}
