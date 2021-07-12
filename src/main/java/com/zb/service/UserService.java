package com.zb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zb.entity.User;

import java.util.List;

/**
*
*/
public interface UserService extends IService<User> {

    User login(User user);

    List<User> findAll();

    User findById(Integer userId);

}
