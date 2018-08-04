package com.strawpoll.app.dao;

import com.strawpoll.app.dto.VoteList;

public interface VoteListMapper {
	
	public int insertVote(VoteList voteList);
	public VoteList selectVote(VoteList voteList);

}
