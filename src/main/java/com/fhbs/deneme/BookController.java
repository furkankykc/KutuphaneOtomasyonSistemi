package com.fhbs.deneme;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class BookController {
	  @RequestMapping(value = "/kitap", method = RequestMethod.GET)
	    public String init(Model model) {
	        model.addAttribute("msg", "Please Enter Your Login Details");
	        return "login";
	    }
	 
}
