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

import Dao.JdbcKitapDao;
import Dao.JdbcLoginDao;
import Entity.User;
import Entity.kitap;

@Controller
public class AdminController {
	    @RequestMapping(value = "/admin", method = RequestMethod.GET)
	    public String init(Model model) {
	        model.addAttribute("msg", "id sifre gir");
	    	ApplicationContext context =
	    			 
	    			new ClassPathXmlApplicationContext("Spring-Module.xml");
	    		    	JdbcKitapDao kitapDao = (JdbcKitapDao) context.getBean("kitapDao");
	    		    	
	    						model.addAttribute("kitaplar",  kitapDao.getKitap());
	    							    	
	
	        return "admin";
	    }

	   
	    
	    
	    @RequestMapping(params="add",method = RequestMethod.POST)
	    public String add(Model model, @ModelAttribute("kitapBean") kitap kitapBean,@RequestParam String add) {
	    	ApplicationContext context =
		    		new ClassPathXmlApplicationContext("Spring-Module.xml");
	    	JdbcKitapDao kitapDao = (JdbcKitapDao) context.getBean("kitapDao");
	    	if(kitapBean!=null){
	    	kitapDao.insert(kitapBean);
	    		    	
	    						model.addAttribute("kitaplar",  kitapDao.getKitap());
					    	
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
	
	
	    
	    @RequestMapping(params = "remove",method = RequestMethod.POST)
	    public String remove(HttpServletRequest request,ModelMap modelMap,@RequestParam String remove) {
	    	ApplicationContext context =
		    		new ClassPathXmlApplicationContext("Spring-Module.xml");
	    	JdbcKitapDao kitapDao = (JdbcKitapDao) context.getBean("kitapDao");
	    	try{
	    	if(request.getParameterValues("kitapId")!=null)
	    	for(String kitapId : request.getParameterValues("kitapId")){
	    		System.out.println("||||||||||||||||||||||||"+kitapId+"||||||||||||||||||-");
	    		kitapDao.delete(kitapId);
	    		
	    		
	    	}
	    	}catch(Exception e){
	    		modelMap.put("error", e);
	    	}
	    	modelMap.addAttribute("kitaplar",kitapDao.getKitap());
	    		return "admin";
	    	
	}
	    

	    
	    
	 
}
