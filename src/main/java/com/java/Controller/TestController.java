package com.java.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@RequestMapping("/test")
	public ResponseEntity<List<String>> test(HttpServletRequest req){
		List<String> test = new ArrayList<String>();
		test.add("1");
		test.add("2");
		test.add("3");
		System.out.println(req.getParameter("test"));
		return new ResponseEntity<List<String>>(test, HttpStatus.NO_CONTENT);
	}
	@RequestMapping("/test2")
	public ResponseEntity<List<HashMap<String, Object>>> test2(){
		List<HashMap<String, Object>> test = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("test1", "1");
		map.put("test2", "2");
		map.put("test3", "3");
		map.put("test4", "4");
		map.put("test5", "5");
		test.add(map);
		test.add(map);
		test.add(map);
		test.add(map);
		test.add(map);
		return new ResponseEntity<List<HashMap<String, Object>>>(test, HttpStatus.OK);
	}	
}
