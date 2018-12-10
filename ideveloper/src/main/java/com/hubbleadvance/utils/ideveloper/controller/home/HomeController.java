package com.hubbleadvance.utils.ideveloper.controller.home;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hubbleadvance.utils.ideveloper.controller.BaseController;
@Controller
public class HomeController extends BaseController{
    
    @RequestMapping(value="/home")
    public String home(HttpServletRequest req, Model model) {
        model.addAttribute("user", getCurrentLoginUser(req));
        return "home/home";
    }
}
