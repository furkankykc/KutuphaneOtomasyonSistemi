package com.fhbs.deneme;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Dao.JdbcAddressDao;
import Dao.JdbcAuthorDao;
import Dao.JdbcPublisherDao;
import Entity.Author;
import Entity.Publisher;

@RequestMapping(value = "Author")
@Controller
public class AuthorController {
	   
	
//	@Autowired
//	@Qualifier("PublisherValidator")
//	private Validator validator;
//	
//	@InitBinder
//	private void initBinder(WebDataBinder binder) {
//	    binder.setValidator(validator);
//	}
	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	JdbcAuthorDao authDao = (JdbcAuthorDao) context.getBean("authDao");
	JdbcAddressDao AddressDao = (JdbcAddressDao) context.getBean("addressDao");
	
	@ModelAttribute("AuthorBean")
	public Author getAuthorBean(){
	    return new Author();
	}

	
	
	@RequestMapping(value = "/Author", method = RequestMethod.GET)
    public String init(Model model) {
	    model.addAttribute("authors",authDao.getAuthor());
	    model.addAttribute("address",AddressDao.getAddress());
        return "Author";	
    }
    @RequestMapping(value = "/Author",params="add",method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute("authBean") Author authBean,@RequestParam String add) {
    	System.out.println(authBean.toString());
	    	if(authBean!=null){
		    	authDao.insert(authBean);
		    	model.addAttribute("authors",  authDao.getAuthor());
		    	}
    	return "Author";
}
    @RequestMapping(params = "del",method = RequestMethod.POST)
    public String delete(Model model, @ModelAttribute("authBean") Author authBean,@RequestParam String del) {
    	if(authBean!=null){
	    	authDao.delete(authBean);
	    	return "Author";
    	}else{
	    		return "Author";
	    	}
}
    @RequestMapping(params = "details",method = RequestMethod.POST)
    public String details(Model model, @ModelAttribute("AuthorBean") Author AuthorBean,@RequestParam String details) {
    	if(AuthorBean!=null){
    		model.addAttribute("author",AuthorBean);
    		model.addAttribute("address",AddressDao.getAddress());
			return "AuthorDetail";
    	}else{
    		return "Author";
    	}
}
    @RequestMapping(params = "update",method = RequestMethod.POST)
    public String update(Model model, @ModelAttribute("AuthorBean") Author AuthorBean,@RequestParam String update) {
    	if(AuthorBean!=null){
    		authDao.update(AuthorBean);
    		model.addAttribute("msg","id = "+AuthorBean.getId()+" olan Author güncellendi.");
			return init(model);
    	}else{

    		model.addAttribute("author",AuthorBean);
    		model.addAttribute("address",AddressDao.getAddress());
    		return "AuthorDetail";
    	}
}
    @RequestMapping(value = "/Author",params = "remove",method = RequestMethod.POST)
    public String remove(HttpServletRequest request,ModelMap modelMap,@RequestParam String remove) {
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
