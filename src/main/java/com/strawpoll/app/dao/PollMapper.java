package com.strawpoll.app.dao;

import java.util.ArrayList;

import com.strawpoll.app.dto.PollInfo;

public interface PollMapper {
	public int insertPoll(PollInfo pInfo);
	public PollInfo selectPoll(int poll_id);
	public int selectId();
	public ArrayList<PollInfo> trendingPoll();
	public ArrayList<PollInfo> newPolls();
	public int updateCount(int poll_id);
}
