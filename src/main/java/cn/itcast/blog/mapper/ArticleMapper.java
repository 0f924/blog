package cn.itcast.blog.mapper;

import cn.itcast.blog.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {
    public void add(Article article);
    public void update(Article article);
    public List<Article> queryArticleByUser(String username);
    public List<Article> queryAllArticle();
    public Article queryArticleById(int id);
    public List<Article> queryArticleByKeyword(String keyword);
}
