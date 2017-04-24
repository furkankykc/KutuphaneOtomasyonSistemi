package com.fhbs.deneme;

import java.text.DateFormat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import Dao.JdbcKitapDao;
import Dao.JdbcLoginDao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Dao.JdbcKitapDao;
import Entity.*;
/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		//logger.info("Welcome home! sfsdfsdfThe client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		String yenideneme = "4";
		model.addAttribute("serverTime", yenideneme );
		return "home";
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView getdata() {

		//return back to index.jsp
		ModelAndView model = new ModelAndView("index");
		ApplicationContext context =
	    		new ClassPathXmlApplicationContext("Spring-Module.xml");

    	JdbcKitapDao kitapDao = (JdbcKitapDao) context.getBean("kitapDao");
    	JdbcLoginDao loginDao = (JdbcLoginDao) context.getBean("LoginDao");
		ArrayList<User> kitap = loginDao.getUser();
		model.addObject("lists", kitap);

		return model;

	}
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String admin(Locale locale, Model model, @ModelAttribute("kitapBean") kitap kitapBean) {
    	ApplicationContext context =
	    		new ClassPathXmlApplicationContext("Spring-Module.xml");
    	JdbcKitapDao kitapDao = (JdbcKitapDao) context.getBean("kitapDao");
    	if(kitapBean!=null){
	    	kitapDao.insert(kitapBean);	
	    	return "admin";
    	}
        
    
    	return "admin";
    
    }
	
	/*@RequestMapping(value = "/",method = RequestMethod.GET)
	public String admin(Locale locale,Model model){
		User furkan = new User(007l,"James","Bond","1234561313789","furkankykc","02140001050");
		ApplicationContext context =
	    		new ClassPathXmlApplicationContext("Spring-Module.xml");

	    	JdbcKitapDao kitapDao = (JdbcKitapDao) context.getBean("kitapDao");
	    	//xkitapDao.insert(new kitap("denemeekleme","ekledinmi"));
	       JdbcLoginDao loginDao = (JdbcLoginDao) context.getBean("LoginDao");
	       loginDao.insert(furkan);
	        ArrayList<kitap> kitap = kitapDao.getKitap();
	  
		model.addAttribute("user",kitap);
		
		
		
		return "admin";
	}*/
	
	
	
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		logger.info("Welcome home! sfsdfsdfThe client locale is {}.", locale);
		
		
		
		int formattedDate = 4+4;
		
		model.addAttribute("serverTime", "asdasd"  );
		return "index";
	}
}
