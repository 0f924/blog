package cn.itcast.blog.controller;

import cn.itcast.blog.mapper.BlogInfoMapper;
import cn.itcast.blog.pojo.BlogInfo;
import cn.itcast.blog.pojo.User;
import cn.itcast.blog.service.BlogInfoService;
import cn.itcast.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BlogInfoService blogInfoService;

    @RequestMapping("/register")
    public String register(User user, Model model) {
        if (userService.registerUser(user)) return "info/register_success";
        return "info/register_failure";
    }

    @RequestMapping(value = "/login")
    public String login(User user, HttpSession session, Model model) {
        String[] msg = new String[1];
        if (userService.loginUser(user, msg)) {
            session.setAttribute("username", user.getUsername());
            BlogInfo blogInfo = blogInfoService.getBlogInfo(user.getUsername());
            session.setAttribute("blogInfo", blogInfo);
            return "info/login_success";
        } else {
            model.addAttribute("msg", msg[0]);
            return "info/login_failure";
        }
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

    @RequestMapping(value = "/editBlogInfo", method = RequestMethod.POST)
    public void editBlogInfoByUsername(HttpServletRequest request, HttpServletResponse response, String blogtitle, String idiograph) throws IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        BlogInfo blogInfo = new BlogInfo();
        blogInfo.setUsername(username);
        blogInfo.setBlogtitle(blogtitle);
        blogInfo.setIdiograph(idiograph);
        blogInfoService.editBlogInfo(blogInfo);
        response.sendRedirect("/blog/admin/home.html");
    }
}
