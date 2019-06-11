package com.xebia.assignment.utils;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

@Component
public class RobotBatteryConsumption {

	private AtomicInteger robotAvailableBattery = new AtomicInteger(100);
	
	public Integer getValue() {
		return robotAvailableBattery.decrementAndGet();
	}
	
	public Integer getCurrentValue() {
		return robotAvailableBattery.get();
	}
	
	public void rechargeBattery() {
		robotAvailableBattery.set(100);
	}
	
}
