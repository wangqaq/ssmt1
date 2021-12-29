package com.cn.why.mapper;


import com.cn.why.entity.User;

public interface UserDao extends BaseDao<User> {
     User findByUsernameAndPassword(User user);
     int addText(User user);
}
