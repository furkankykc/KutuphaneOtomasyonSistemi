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

import Dao.JdbcBookDao;
import Dao.JdbcLoginDao;
import Dao.JdbcUserDao;
import Entity.Book;
import Entity.User;
import Entity.kitap;
@RequestMapping(value = "/Book")
@Controller
public class BookController {
	@RequestMapping(method = RequestMethod.GET)
    public String init(Model model) {
        model.addAttribute("msg", "id sifre gir");
    	ApplicationContext context =
    			 
    			new ClassPathXmlApplicationContext("Spring-Module.xml");
    		    	JdbcBookDao bookDao = (JdbcBookDao) context.getBean("bookDao");
    		    	//bookDao.insert(new Book("furkan",12,0,0,0));
    		//JdbcbookDao bookDao2 = (JdbcbookDao) context.getBean("bookDao");
    		    	JdbcUserDao Login  = (JdbcUserDao) context.getBean("userDao");
    						model.addAttribute("books",bookDao.getBook());
    							    	

        return "Book";	
    }

   
    
    
    @RequestMapping(value = "/Book",params="add",method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute("kitapBean") Book kitapBean,@RequestParam String add) {
    	ApplicationContext context =
	    		new ClassPathXmlApplicationContext("Spring-Module.xml");
    	JdbcBookDao bookDao = (JdbcBookDao) context.getBean("bookDao");
    	
    	if(kitapBean!=null){
    	bookDao.insert(kitapBean);
    		    	
    						model.addAttribute("books",  bookDao.getBook());
				    	
			return "Book";
    	}else{
    		return "Book";
    	}
}
    
    @RequestMapping(value = "/Book",params = "del",method = RequestMethod.POST)
    public String delete(Model model, @ModelAttribute("kitapBean") Book kitapBean,@RequestParam String del) {
    	ApplicationContext context =
	    		new ClassPathXmlApplicationContext("Spring-Module.xml");
    	JdbcBookDao bookDao = (JdbcBookDao) context.getBean("bookDao");
    	if(kitapBean!=null){
    	bookDao.delete(kitapBean);
    	return "Book";
    	}else{
    		return "Book";
    	}
}


    
    @RequestMapping(value = "/Book",params = "remove",method = RequestMethod.POST)
    public String remove(HttpServletRequest request,ModelMap modelMap,@RequestParam String remove) {
    	ApplicationContext context =
	    		new ClassPathXmlApplicationContext("Spring-Module.xml");
    	JdbcBookDao bookDao = (JdbcBookDao) context.getBean("bookDao");
    	try{
    	if(request.getParameter("id")!=null){
    	String kitapId = request.getParameter("id");
    		System.out.println("||||||||||||||||||||||||"+kitapId+"||||||||||||||||||-");
    		bookDao.delete(kitapId);
    		
    		
    	}
    	}catch(Exception e){
    		modelMap.put("error", e);
    	}
    	modelMap.addAttribute("books",bookDao.getBook());
    		return "Book";
    	
    }
}


    

    


