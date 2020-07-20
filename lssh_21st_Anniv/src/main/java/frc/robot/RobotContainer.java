/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.subsystems.*;
import frc.robot.commands.*;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private final DriveSubsystem m_drive = new DriveSubsystem();

  public XboxController m_xboxController = new XboxController(0);

  public RobotContainer() {
    configureButtonBindings();

    m_drive.setDefaultCommand(
       new TankDrive(
         m_drive,
         () -> m_xboxController.getY(Hand.kLeft),
         () -> m_xboxController.getX(Hand.kRight)));
  }

  private void configureButtonBindings() {
    // toggle to tank drive
    new JoystickButton(m_xboxController, Button.kStart.value)
      .whenPressed(
        new TankDrive(
          m_drive,
          () -> m_xboxController.getY(Hand.kLeft),
          () -> m_xboxController.getY(Hand.kRight)), true);

    // toggle to arcade drive
    new JoystickButton(m_xboxController, Button.kBack.value)
      .whenPressed(
        new ArcadeDrive(
          m_drive,
          () -> m_xboxController.getY(Hand.kLeft),
          () -> m_xboxController.getX(Hand.kRight)), true);
  }

  /**
   * A simple getter method for the drivetrain system
   * @return m_drive
   */
  public DriveSubsystem getDrive() {
    return m_drive;
  }
}