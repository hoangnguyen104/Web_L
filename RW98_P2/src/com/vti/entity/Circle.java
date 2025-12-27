package com.vti.entity;

public class Circle {
	private double radius = 1.0;
	private String color = "red";

	// Constructor mặc định
	public Circle() {
	}

	// Constructor 1 tham số
	public Circle(double radius) {
		this.radius = radius;
	}

	// Constructor đầy đủ
	public Circle(double radius, String color) {
		this.radius = radius;
		this.color = color;
	}

	// Getter & Setter
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	// Tính diện tích
	public double getArea() {
		return Math.PI * radius * radius;
	}

	// Tính chu vi
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}

	@Override
	public String toString() {
		return "Circle[radius=" + radius + ", color=" + color + "]";
	}
}
