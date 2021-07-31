package MVC_weibo.ssm.controller;

import MVC_weibo.ssm.Utility;
 import MVC_weibo.ssm.model.WeiboModel;
 import MVC_weibo.ssm.service.WeiboService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class WeiboController {
    private WeiboService weiboService;

    public WeiboController(WeiboService weiboService) {
        this.weiboService = weiboService;
    }

    @PostMapping("/weibo/add")
    public ModelAndView add(String content) {
        WeiboModel weibo = weiboService.add(content);
        Utility.log("weibo add id %s", weibo.getId());
        return new ModelAndView("redirect:/weibo");
    }

    @GetMapping("/weibo/delete")
    public ModelAndView delete(Integer id) {
        weiboService.delete(id);
        return new ModelAndView("redirect:/weibo");
    }

    @GetMapping("/weibo")
    public ModelAndView index() {

        List<WeiboModel> weibos = weiboService.all();
        ModelAndView m = new ModelAndView("weibo/weibo_index");
        m.addObject("weibos", weibos);
        return m;
    }

    @GetMapping("/weibo/edit")
    public ModelAndView edit(int id) {
        WeiboModel weibos = weiboService.findById(id);

        ModelAndView m = new ModelAndView("weibo/weibo_edit");
        m.addObject("weibos", weibos);
        return m;
    }

    @PostMapping("/weibo/update")
    public ModelAndView update(Integer id, String content) {

        weiboService.update(id, content);
        return new ModelAndView("redirect:/weibo");
    }
}
