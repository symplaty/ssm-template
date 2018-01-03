package com.yep.churchile.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yep.churchile.dao.UserDao;
import com.yep.churchile.pojo.User;
import com.yep.churchile.service.UserServiceInterface;
import com.yep.churchile.utils.ResultData;

@Service
public class UserServiceImpl implements UserServiceInterface {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;

	public ResultData<User> getUserById(Integer userid) {
		LOGGER.info("sdasdasd,userid={}", userid);
		LOGGER.info("sdasdasd,a={}", this.userDao.selectByPrimaryKey(userid));

		return ResultData.ok(this.userDao.selectByPrimaryKey(userid));
	}

	public Integer insert(User user) {
		return null;
	}

}
