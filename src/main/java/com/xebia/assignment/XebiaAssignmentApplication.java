package com.xebia.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.xebia.assignment.service.IRobotService;

@SpringBootApplication
@EnableScheduling
public class XebiaAssignmentApplication implements CommandLineRunner {

	@Autowired
	private IRobotService robotService;

	public static void main(String[] args) {
		SpringApplication.run(XebiaAssignmentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		robotService.runRobot();
	}

}
