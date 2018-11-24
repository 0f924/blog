package cn.itcast.blog.service;

import cn.itcast.blog.pojo.Article;

import java.util.List;

public interface ArticleService {
    public void addArticle(Article article);
    public List<Article> queryArticleByUser(String username);
}
