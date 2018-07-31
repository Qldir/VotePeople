package com.strawpoll.app.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.strawpoll.app.dto.PollItem;

@Repository
public class PollItemRepository implements PollItemMapper {

	@Autowired
	SqlSession session;

	@Override
	public int insertItem(PollItem pItem) {
		
		PollItemMapper mapper = session.getMapper(PollItemMapper.class);
		int result = mapper.insertItem(pItem);
		
		return result;
	}
	
	
	
}
