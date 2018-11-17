package cn.itcast.blog.service.impl;

import cn.itcast.blog.mapper.UserMapper;
import cn.itcast.blog.pojo.User;
import cn.itcast.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean registerUser(User user) {
        if (userMapper.queryById(user.getUsername()) != null) {
            return false;
        } else {
            userMapper.add(user);
            return true;
        }
    }

    @Override
    public boolean loginUser(User user) {
        if (userMapper.queryById(user.getUsername()) == null) {
            return false;
        } else {
            User queryUser = userMapper.queryById(user.getUsername());
            if (queryUser.getPassword().equals(user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
}
