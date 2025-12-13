package com.vti.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Exam {
	public int id;
	public String code;
	public String title;
	public CategoryQuestion categoryquestion;
	public LocalTime duration;
	public Account creator;
	public LocalDate createdate;
	public Question[] questions;
}
