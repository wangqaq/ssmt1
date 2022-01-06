package com.cn.why.mapper;


import com.cn.why.entity.User;

import java.util.List;

public interface UserDao extends BaseDao<User> {
     User findByUsernameAndPassword(User user);
     int addText(User user);
     //删除多用户
     int delAllUser(List<String> delList);

}
