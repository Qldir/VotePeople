package com.strawpoll.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.strawpoll.app.dao.PollItemRepository;
import com.strawpoll.app.dao.PollRepository;
import com.strawpoll.app.dto.Item;
import com.strawpoll.app.dto.PollInfo;

@Controller
public class PollController {

	@Autowired
	PollRepository pollRepository;
	
	@Autowired
	PollItemRepository itemRepository;
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String newpoll(PollInfo pInfo, Item item) {
	
		System.out.println(pInfo);
		System.out.println(item);
		
		pollRepository.insertPoll(pInfo);
		
		
		return "redirect:/";
	}
}
