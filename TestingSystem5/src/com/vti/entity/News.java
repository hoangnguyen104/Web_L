package com.vti.entity;

public class News implements INews {
	private int id;
	private String title;
	private String publishdate;
	private String author;
	private String contetnt;
	private Float averagerate;
	private int[] rate;
	public static int COUNT = 0;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContetnt() {
		return contetnt;
	}

	public void setContetnt(String contetnt) {
		this.contetnt = contetnt;
	}

	public Float getAveragerate() {
		return averagerate;
	}

	public int[] getRate() {
		return rate;
	}

	public void setRate(int[] rate) {
		this.rate = rate;
	}

	public News() {
		super();
		// TODO Auto-generated constructor stub
	}

	public News(String title, String publishdate, String author, String contetnt, int[] rate) {
		super();
		COUNT++;
		this.id = COUNT;
		this.title = title;
		this.publishdate = publishdate;
		this.author = author;
		this.contetnt = contetnt;
		this.rate = rate;

	}

	@Override
	public void display() {
		System.out.println("News [title=" + title + ", publishDate=" + publishdate + ", author=" + author + "]");

	}

	@Override
	public float calculate() {
		averagerate = (float) ((rate[0] + rate[1] + rate[2]) / 3);
		return averagerate;
	}
}
