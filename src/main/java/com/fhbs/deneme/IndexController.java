package com.fhbs.deneme;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value="/")
@Controller
public class IndexController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String init(Model model) {
        return "redirect:login";
    }
}
