package cn.itcast.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/")
    public String index() {
        return "login";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/admin/addArticle")
    public String addArticle() {
        return "admin/addArticle";
    }

    @RequestMapping("/admin/showArticleByUser")
    public String showArticleByUser() {
        return "admin/showArticleByUser";
    }

    @RequestMapping("/admin/photoUpload")
    public String photoUpload() {
        return "admin/photoUpload";
    }

    @RequestMapping("/admin/showPhoto")
    public String showPhoto() {
        return "admin/showPhoto";
    }
}
