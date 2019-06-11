package com.xebia.assignment.schedulers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.xebia.assignment.utils.RobotBatteryConsumption;

@Component
public class ConsumeBatteryOnRunScheduler {

	@Autowired
	private RobotBatteryConsumption consumption;

	@Scheduled(cron = "0 * * * * ?")
	public void scheduleTaskWithCronExpression() {
		Integer roboBattery = consumption.getValue();
		if (roboBattery <= 15) {
			System.out.println("My battery is critically low, i am going to shutdown in " + roboBattery + " minutes");
		}
		if (roboBattery == 0) {
			System.exit(0);
		}
	}

}
