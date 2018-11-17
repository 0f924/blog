package cn.itcast.blog.controller;

import cn.itcast.blog.pojo.User;
import cn.itcast.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String register(User user, Model model) {
        if (user == null) return "register";

        String msg = "注册成功，请重新登录";
        if (userService.registerUser(user)) {

        } else {
            msg = "该注册名已被注册，请换个注册名注册";
        }

        model.addAttribute("msg", msg);
        return "msg";
    }

    @RequestMapping(value = "/login")
    public String login(User user, HttpSession session, Model model) {
        if (user == null) return "login";
        String msg = "登录成功";
        if (userService.loginUser(user)) {
            session.setAttribute("username", user.getUsername());
        } else {
            msg = "登录失败";
        }
        model.addAttribute("msg", msg);
        return "msg";
    }
}
