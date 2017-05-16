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

import Dao.JdbcAddressDao;
import Dao.JdbcAuthorDao;
import Dao.JdbcBookDao;
import Dao.JdbcCategoryDao;
import Dao.JdbcLoginDao;
import Dao.JdbcPublisherDao;
import Dao.JdbcUserDao;
import Entity.Book;
import Entity.User;
@RequestMapping(value = "/Book")
@Controller
public class BookController {
	ApplicationContext context =new ClassPathXmlApplicationContext("Spring-Module.xml");
	JdbcBookDao bookDao = (JdbcBookDao) context.getBean("bookDao");
	JdbcAddressDao addressDao = (JdbcAddressDao) context.getBean("addressDao");
	JdbcAuthorDao authorDao = (JdbcAuthorDao) context.getBean("authDao");
	JdbcCategoryDao categoryDao = (JdbcCategoryDao) context.getBean("categoryDao");
	JdbcPublisherDao publisherDao = (JdbcPublisherDao) context.getBean("publisherDao");
		    	
	@ModelAttribute("BookBean")
	public Book getBookBean(){
		        return new Book();
		    }
	@RequestMapping(method = RequestMethod.GET)
    public String init(Model model) {
        model.addAttribute("books",bookDao.getBook());
        model.addAttribute("address",addressDao.getAddress());
		model.addAttribute("category",categoryDao.getCategory());
		model.addAttribute("author", authorDao.getAuthor());
		model.addAttribute("publisher",publisherDao.getPublisher());
		
        return "Book";	
    }
	@RequestMapping(params = "add",method = RequestMethod.POST)	   
	public String add(Model model, @ModelAttribute("BookBean") Book BookBean,@RequestParam String add) {
    	if(BookBean!=null){
    		bookDao.insert(BookBean);
    		init(model);
    		}
    		return "Book";
	}
	public String delete(Model model, @ModelAttribute("BookBean") Book BookBean,@RequestParam String del) {
    	if(BookBean!=null){
    		bookDao.delete(BookBean);
    		return "Book";
    	}else{
    		return "Book";
    	}
    }
	@RequestMapping(params = "details",method = RequestMethod.POST)	   
	public String details(Model model, @ModelAttribute("BookBean") Book BookBean,@RequestParam String details) {
			if(BookBean!=null){
	    		model.addAttribute("Book",BookBean);
	    		init(model);

	    		return "BookDetail";
	    	}else{
	    		return "Book";
	    	}
	}
    @RequestMapping(params = "update",method = RequestMethod.POST)
    public String update(Model model, @ModelAttribute("BookBean") Book BookBean,@RequestParam String update) {
    	if(BookBean!=null){
    		bookDao.update(BookBean);
    		model.addAttribute("msg","id = "+BookBean.getId()+" olan Book güncellendi.");
			return init(model);
    	}else{

    		model.addAttribute("Book",BookBean);
    		return "BookDetail";
    	}
}
    public String remove(HttpServletRequest request,ModelMap modelMap,@RequestParam String remove) {
    	try{
	    	if(request.getParameter("id")!=null){
	    		String kitapId = request.getParameter("id");
	    		bookDao.delete(kitapId);
	    	}
    	}catch(Exception e){
    		modelMap.put("error", e);
    		}
    	modelMap.addAttribute("books",bookDao.getBook());
    	return "Book";
    	  }
}


    

    


