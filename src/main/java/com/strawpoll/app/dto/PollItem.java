package com.strawpoll.app.dto;

public class PollItem {
	private int id;
	private int poll_id;
	private String item;
	private int vote_count;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPoll_id() {
		return poll_id;
	}
	public void setPoll_id(int poll_id) {
		this.poll_id = poll_id;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getVote_count() {
		return vote_count;
	}
	public void setVote_count(int vote_count) {
		this.vote_count = vote_count;
	}
	
	@Override
	public String toString() {
		return "PollItem [id=" + id + ", poll_id=" + poll_id + ", item=" + item + ", vote_count=" + vote_count + "]";
	}
	
	

}
