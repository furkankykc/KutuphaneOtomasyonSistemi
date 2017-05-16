package com.fhbs.deneme;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Dao.JdbcAddressDao;
import Entity.Colour;

@Controller
@RequestMapping("/colour")
public class ColourController {

    @Autowired
    @Qualifier("colourValidator")
    private Validator validator;
    
    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }
	
	@RequestMapping(method = RequestMethod.GET)
	public String initForm(Model model) {
		ApplicationContext context =
   			 
    			new ClassPathXmlApplicationContext("Spring-Module.xml");
    		    	
		JdbcAddressDao AddressDao = (JdbcAddressDao) context.getBean("addressDao");
    	
		model.addAttribute("address",AddressDao.getAddress());
		Colour colour = new Colour();
		model.addAttribute("colour", colour);
		initModelList(model);
		return "colour";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(Model model, @Validated Colour colour, BindingResult result) {
		model.addAttribute("colour", colour);
		String returnVal = "successColour";
		if(result.hasErrors()) {
			initModelList(model);
			returnVal = "colour";
		} else {
			model.addAttribute("colour", colour);
		}		
		return returnVal;
	}

	private void initModelList(Model model) {
		List<Colour> coloursList = new ArrayList<Colour>();
		coloursList.add(new Colour("red"));
		coloursList.add(new Colour("green"));
		coloursList.add(new Colour("yellow"));
		coloursList.add(new Colour("pink"));
		coloursList.add(new Colour("blue"));
		model.addAttribute("colours", coloursList);
	
	}
}