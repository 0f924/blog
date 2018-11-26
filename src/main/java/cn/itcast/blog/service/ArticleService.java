package cn.itcast.blog.service;

import cn.itcast.blog.pojo.Article;

import java.util.List;

public interface ArticleService {
    public void addArticle(Article article);
    public void updateArticleDianjiliang(Article article);
    public List<Article> queryArticleByUser(String username);
    public int getCritiqueCount(int AId);
    public List<Article> showAllArticle();
    public List<Article> showArticleByKeyword(String keyword);
}
