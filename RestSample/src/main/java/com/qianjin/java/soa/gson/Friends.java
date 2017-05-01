package com.qianjin.java.soa.gson;

import java.util.*;

public class Friends {

	private String previous_cursor;
	private String previous_cursor_str;
	private String next_cursor;
	private String next_cursor_str;
	private List<User> users;
	public String getPrevious_cursor() {
		return previous_cursor;
	}
	public void setPrevious_cursor(String previous_cursor) {
		this.previous_cursor = previous_cursor;
	}
	public String getPrevious_cursor_str() {
		return previous_cursor_str;
	}
	public void setPrevious_cursor_str(String previous_cursor_str) {
		this.previous_cursor_str = previous_cursor_str;
	}
	public String getNext_cursor() {
		return next_cursor;
	}
	public void setNext_cursor(String next_cursor) {
		this.next_cursor = next_cursor;
	}
	public String getNext_cursor_str() {
		return next_cursor_str;
	}
	public void setNext_cursor_str(String next_cursor_str) {
		this.next_cursor_str = next_cursor_str;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "Friends [previous_cursor=" + previous_cursor + ", previous_cursor_str=" + previous_cursor_str + ", next_cursor=" + next_cursor + ", next_cursor_str="
				+ next_cursor_str + ", users=" + users + "]";
	}
	
}
