package com.demo.spring.SpringFramework;

import org.springframework.stereotype.Component;

@Component
public class Pencil  implements  Accessories{
	public  void write() {
		System.out.println("Pencil  is  writing");
	}
}
