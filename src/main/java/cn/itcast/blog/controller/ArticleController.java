package cn.itcast.blog.controller;

import cn.itcast.blog.pojo.Article;
import cn.itcast.blog.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

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

    @RequestMapping("/showArticleByUser")
    public String showArticleByUser(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "2") int size, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        PageHelper.startPage(start, size, "id desc");
        List<Article> articles = articleService.queryArticleByUser(username);
        Map<Integer, Integer> critiqueCounts = new HashMap<Integer, Integer>();
        for (Article article : articles) {
            int AId = article.getId();
            critiqueCounts.put(AId, articleService.getCritiqueCount(AId));
        }
        PageInfo<Article> page = new PageInfo<Article>(articles);
        request.setAttribute("page", page);
        request.setAttribute("critiqueCounts", critiqueCounts);
        return "/admin/showArticleByUser";
    }

    @RequestMapping("/showArticleByKeyword")
    public String showArticleByKeyword(String keyword,@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size, HttpServletRequest request) {
        PageHelper.startPage(start, size, "id desc");
        List<Article> articles = articleService.showArticleByKeyword(keyword);
        Map<Integer, Integer> critiqueCounts = new HashMap<Integer, Integer>();
        for (Article article : articles) {
            int AId = article.getId();
            critiqueCounts.put(AId, articleService.getCritiqueCount(AId));
        }
        PageInfo<Article> page = new PageInfo<Article>(articles);
        request.setAttribute("page", page);
        request.setAttribute("critiqueCounts", critiqueCounts);
        return "index";
    }
}
