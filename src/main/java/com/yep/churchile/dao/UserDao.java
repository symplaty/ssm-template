package com.yep.churchile.dao;

import org.springframework.stereotype.Repository;

import com.yep.churchile.pojo.User;


@Repository
public class UserDao extends BaseDao{

    public User selectByPrimaryKey(Integer id){
    	return this.getSqlSession().selectOne("com.yep.churchile.dao.UserDao.getUserById",id);
    }
}