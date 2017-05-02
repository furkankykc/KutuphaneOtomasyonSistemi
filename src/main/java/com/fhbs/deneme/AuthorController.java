package com.fhbs.deneme;

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

import Dao.JdbcAuthorDao;
import Entity.Author;

@RequestMapping(value = "Author")
@Controller
public class AuthorController {
    @RequestMapping(value = "/Author", method = RequestMethod.GET)
    public String init(Model model) {
        model.addAttribute("msg", "id sifre gir");
    	ApplicationContext context =
    			 
    			new ClassPathXmlApplicationContext("Spring-Module.xml");
    		    	JdbcAuthorDao authDao = (JdbcAuthorDao) context.getBean("authDao");
    		    	
    						model.addAttribute("authors",authDao.getAuthor());
    							    	

        return "Author";	
    }
    @RequestMapping(value = "/Author",params="add",method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute("authBean") Author authBean,@RequestParam String add) {
    	ApplicationContext context =
	    		new ClassPathXmlApplicationContext("Spring-Module.xml");
    	JdbcAuthorDao authDao = (JdbcAuthorDao) context.getBean("authDao");
    	
    	if(authBean!=null){
    	authDao.insert(authBean);
    		    	
    						model.addAttribute("authors",  authDao.getAuthor());
				    	
			return "Author";
    	}else{
    		return "Author";
    	}
}
    @RequestMapping(params = "del",method = RequestMethod.POST)
    public String delete(Model model, @ModelAttribute("authBean") Author authBean,@RequestParam String del) {
    	ApplicationContext context =
	    		new ClassPathXmlApplicationContext("Spring-Module.xml");
    	JdbcAuthorDao authDao = (JdbcAuthorDao) context.getBean("authDao");
    	if(authBean!=null){
    	authDao.delete(authBean);
    	return "Author";
    	}else{
    		return "Author";
    	}
}
    
    @RequestMapping(value = "/Author",params = "remove",method = RequestMethod.POST)
    public String remove(HttpServletRequest request,ModelMap modelMap,@RequestParam String remove) {
    	ApplicationContext context =
	    		new ClassPathXmlApplicationContext("Spring-Module.xml");
    	JdbcAuthorDao authDao = (JdbcAuthorDao) context.getBean("authDao");
    	try{
    	if(request.getParameter("id")!=null){
    		String authId = request.getParameter("id");
    		System.out.println("||||||||||||||||||||||||"+authId+"||||||||||||||||||-");
    		authDao.delete(authId);
    		
    		
    	}
    	}catch(Exception e){
    		modelMap.put("error", e);
    	}
    	modelMap.addAttribute("authors",authDao.getAuthor());
    		return "Author";
    	
}
}
