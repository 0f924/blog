package cn.itcast.blog.service;

import cn.itcast.blog.pojo.User;

public interface UserService {
    public boolean registerUser(User user);
    public boolean loginUser(User user, String[] msg);
}
