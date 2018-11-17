package cn.itcast.blog.mapper;

import cn.itcast.blog.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public void add(User user);
    public User queryById(String username);
}
