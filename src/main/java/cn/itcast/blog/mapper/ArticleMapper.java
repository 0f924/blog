package cn.itcast.blog.mapper;

import cn.itcast.blog.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {
    public void add(Article article);
}
