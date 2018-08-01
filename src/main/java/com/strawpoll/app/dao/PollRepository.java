package com.strawpoll.app.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.strawpoll.app.dto.PollInfo;

@Repository
public class PollRepository implements PollMapper{

	@Autowired
	SqlSession session;

	@Override
	public int insertPoll(PollInfo pInfo) {
		
		PollMapper mapper = session.getMapper(PollMapper.class);
		int result = mapper.insertPoll(pInfo);
		
		return result;
	}

	@Override
	public int selectId() {
		
		PollMapper mapper = session.getMapper(PollMapper.class);
		
		return mapper.selectId();
	}
	
}
