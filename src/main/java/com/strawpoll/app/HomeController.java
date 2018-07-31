package com.strawpoll.app;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
	
		Date date = new Date();
		
		SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd");
	    SimpleDateFormat time = new SimpleDateFormat("HH:mm");

		model.addAttribute("day", day.format(date) );
		model.addAttribute("time", time.format(date) );
		
		return "index";
	}
	
}
