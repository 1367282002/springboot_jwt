package com.jwt.service.Impl;

import com.jwt.config.JwtProperties;
import com.jwt.mapper.UserMapper;
import com.jwt.pojo.User;
import com.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        User login = userMapper.login(user);

        return login;
    }


}
