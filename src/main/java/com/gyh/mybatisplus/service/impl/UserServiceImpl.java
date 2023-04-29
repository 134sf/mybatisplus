package com.gyh.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gyh.mybatisplus.mapper.UserMapper;
import com.gyh.mybatisplus.pojo.User;
import com.gyh.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
