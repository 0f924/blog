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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PageController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = { "/", "/index.html" })
    public String index(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size, Model model) {
        PageHelper.startPage(start, size, "id desc");
        List<Article> articles = articleService.showAllArticle();
        Map<Integer, Integer> critiqueCounts = new HashMap<Integer, Integer>();
        for (Article article : articles) {
            int AId = article.getId();
            critiqueCounts.put(AId, articleService.getCritiqueCount(AId));
        }
        PageInfo<Article> page = new PageInfo<Article>(articles);
        model.addAttribute("page", page);
        model.addAttribute("critiqueCounts", critiqueCounts);
        return "index";
    }

    @RequestMapping("/register.html")
    public String register() {
        return "register";
    }

    @RequestMapping("/login.html")
    public String login() {
        return "login";
    }

    @RequestMapping("/admin/home.html")
    public String showArticleByUser(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size, HttpServletRequest request) {
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
        return "/admin/home";
    }
}
