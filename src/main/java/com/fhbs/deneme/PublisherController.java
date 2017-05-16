package com.fhbs.deneme;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Dao.JdbcAddressDao;
import Dao.JdbcPublisherDao;
import Entity.Address;
import Entity.Colour;
import Entity.Publisher;

@RequestMapping(value="/Publisher")
@Controller
public class PublisherController {
	
	
	
	   @Autowired
	    @Qualifier("PublisherValidator")
	    private Validator validator;
	    
	    @InitBinder
	    private void initBinder(WebDataBinder binder) {
	        binder.setValidator(validator);
	    }
	    @ModelAttribute("PublisherBean")
	    public Publisher getTransactionHelper(){
	        return new Publisher();
	    }
	    
	    
	  @RequestMapping(value = "/Publisher", method = RequestMethod.GET)
	    public String init(Model model) {
	    	ApplicationContext context =
	    			 
	    			new ClassPathXmlApplicationContext("Spring-Module.xml");
	    		    	JdbcPublisherDao PublisherDao = (JdbcPublisherDao) context.getBean("publisherDao");
	    		    	JdbcAddressDao AddressDao = (JdbcAddressDao) context.getBean("addressDao");
	    		    	
	    		    			model.addAttribute("address",AddressDao.getAddress());
	    						model.addAttribute("publishers",PublisherDao.getPublisher());
	    						model.addAttribute("yayım",new Publisher());	

	        return "Publisher";	
	    }
	  
	    @RequestMapping(value = "/Publisher",params="add",method = RequestMethod.POST)
	    public String add(Model model,@Validated Publisher PublisherBean, @RequestParam String add) {
	    	ApplicationContext context =
		    		new ClassPathXmlApplicationContext("Spring-Module.xml");
	    	JdbcPublisherDao PublisherDao = (JdbcPublisherDao) context.getBean("publisherDao");
	    	System.out.println(PublisherBean);
	    	if(PublisherBean!=null){
	    		if(PublisherBean.getName()!=""){
	    			if(PublisherBean.getAddress()!=null){
	    	    	PublisherDao.insert(PublisherBean);
	    			}else{

		    			model.addAttribute("msg","Please chose allready existing address");
	    			}
	    		}else{
	    			model.addAttribute("msg","Please fill 'name'");
	    			
	    		}
	    		      	
	    	}
	    		return init(model);
	    	}
	


	    
	    
	    @RequestMapping(params = "del",method = RequestMethod.POST)
	    public String delete(Model model, @ModelAttribute("PublisherBean") Publisher PublisherBean,@RequestParam String del) {
	    	ApplicationContext context =
		    		new ClassPathXmlApplicationContext("Spring-Module.xml");
	    	JdbcPublisherDao PublisherDao = (JdbcPublisherDao) context.getBean("publisherDao");
	    	if(PublisherBean!=null){
	    	PublisherDao.delete(PublisherBean);
	    	return "Publisher";
	    	}else{
	    		return "Publisher";
	    	}
	}
	    @RequestMapping(value = "/Publisher",params = "remove",method = RequestMethod.POST)
	    public String remove(HttpServletRequest request,ModelMap modelMap,@RequestParam String remove) {
	    	ApplicationContext context =
		    		new ClassPathXmlApplicationContext("Spring-Module.xml");
	    	JdbcPublisherDao PublisherDao = (JdbcPublisherDao) context.getBean("publisherDao");
	    	try{
	    	if(request.getParameter("id")!=null){
	    	String id = request.getParameter("id");
	    		System.out.println("||||||||||||||||||||||||"+id+"||||||||||||||||||-");
	    		PublisherDao.delete(id);
	    	}
	    		
	    	
	    	}catch(Exception e){
	    		modelMap.put("error", e);
	    	}
	    	modelMap.addAttribute("publishers",PublisherDao.getPublisher());
	    		return "Publisher";
	    	
	}

}
