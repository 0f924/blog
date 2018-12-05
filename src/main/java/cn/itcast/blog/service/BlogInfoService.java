package cn.itcast.blog.service;

import cn.itcast.blog.pojo.BlogInfo;


public interface BlogInfoService {
    public BlogInfo getBlogInfo(String username);
    public void editBlogInfo(BlogInfo blogInfo);
}
