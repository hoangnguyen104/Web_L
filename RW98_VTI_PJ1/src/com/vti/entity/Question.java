package com.vti.entity;

import java.time.LocalDate;

public class Question {
	public int id;
	public String content;
	public LocalDate createdate;
	public Account creatorid;
	public CategoryQuestion categoryquestion;
	public TypeQuestion typequestion;
	public Answer[] answers;
}
