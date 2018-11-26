package cn.itcast.blog.service.impl;

import cn.itcast.blog.mapper.ArticleMapper;
import cn.itcast.blog.mapper.CritiqueMapper;
import cn.itcast.blog.pojo.Article;
import cn.itcast.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private CritiqueMapper critiqueMapper;

    @Override
    public void addArticle(Article article) {
        articleMapper.add(article);
    }

    @Override
    public void updateArticleDianjiliang(Article article) {
        articleMapper.update(article);
    }

    @Override
    public List<Article> queryArticleByUser(String username) {
        return articleMapper.queryArticleByUser(username);
    }

    @Override
    public int getCritiqueCount(int AId) {
        return critiqueMapper.queryCritiqueCount(AId);
    }

    @Override
    public List<Article> showAllArticle() {
        return articleMapper.queryAllArticle();
    }

    @Override
    public List<Article> showArticleByKeyword(String keyword) {
        return articleMapper.queryArticleByKeyword(keyword);
    }
}
