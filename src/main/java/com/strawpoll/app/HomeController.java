package com.strawpoll.app;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.strawpoll.app.dao.PollRepository;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	PollRepository pollRepository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
	
		Date date = new Date();
		
		SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd");
	    SimpleDateFormat time = new SimpleDateFormat("HH:mm");

		model.addAttribute("day", day.format(date) );
		model.addAttribute("time", time.format(date) );
		
		model.addAttribute("trendingPoll", pollRepository.trendingPoll());
		model.addAttribute("newPolls", pollRepository.newPolls());
		
		
		return "index";
	}
	
}
