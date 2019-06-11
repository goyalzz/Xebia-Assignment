package com.xebia.assignment.service.impl;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xebia.assignment.service.IRobotService;
import com.xebia.assignment.utils.RobotBatteryConsumption;

@Service
public class RobotServiceImpl implements IRobotService {

	@Autowired
	private RobotBatteryConsumption consumption;

	private Integer roboWalkOnFullCharge = 5;

	private Integer extraConsumptionPerKg = 2;

	@SuppressWarnings("resource")
	@Override
	public void runRobot() {

		System.out.println("Hi, this is xebia robo.");
		System.out.println("Robot current battery is " + consumption.getCurrentValue() + "%");
		System.out.println(
				"Please Enter how much robot walked to calculate the remaining battery, If robot dosen't walk then enter walking dinstance 0");

		try {
			Scanner walkSc = new Scanner(System.in);
			Double robotWalkingKm = walkSc.nextDouble();
			if (!validateInput(robotWalkingKm)) {
				System.out.println("Invalid Input !!!");
			} else {
				Double remainedBattery = (double) (100 - ((100 / roboWalkOnFullCharge) * robotWalkingKm));
				System.out.println("Is the robot carrying any Object ? True / False");

				Scanner isCarryingObjSc = new Scanner(System.in);
				if (isCarryingObjSc.nextBoolean()) {
					System.out.println("Please Enter the weight of Object in KG");

					Scanner objWeightSc = new Scanner(System.in);
					Double weightOfObject = objWeightSc.nextDouble();
					if (!validateInput(weightOfObject)) {
						System.out.println("Invalid Input !!!");
					} else {
						remainedBattery -= extraConsumptionPerKg * weightOfObject;
						System.out
								.println("If robot is 100% charged then Remaining Battery is " + remainedBattery + "%");
					}
				} else {
					System.out.println("If robot is 100% charged then Remaining Battery is " + remainedBattery + "%");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		runRobot();
		consumption.rechargeBattery();
	}

	private Boolean validateInput(Double value) {
		return (value != null && value >= 0);
	}

}
