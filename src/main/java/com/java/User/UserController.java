package com.java.User;

import org.omg.CORBA.Request;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	UserServiceInterface usi;
	
	//유저확인
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<String> userSearch(@PathVariable("id") String id){
		return new ResponseEntity<String>(usi.selectid(id), HttpStatus.OK);
	}
	
	
}
