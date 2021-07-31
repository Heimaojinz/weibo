package MVC_weibo.ssm.controller;


import MVC_weibo.ssm.service.UserService;
import MVC_weibo.ssm.Utility;
import MVC_weibo.ssm.model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public ModelAndView loginView() {
        ModelAndView m = new ModelAndView("user/login");
        return m;
    }

    @GetMapping("/register")
    public ModelAndView registerView() {
        ModelAndView m = new ModelAndView("user/register");
        return m;
    }

    @PostMapping("/user/add")
    public ModelAndView register(String username, String password) {
        userService.add(username, password);
        return new ModelAndView("redirect:/login");
    }

    @PostMapping("/user/login")
    public ModelAndView login(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserModel user = userService.findByUsername(username);
        if (userService.validateLogin(username, password)) {
            Utility.log("登录成功: %s", user);
            HttpSession session = request.getSession();
            session.setAttribute("user_id", user.getId());            
            return new ModelAndView("redirect:/");
        } else {
            return new ModelAndView("redirect:/login");
        }

    }
}
