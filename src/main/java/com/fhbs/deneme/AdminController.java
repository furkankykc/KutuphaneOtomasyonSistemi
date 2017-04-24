package com.fhbs.deneme;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Dao.JdbcKitapDao;
import Dao.JdbcLoginDao;
import Entity.User;
import Entity.kitap;

@Controller
public class AdminController {
	    @RequestMapping(value = "/admin", method = RequestMethod.GET)
	    public String init(Model model) {
	        model.addAttribute("msg", "id sifre gir");
	
	        return "admin";
	    }

	    
	    
	    
	    @RequestMapping(params="add",method = RequestMethod.POST)
	    public String add(Model model, @ModelAttribute("kitapBean") kitap kitapBean,@RequestParam String add) {
	    	ApplicationContext context =
		    		new ClassPathXmlApplicationContext("Spring-Module.xml");
	    	JdbcKitapDao kitapDao = (JdbcKitapDao) context.getBean("kitapDao");
	    	if(kitapBean!=null){
	    	kitapDao.insert(kitapBean);
	    
		        ArrayList<kitap> kitap = kitapDao.getKitap();
		  	  
				model.addAttribute("user",kitap);
	    	return "admin";
	    	}else{
	    		return "admin";
	    	}
	}
	    @RequestMapping(params = "del",method = RequestMethod.POST)
	    public String delete(Model model, @ModelAttribute("kitapBean") kitap kitapBean,@RequestParam String del) {
	    	ApplicationContext context =
		    		new ClassPathXmlApplicationContext("Spring-Module.xml");
	    	JdbcKitapDao kitapDao = (JdbcKitapDao) context.getBean("kitapDao");
	    	if(kitapBean!=null){
	    	kitapDao.delete(kitapBean);
	    	return "admin";
	    	}else{
	    		return "admin";
	    	}
	}
	    
	    

	    
	    
	 
}
