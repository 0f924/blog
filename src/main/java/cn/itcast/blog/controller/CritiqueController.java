package cn.itcast.blog.controller;

import cn.itcast.blog.pojo.Critique;
import cn.itcast.blog.service.CritiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/critique")
public class CritiqueController {
    @Autowired
    private CritiqueService critiqueService;

    @RequestMapping("/addCritique")
    public String addCritique(String content, int AId, HttpSession session) {
        String username = (String) session.getAttribute("username");
        username = username != null ? username : "匿名";
        Critique critique = new Critique();
        critique.setAId(AId);
        critique.setContent(content);
        critique.setUsername(username);
        critiqueService.addCritique(critique);
        return "redirect:/article/readArticle?AId=" + AId;
    }
}
