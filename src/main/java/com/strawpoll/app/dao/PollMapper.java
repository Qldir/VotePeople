package com.strawpoll.app.dao;

import com.strawpoll.app.dto.PollInfo;

public interface PollMapper {
	public int insertPoll(PollInfo pInfo);
	public int selectId();
}
