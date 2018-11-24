package cn.itcast.blog.controller;

import cn.itcast.blog.pojo.Article;
import cn.itcast.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/addArticle")
    public String addArticle(String title, String content, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        Article article = new Article();
        article.setUsername(username);
        article.setTitle(title);
        article.setContent(content);
        article.setDate(new Date());
        article.setHasread(0);
        articleService.addArticle(article);
        String msg = "添加文章成功";
        request.setAttribute("msg", msg);
        return "/msg";
    }
}
