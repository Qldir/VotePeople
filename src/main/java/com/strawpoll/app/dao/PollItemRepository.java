package com.strawpoll.app.dao;

import java.util.ArrayList;

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

	@Override
	public ArrayList<PollItem> selectItem(int poll_id) {
		
		PollItemMapper mapper = session.getMapper(PollItemMapper.class);
		
		return mapper.selectItem(poll_id);
	}

	@Override
	public int updateItem(PollItem pItem) {
		
		PollItemMapper mapper = session.getMapper(PollItemMapper.class);
		int result = mapper.updateItem(pItem);
		
		return result;
	}
	
	
	
}
