package com.strawpoll.app;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.strawpoll.app.dao.PollItemRepository;
import com.strawpoll.app.dao.PollRepository;
import com.strawpoll.app.dto.Item;
import com.strawpoll.app.dto.PollInfo;
import com.strawpoll.app.dto.PollItem;

@Controller
public class PollController {

	@Autowired
	PollRepository pollRepository;
	
	@Autowired
	PollItemRepository itemRepository;
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String newpoll(PollInfo pInfo, Item item) {
	
		String end_time = pInfo.getEnd_time().replace('T', ' ');
		
		pInfo.setEnd_time(end_time);
		
		pollRepository.insertPoll(pInfo);	//insert Poll_Info
		
		int poll_id = pollRepository.selectId();	//Poll_Info_id
		
		PollItem pItem = new PollItem();	//Poll_Item create
		
		pItem.setPoll_id(poll_id);	//set Poll_Info_id

		for(String data:item.getItem()) {
			if(!(data.equals("") || data.isEmpty() ) ) {
				
				pItem.setItem(data);
				itemRepository.insertItem(pItem);
			}
		}
		
		return "redirect:/"+poll_id;
	}
	
	
	@RequestMapping("/{poll_id}")
	public String goPoll(@PathVariable int poll_id, Model model) {
		
		PollInfo pInfo = pollRepository.selectPoll(poll_id);
		
		ArrayList<PollItem> pItem = itemRepository.selectItem(poll_id);
		
		model.addAttribute("pInfo", pInfo);
		model.addAttribute("pItem", pItem);
		
		return "poll"; 
	}
	
	
}
