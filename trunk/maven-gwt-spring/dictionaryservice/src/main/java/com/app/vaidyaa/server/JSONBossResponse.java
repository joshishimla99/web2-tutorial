package com.app.vaidyaa.server;

import java.util.List;

public class JSONBossResponse {
	Bossresponse bossresponse;

	public Bossresponse getBossResponse() {
		return bossresponse;
	}

	public void setBossResponse(Bossresponse bossresponse) {
		this.bossresponse = bossresponse;
	}
}

class Bossresponse {
	String responsecode;
	Web web;

	public String getResponsecode() {
		return responsecode;
	}

	public void setResponsecode(String responsecode) {
		this.responsecode = responsecode;
	}

	public Web getWeb() {
		return web;
	}

	public void setWeb(Web web) {
		this.web = web;
	}

}

class Web {
	int start;
	int count;
	int totalresults;
	List<Results> results;

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotalresults() {
		return totalresults;
	}

	public void setTotalresults(int totalresults) {
		this.totalresults = totalresults;
	}

	public List<Results> getResults() {
		return results;
	}

	public void setResults(List<Results> results) {
		this.results = results;
	}

}

class Results {
	String date;
	String clickurl;
	String url;
	String dispurl;
	String title;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getClickurl() {
		return clickurl;
	}

	public void setClickurl(String clickurl) {
		this.clickurl = clickurl;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDispurl() {
		return dispurl;
	}

	public void setDispurl(String dispurl) {
		this.dispurl = dispurl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}