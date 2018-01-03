package com.yep.churchile.service;

import org.springframework.stereotype.Service;

import com.yep.churchile.pojo.User;
import com.yep.churchile.utils.ResultData;


@Service
public interface UserServiceInterface {
   public ResultData<User> getUserById(Integer userId);
   public Integer insert(User user);
}
