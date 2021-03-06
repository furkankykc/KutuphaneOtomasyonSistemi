package com.fhbs.deneme;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Dao.*;
import Entity.*;

@RequestMapping(value = "/admin")
@Controller
public class AdminController {
	
	ApplicationContext context =new ClassPathXmlApplicationContext("Spring-Module.xml");
	JdbcBookDao bookDao = (JdbcBookDao) context.getBean("bookDao");
	JdbcAddressDao addressDao = (JdbcAddressDao) context.getBean("addressDao");
	JdbcAuthorDao authorDao = (JdbcAuthorDao) context.getBean("authDao");
	JdbcCategoryDao categoryDao = (JdbcCategoryDao) context.getBean("categoryDao");
	JdbcPublisherDao publisherDao = (JdbcPublisherDao) context.getBean("publisherDao");
	
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String init(Model model) {
    	
			    	
    	model.addAttribute("books",bookDao.getBook());
    	model.addAttribute("categories",categoryDao.getCategory());
    	model.addAttribute("publishers",publisherDao.getPublisher());
    	model.addAttribute("authors",authorDao.getAuthor());
    	model.addAttribute("addresses",addressDao.getAddress());
    							    	

        return "admin";	
    }

   
    
    
    @RequestMapping(value = "/admin",params="add",method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute("kitapBean") Book kitapBean,@RequestParam String add) {
    	ApplicationContext context =
	    		new ClassPathXmlApplicationContext("Spring-Module.xml");
    	JdbcBookDao kitapDao = (JdbcBookDao) context.getBean("kitapDao");
    	
    	if(kitapBean!=null){
    	kitapDao.insert(kitapBean);
    		    	
    						model.addAttribute("kitaplar",  kitapDao.getBook());
				    	
			return "admin";
    	}else{
    		return "admin";
    	}
}
    
    @RequestMapping(params = "del",method = RequestMethod.POST)
    public String delete(Model model, @ModelAttribute("kitapBean") Book kitapBean,@RequestParam String del) {
    	ApplicationContext context =
	    		new ClassPathXmlApplicationContext("Spring-Module.xml");
    	JdbcBookDao kitapDao = (JdbcBookDao) context.getBean("kitapDao");
    	if(kitapBean!=null){
    	kitapDao.delete(kitapBean);
    	return "admin";
    	}else{
    		return "admin";
    	}
}

    public String remove(HttpServletRequest request,ModelMap modelMap,@RequestParam String remove) {
    	ApplicationContext context =
	    		new ClassPathXmlApplicationContext("Spring-Module.xml");
    	JdbcBookDao kitapDao = (JdbcBookDao) context.getBean("kitapDao");
    	try{
    	if(request.getParameterValues("kitapId")!=null)
    	for(String kitapId : request.getParameterValues("kitapId")){
    		System.out.println("||||||||||||||||||||||||"+kitapId+"||||||||||||||||||-");
    		kitapDao.delete(kitapId);
    		
    		
    	}
    	}catch(Exception e){
    		modelMap.put("error", e);
    	}
    	modelMap.addAttribute("kitaplar",kitapDao.getBook());
    		return "admin";
	    	
	}
	    

	    
	    
	 
}
