package com.demo.spring.SpringFramework;

import org.springframework.stereotype.Component;

@Component
public class Pen  implements  Accessories{

	public  void write() {
		System.out.println("Pen  is  writing");
	}
}
