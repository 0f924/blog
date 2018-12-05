package cn.itcast.blog.mapper;

import cn.itcast.blog.pojo.BlogInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogInfoMapper {
    public BlogInfo queryBlogInfoByUsername(String username);
    public void updateBlogInfoByUsername(BlogInfo blogInfo);
    public void insertBlogInfo(BlogInfo blogInfo);
}
