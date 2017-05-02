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
import Entity.Address;

@RequestMapping(value="/Address")
@Controller
public class AddressController {
	  @RequestMapping(value = "/Address", method = RequestMethod.GET)
	    public String init(Model model) {
	    	ApplicationContext context =
	    			 
	    			new ClassPathXmlApplicationContext("Spring-Module.xml");
	    		    	JdbcAddressDao AddressDao = (JdbcAddressDao) context.getBean("addressDao");
	    		    	
	    						model.addAttribute("Address",AddressDao.getAddress());
	    							    	

	        return "Address";	
	    }
	    @RequestMapping(value = "/Address",params="add",method = RequestMethod.POST)
	    public String add(Model model, @ModelAttribute("AddressBean") Address AddressBean,@RequestParam String add) {
	    	ApplicationContext context =
		    		new ClassPathXmlApplicationContext("Spring-Module.xml");
	    	JdbcAddressDao AddressDao = (JdbcAddressDao) context.getBean("addressDao");
	    	
	    	if(AddressBean!=null){
	    	AddressDao.insert(AddressBean);
	    		    	
	    						model.addAttribute("Address",  AddressDao.getAddress());
					    	
				return "Address";
	    	}else{
	    		return "Address";
	    	}
	}
	    @RequestMapping(params = "del",method = RequestMethod.POST)
	    public String delete(Model model, @ModelAttribute("AddressBean") Address AddressBean,@RequestParam String del) {
	    	ApplicationContext context =
		    		new ClassPathXmlApplicationContext("Spring-Module.xml");
	    	JdbcAddressDao AddressDao = (JdbcAddressDao) context.getBean("addressDao");
	    	if(AddressBean!=null){
	    	AddressDao.delete(AddressBean);
	    	return "Address";
	    	}else{
	    		return "Address";
	    	}
	}
	    @RequestMapping(value = "/Address",params = "remove",method = RequestMethod.POST)
	    public String remove(HttpServletRequest request,ModelMap modelMap,@RequestParam String remove) {
	    	ApplicationContext context =
		    		new ClassPathXmlApplicationContext("Spring-Module.xml");
	    	JdbcAddressDao AddressDao = (JdbcAddressDao) context.getBean("addressDao");
	    	try{
	    	if(request.getParameter("id")!=null){
	    	String id = request.getParameter("id");
	    		System.out.println("||||||||||||||||||||||||"+id+"||||||||||||||||||-");
	    		AddressDao.delete(id);
	    	}
	    		
	    	
	    	}catch(Exception e){
	    		modelMap.put("error", e);
	    	}
	    	modelMap.addAttribute("Address",AddressDao.getAddress());
	    		return "Address";
	    	
	}

}
