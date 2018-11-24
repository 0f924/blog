package cn.itcast.blog.service.impl;

import cn.itcast.blog.mapper.ArticleMapper;
import cn.itcast.blog.pojo.Article;
import cn.itcast.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void addArticle(Article article) {
        articleMapper.add(article);
    }

    @Override
    public List<Article> queryArticleByUser(String username) {
        return articleMapper.queryArticleByUser(username);
    }
}
