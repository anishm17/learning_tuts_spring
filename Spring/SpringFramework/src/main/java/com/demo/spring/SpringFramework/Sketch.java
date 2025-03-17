package com.demo.spring.SpringFramework;

import org.springframework.beans.factory.annotation.Autowired;

public class Sketch {
	
	private  String  thickness;
	
	@Autowired
    Pen pen;
    
	public Sketch(String thickness) {
		super();
		this.thickness = thickness;
	}

	public String getThickness() {
		return thickness;
	}

	public void setThickness(String thickness) {
		this.thickness = thickness;
	}

	@Override
	public String toString() {
		pen.write();
		return "Sketch [thickness=" + thickness + "]";
	}



}
