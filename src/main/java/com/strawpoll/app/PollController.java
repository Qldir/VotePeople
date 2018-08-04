package com.strawpoll.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.strawpoll.app.dao.PollItemRepository;
import com.strawpoll.app.dao.PollRepository;
import com.strawpoll.app.dao.VoteListRepository;
import com.strawpoll.app.dto.Item;
import com.strawpoll.app.dto.PollInfo;
import com.strawpoll.app.dto.PollItem;
import com.strawpoll.app.dto.VoteList;

@Controller
public class PollController {

	@Autowired
	PollRepository pollRepository;
	
	@Autowired
	PollItemRepository itemRepository;
	
	@Autowired
	VoteListRepository voteRepository;
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String newpoll(PollInfo pInfo, Item item) {
	
		if(pInfo.getEnd_time() != null) {
			String end_time = pInfo.getEnd_time().replace('T', ' ');
	
			pInfo.setEnd_time(end_time);
		}
		
		pollRepository.insertPoll(pInfo);	//insert Poll_Info
		System.out.println(pInfo);
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
	public String goPoll(@PathVariable int poll_id, Model model, HttpServletRequest request, HttpSession session) {
		
		session.setAttribute("userip", getIp(request));
		
		PollInfo pInfo = pollRepository.selectPoll(poll_id);
		
		ArrayList<PollItem> pItem = itemRepository.selectItem(poll_id);
		
		model.addAttribute("pInfo", pInfo);
		model.addAttribute("pItem", pItem);
		model.addAttribute("url", request.getRequestURL());
		
		return "poll"; 
	}
	
	
	@RequestMapping(value = "vote", method = RequestMethod.POST)
	public @ResponseBody int vote(@RequestBody PollItem pItem, HttpSession session) {
		
		PollInfo pInfo = pollRepository.selectPoll(pItem.getPoll_id());
		
		if(pInfo.getEnd_time() != null) {
			try {
				Date today = new Date();
				System.out.println(today.getTime());
				
				SimpleDateFormat end_time = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				Date to;
				to = end_time.parse(pInfo.getEnd_time());
				
				if(today.getTime() > to.getTime()) {
					return 2;
				}
			} catch (ParseException e) {}
		

		}
		
		
		String client_ip = (String) session.getAttribute("userip");
		
		VoteList voteList = new VoteList();
		voteList.setPoll_id(pItem.getPoll_id());
		voteList.setClient_ip(client_ip);
		
		VoteList checkVote = voteRepository.selectVote(voteList);
		System.out.println(checkVote);
		int result=0;
		
		if(checkVote!=null) {
			result = 1;
			
			return result;
		}else {
			voteRepository.insertVote(voteList);
			itemRepository.updateItem(pItem);
			pollRepository.updateCount(pItem.getPoll_id());
			
			return result;
		}
		
		
	}
	
	
	@RequestMapping(value = "voteResult", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> voteResult(@RequestBody PollItem pItem) {
		
		Map<String,Object> map = new HashMap<String, Object>();
		
		PollInfo pInfo = pollRepository.selectPoll(pItem.getPoll_id());
		ArrayList<PollItem> pItemList = itemRepository.selectItem(pItem.getPoll_id());
		
		map.put("total_votes", pInfo.getAll_vote_count());
		map.put("data", pItemList);
		
		return map;
	}
	
	
	
	
	
	//접속자 ip 받아옴
	private String getIp(HttpServletRequest request) {
		 
        String ip = request.getHeader("X-Forwarded-For");
 
        System.out.println(">>>> X-FORWARDED-FOR : " + ip);
 
        if (ip == null) {
            ip = request.getHeader("Proxy-Client-IP");
            System.out.println(">>>> Proxy-Client-IP : " + ip);
        }
        if (ip == null) {
            ip = request.getHeader("WL-Proxy-Client-IP"); // 웹로직
            System.out.println(">>>> WL-Proxy-Client-IP : " + ip);
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_CLIENT_IP");
            System.out.println(">>>> HTTP_CLIENT_IP : " + ip);
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            System.out.println(">>>> HTTP_X_FORWARDED_FOR : " + ip);
        }
        if (ip == null) {
            ip = request.getRemoteAddr();
        }
        
        System.out.println(">>>> Result : IP Address : "+ip);
 
        return ip;
 
    }
}
