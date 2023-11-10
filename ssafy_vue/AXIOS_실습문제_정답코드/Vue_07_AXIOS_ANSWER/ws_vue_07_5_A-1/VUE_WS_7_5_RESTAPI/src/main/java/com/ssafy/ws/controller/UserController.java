package com.ssafy.ws.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ws.model.User;
import com.ssafy.ws.model.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/userapi")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
		
	@PostMapping(value = "/login")
	@ApiOperation(value = "로그인을 하고 로그인한 유저의 정보를 반환한다.", response = User.class)
	public ResponseEntity<?> login(@RequestBody Map<String, Object> paramMap, 
			HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String,Object> user = userService.login(paramMap);
		System.out.println(paramMap);
		System.out.println("user:");
		System.out.println(user);
		if (user != null) {
			session.setAttribute("userinfo", user);			
			ResponseEntity<Map<String,Object>> entity = new ResponseEntity<Map<String, Object>>(user, HttpStatus.OK);
			System.out.println("found user");
			return entity;
			
		} else {
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	
	@PostMapping(value="/check-password")
	@ApiOperation(value = "비밀번호가 맞는지 검사하여 유효하면 true를 반환한다. ", response = Boolean.class)
	public ResponseEntity<?> checkPassword(@RequestBody Map<String, Object> map){
		Boolean check = userService.checkPassword(map);
		if(check) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	
	@PostMapping(value="/signup")
	@ApiOperation(value = "회원가입을 하고 유저 정보를 반환한다", response = User.class)
	public ResponseEntity<?> signup(@RequestBody Map<String,Object> paramMap) throws Exception {
		System.out.println(paramMap);
		userService.insertUser(paramMap);
		Map<String,Object> user = userService.login(paramMap);
		ResponseEntity<Map<String,Object>> entity = new ResponseEntity<Map<String, Object>>(user,HttpStatus.OK);
		return entity; 
	}
	
	@PutMapping(value="")
	@ApiOperation(value = "유저 정보를 변경한다")
	public boolean updateUser(@RequestBody Map<String,Object> map) throws Exception {
		return userService.updateUser(map);
	}
	
	@DeleteMapping(value="/{userSeq}")
	@ApiOperation(value = "유저 정보를 삭제한다")
	public boolean deleteUser(@PathVariable int userSeq) {
		return userService.deleteUser(userSeq);
	}
	
	
}
