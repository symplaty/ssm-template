package com.yep.churchile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yep.churchile.pojo.User;
import com.yep.churchile.service.UserServiceInterface;
import com.yep.churchile.utils.ResultData;

@Controller 
@RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = "/user", produces = "application/json;charset=UTF-8")
public class UserController {

	@Autowired
	UserServiceInterface userService;
	
	@ResponseBody
	@RequestMapping("/getuser")
	public ResultData<User> getUserByUserId(){
		try{
			ResultData<User> user = userService.getUserById(614161258);
			
			System.out.println(user);

			if(!user.isSuccessful()){
				
			}
			return user;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	} 
}
