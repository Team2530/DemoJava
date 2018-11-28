/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2530.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Spark;

/**
 * This sample program shows how to control a motor using a joystick. In the
 * operator control part of the program, the joystick is read and the value is
 * written to the motor.
 *
 * <p>Joystick analog values range from -1 to 1 and speed controller inputs also
 * range from -1 to 1 making it easy to work together.
 */
public class Robot extends IterativeRobot {
	//Hi lol i can commit things and have fun
	private static final int kMotorPort1 = 0;
	private static final int kMotorPort2 = 1;
	private static final int kMotorPort3 = 2;
	private static final int kMotorPort4 = 3;

	private static final int kJoystickPort = 0;

	//private SpeedController m_motor;
	private VictorSP m_motor1;
	private VictorSP m_motor2;
	private VictorSP m_motor3;
	private VictorSP m_motor4;

	//VictorSP exampleVictorSP = new VictorSP(12);
	private Joystick m_joystick;
	
	DigitalInput limitSwitch;
	

	@Override
	public void robotInit() {
		m_motor1 = new VictorSP(kMotorPort1);
		m_motor2 = new VictorSP(kMotorPort2);
		m_motor3 = new VictorSP(kMotorPort3);
		m_motor4 = new VictorSP(kMotorPort4);

		m_joystick = new Joystick(kJoystickPort);
		
		limitSwitch = new DigitalInput(7);
	}

	@Override
	public void teleopPeriodic() {
		
		while (limitSwitch.get()) {
			m_motor1.set(m_joystick.getY());
			m_motor2.set(m_joystick.getY());
			m_motor3.set(m_joystick.getY());
			m_motor4.set(m_joystick.getY());
		}

	}
}
