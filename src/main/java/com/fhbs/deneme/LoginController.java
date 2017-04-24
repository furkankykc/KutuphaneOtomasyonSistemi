package com.fhbs.deneme;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Dao.JdbcKitapDao;
import Dao.JdbcLoginDao;
import Entity.User;
 
@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String init(Model model) {
        model.addAttribute("msg", "id sifre gir");
        return "login";
    }

 
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String submit(Model model, @ModelAttribute("loginBean") User loginBean) {
    	ApplicationContext context =
	    		new ClassPathXmlApplicationContext("Spring-Module.xml");
    	JdbcLoginDao loginDao = (JdbcLoginDao) context.getBean("LoginDao");
    	User girdi=loginDao.getUser(loginBean.getUserName());
    	if (girdi!= null && loginBean != null && loginBean.getUserName() != null & loginBean.getPassword() != null) {
	    	if(girdi.getPassword().equals(loginBean.getPassword())){
	    		model.addAttribute("msg", "giriş yapılan hesap : "+ loginBean.getUserName());
	    		return "success";
	    	} else {
                model.addAttribute("error", "hatali kullanıcı adı yada sifre");
                
                return "login";
            }
    	
        } else {
            model.addAttribute("error", "doldurburaları ");
            
            return "login";
        }
    

    
}
}