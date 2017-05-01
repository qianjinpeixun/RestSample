package com.qianjin.java.soa.gson;

public class User {

	private String profile_sidebar_fill_color;
	private String profile_sidebar_border_color;
	private boolean profile_background_tile;
	public String getProfile_sidebar_fill_color() {
		return profile_sidebar_fill_color;
	}
	public void setProfile_sidebar_fill_color(String profile_sidebar_fill_color) {
		this.profile_sidebar_fill_color = profile_sidebar_fill_color;
	}
	public String getProfile_sidebar_border_color() {
		return profile_sidebar_border_color;
	}
	public void setProfile_sidebar_border_color(String profile_sidebar_border_color) {
		this.profile_sidebar_border_color = profile_sidebar_border_color;
	}
	public boolean isProfile_background_tile() {
		return profile_background_tile;
	}
	public void setProfile_background_tile(boolean profile_background_tile) {
		this.profile_background_tile = profile_background_tile;
	}
	@Override
	public String toString() {
		return "User [profile_sidebar_fill_color=" + profile_sidebar_fill_color + ", profile_sidebar_border_color=" + profile_sidebar_border_color + ", profile_background_tile="
				+ profile_background_tile + "]";
	}
	
}
