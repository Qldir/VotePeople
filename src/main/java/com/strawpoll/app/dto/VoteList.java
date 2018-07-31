package com.strawpoll.app.dto;

public class VoteList {
	private int id;
	private int poll_id;
	private String client_ip;
	
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
	public String getClient_ip() {
		return client_ip;
	}
	public void setClient_ip(String client_ip) {
		this.client_ip = client_ip;
	}
	
	@Override
	public String toString() {
		return "VoteList [id=" + id + ", poll_id=" + poll_id + ", client_ip=" + client_ip + "]";
	}
	
	
}
