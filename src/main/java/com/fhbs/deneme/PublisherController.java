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
	
	
	
//	   @Autowired
//	    @Qualifier("PublisherValidator")
//	    private Validator validator;
//	    
//	    @InitBinder
//	    private void initBinder(WebDataBinder binder) {
//	        binder.setValidator(validator);
//	    }
	    @ModelAttribute("PublisherBean")
	    public Publisher getPublisherBean(){
	        return new Publisher();
	    }
	    
	    ApplicationContext context =
   			 
    			new ClassPathXmlApplicationContext("Spring-Module.xml");
    		    	JdbcPublisherDao PublisherDao = (JdbcPublisherDao) context.getBean("publisherDao");
    		    	JdbcAddressDao AddressDao = (JdbcAddressDao) context.getBean("addressDao");
    		    	
	  @RequestMapping(value = "/Publisher", method = RequestMethod.GET)
	    public String init(Model model) {
	    	
			model.addAttribute("address",AddressDao.getAddress());
			model.addAttribute("publishers",PublisherDao.getPublisher());
			

	        return "Publisher";	
	    }
	  
	    @RequestMapping(value = "/Publisher",params="add",method = RequestMethod.POST)
	    public String add(Model model,@Validated Publisher PublisherBean, @RequestParam String add) {
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
	    	if(PublisherBean!=null){
	    	PublisherDao.delete(PublisherBean);
	    	return "Publisher";
	    	}else{
	    		return "Publisher";
	    	}
	}
	    @RequestMapping(params = "details",method = RequestMethod.POST)
	    public String details(Model model, @ModelAttribute("PublisherBean") Publisher PublisherBean,@RequestParam String details) {
    		if(PublisherBean!=null){
	    		model.addAttribute("publisher",PublisherBean);
	    		model.addAttribute("address",AddressDao.getAddress());
				return "PublisherDetail";
	    	}else{
	    		return "Publisher";
	    	}
	}
	    @RequestMapping(params = "update",method = RequestMethod.POST)
	    public String update(Model model, @ModelAttribute("PublisherBean") Publisher PublisherBean,@RequestParam String update) {
	    	if(PublisherBean!=null){
	    		PublisherDao.update(PublisherBean);
	    		model.addAttribute("msg","id = "+PublisherBean.getId()+" olan Publisher güncellendi.");
				return init(model);
	    	}else{

	    		model.addAttribute("publisher",PublisherBean);
	    		model.addAttribute("address",AddressDao.getAddress());
	    		return "PublisherDetail";
	    	}
	}
	    @RequestMapping(value = "/Publisher",params = "remove",method = RequestMethod.POST)
	    public String remove(HttpServletRequest request,ModelMap modelMap,@RequestParam String remove) {
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
