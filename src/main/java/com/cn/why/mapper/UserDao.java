package com.cn.why.mapper;


import com.cn.why.pojo.User;

public interface UserDao extends BaseDao<User> {
     User findByUsernameAndPassword(User user);
     int addText(User user);
}
