package com.cb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProfilesRunner implements CommandLineRunner {

	@Value("${server.port}")
	private String port;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(port);
	}

}
