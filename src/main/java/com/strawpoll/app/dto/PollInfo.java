package com.strawpoll.app.dto;

public class PollInfo {
	private int poll_id;
	private String title;
	private String start_time;
	private String end_time;
	private int all_vote_count;
	private String private_type;
	
	
	public int getPoll_id() {
		return poll_id;
	}
	public void setPoll_id(int poll_id) {
		this.poll_id = poll_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public int getAll_vote_count() {
		return all_vote_count;
	}
	public void setAll_vote_count(int all_vote_count) {
		this.all_vote_count = all_vote_count;
	}
	public String getPrivate_type() {
		return private_type;
	}
	public void setPrivate_type(String private_type) {
		this.private_type = private_type;
	}
	
	@Override
	public String toString() {
		return "PollInfo [poll_id=" + poll_id + ", title=" + title + ", start_time=" + start_time + ", end_time="
				+ end_time + ", all_vote_count=" + all_vote_count + ", private_type=" + private_type + "]";
	}
	
	
}
