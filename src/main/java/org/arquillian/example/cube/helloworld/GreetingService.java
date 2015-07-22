package org.arquillian.example.cube.helloworld;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class GreetingService {

	public String greet(String who) {
		return "Hello, " + who + "!";
	}
}
