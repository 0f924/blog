package cn.itcast.blog.service.impl;

import cn.itcast.blog.mapper.BlogInfoMapper;
import cn.itcast.blog.pojo.BlogInfo;
import cn.itcast.blog.service.BlogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogInfoServiceImpl implements BlogInfoService {
    @Autowired
    private BlogInfoMapper blogInfoMapper;

    @Override
    public BlogInfo getBlogInfo(String username) {
        return blogInfoMapper.queryBlogInfoByUsername(username);
    }

    @Override
    public void editBlogInfo(BlogInfo blogInfo) {
        String username = blogInfo.getUsername();
        if (getBlogInfo(username) != null) {
            blogInfoMapper.updateBlogInfoByUsername(blogInfo);
        } else {
            blogInfoMapper.insertBlogInfo(blogInfo);
        }
    }
}
