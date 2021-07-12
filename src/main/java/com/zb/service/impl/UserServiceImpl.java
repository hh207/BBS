package com.zb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zb.Exception.MyException;
import com.zb.entity.User;
import com.zb.service.UserService;
import com.zb.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
*
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        if (user != null){
            LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            lambdaQueryWrapper.like(User::getName, user.getName());
            User sqlUser = userMapper.selectOne(lambdaQueryWrapper);
            if (sqlUser == null){
                throw new MyException("用户名错误！");
            }
            if (!sqlUser.getPassword().equals(user.getPassword())){
                throw new MyException("密码错误！");
            }
            return sqlUser;
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return userMapper.selectList(null);
    }

    @Override
    public User findById(Integer userId) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getId, userId);
        return userMapper.selectOne(lambdaQueryWrapper);
    }
}
