/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {

  private WPI_VictorSPX baseLeft1 = new WPI_VictorSPX(0);
  private WPI_VictorSPX baseLeft2 = new WPI_VictorSPX(2);
  private WPI_VictorSPX baseRight1 = new WPI_VictorSPX(1);
  private WPI_VictorSPX baseRight2 = new WPI_VictorSPX(3);

  

  @Override
  public void robotInit() {
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testPeriodic() {
  }
}
