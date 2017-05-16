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

import Dao.JdbcCategoryDao;
import Entity.Category;

@RequestMapping(value="/Category")
@Controller
public class CategoryController {
	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	JdbcCategoryDao categoryDao = (JdbcCategoryDao) context.getBean("categoryDao");



	public Category getCategoryBean(){
        return new Category();
		    }
		   
	@RequestMapping(params = "details",method = RequestMethod.POST)
	public String details(Model model, @ModelAttribute("CategoryBean") Category CategoryBean,@RequestParam String details) {
		if(CategoryBean!=null){
			model.addAttribute("Category",CategoryBean);
			return "CategoryDetail";
    	}else{
    		return "Category";
    	}
	 }
		    @RequestMapping(params = "update",method = RequestMethod.POST)
    public String update(Model model, @ModelAttribute("CategoryBean") Category CategoryBean,@RequestParam String update) {
		    	if(CategoryBean!=null){
		    		categoryDao.update(CategoryBean);
		    		model.addAttribute("msg","id = "+CategoryBean.getId()+" olan Category güncellendi.");
					return init(model);
		    	}else{

		    		model.addAttribute("Category",CategoryBean);
		    		return "CategoryDetail";
		    	}
		}
		     
  @RequestMapping(value = "/Category", method = RequestMethod.GET)
    public String init(Model model) {
    	model.addAttribute("categories",categoryDao.getCategory());
    	return "Category";	
    }
    @RequestMapping(value = "/Category",params="add",method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute("categoryBean") Category categoryBean,@RequestParam String add) {
    	if(categoryBean!=null){
	    	categoryDao.insert(categoryBean);
	    	model.addAttribute("categories",  categoryDao.getCategory());
		}
    	return "Category";
    }

    @RequestMapping(params = "del",method = RequestMethod.POST)
    public String delete(Model model, @ModelAttribute("categoryBean") Category categoryBean,@RequestParam String del) {
    	if(categoryBean!=null){
    		categoryDao.delete(categoryBean);
    		return "Category";
    	}else{
    		return "Category";
    	}
}
    @RequestMapping(value = "/Category",params = "remove",method = RequestMethod.POST)
  	public String remove(HttpServletRequest request,ModelMap modelMap,@RequestParam String remove) {
    	try{
	    	if(request.getParameter("id")!=null){
	    		String id = request.getParameter("id");
	    		categoryDao.delete(id);
	    		}
    	}catch(Exception e){
    		modelMap.put("error", e);
    		}
    	modelMap.addAttribute("categories",categoryDao.getCategory());
    	return "Category";
    	
}

}
