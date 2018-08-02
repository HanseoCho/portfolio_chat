package com.java.Session;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.VO.UserVo;

@RestController
public class SessionController {
	@RequestMapping(value="/Sesion",method=RequestMethod.POST)
	public ResponseEntity<Boolean> getSession(UserVo user) {
		
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	public ResponseEntity<Boolean> outSession() {
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}	
}
