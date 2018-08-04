package com.strawpoll.app.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.strawpoll.app.dto.VoteList;

@Repository
public class VoteListRepository implements VoteListMapper {
	
	@Autowired
	SqlSession session;

	@Override
	public int insertVote(VoteList voteList) {
		
		VoteListMapper mapper = session.getMapper(VoteListMapper.class);
		int result = mapper.insertVote(voteList);
		
		return result;
	}

	@Override
	public VoteList selectVote(VoteList voteList) {
		
		VoteListMapper mapper = session.getMapper(VoteListMapper.class);
		
		return mapper.selectVote(voteList);
	}

}