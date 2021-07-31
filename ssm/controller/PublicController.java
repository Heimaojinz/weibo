package MVC_weibo.ssm.controller;

import MVC_weibo.ssm.model.UserModel;
import MVC_weibo.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class PublicController {
    private UserService userService;

    public PublicController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ModelAndView index(HttpServletRequest request) {

        // model 说的是给模板引擎的 model
        // view 说的是模板名字，没有后缀
        // view 可以自动补全，也可以直接跳转

        UserModel current = userService.currentUser(request);

        ModelAndView mv = new ModelAndView("index");
        mv.addObject("username", current.getUsername());
        return mv;
    }

}
