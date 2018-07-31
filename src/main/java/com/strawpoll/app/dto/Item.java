package com.strawpoll.app.dto;

import java.util.ArrayList;

public class Item {
	ArrayList<String> item;

	public ArrayList<String> getItem() {
		return item;
	}

	public void setItem(ArrayList<String> item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Item [item=" + item + "]";
	}
	
	
}
