package com.strawpoll.app.dao;

import java.util.ArrayList;

import com.strawpoll.app.dto.PollItem;

public interface PollItemMapper {
	public int insertItem(PollItem pItem);
	public ArrayList<PollItem> selectItem(int poll_id);
	public int updateItem(PollItem pItem);
}
