package com.qianjin.java.apacheLog;

public class ApacheLogFile {

	private String ip;
	private String datetime;
	private String url;
	private String httpCode;

	public String getIp() {
		return ip;
	}

	@Override
	public String toString() {
		return "ApacheLogFile [ip=" + ip + ", datetime=" + datetime + ", url=" + url + ", httpCode=" + httpCode + "]";
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHttpCode() {
		return httpCode;
	}

	public void setHttpCode(String httpCode) {
		this.httpCode = httpCode;
	}

}
