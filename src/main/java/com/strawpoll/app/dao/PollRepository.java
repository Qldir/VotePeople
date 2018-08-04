package com.strawpoll.app.dao;

import java.util.ArrayList;

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

	@Override
	public PollInfo selectPoll(int poll_id) {
		
		PollMapper mapper = session.getMapper(PollMapper.class);
		
		return mapper.selectPoll(poll_id);
	}

	@Override
	public int updateCount(int poll_id) {
		
		PollMapper mapper = session.getMapper(PollMapper.class);
		int result = mapper.updateCount(poll_id);
		
		return result;
	}

	@Override
	public ArrayList<PollInfo> trendingPoll() {
		
		PollMapper mapper = session.getMapper(PollMapper.class);
		
		ArrayList<PollInfo> result = mapper.trendingPoll();
		
		return result;
	}

	@Override
	public ArrayList<PollInfo> newPolls() {
		
		PollMapper mapper = session.getMapper(PollMapper.class);
		
		ArrayList<PollInfo> result = mapper.newPolls();
		
		return result;
	}
	
}
