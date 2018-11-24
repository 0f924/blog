package cn.itcast.blog.controller;

import cn.itcast.blog.pojo.User;
import cn.itcast.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

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

    @RequestMapping(value = "/photoUpload", method = RequestMethod.POST)
    public @ResponseBody String photoUpload(HttpServletRequest request, MultipartFile file) {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        File imageDir = new File(session.getServletContext().getRealPath("/user/photo/" + username));
        if (!imageDir.exists()) imageDir.mkdirs();
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String filename = UUID.randomUUID().toString().replaceAll("-", "") + suffix;
        try {
            if (!file.isEmpty()) file.transferTo(new File(imageDir, filename));
        } catch (IOException e) {
            e.printStackTrace();
            return "上传图片失败";
        }
        return "上传图片成功";
    }

    @RequestMapping("/showPhoto")
    public String showPhoto(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String photoPath = session.getServletContext().getRealPath("/user/photo/" + username);
        File fphotpPath = new File(photoPath);
        String[] photoList = fphotpPath.list();
        request.setAttribute("photoList", photoList);
        return "/admin/showPhoto";
    }
}
