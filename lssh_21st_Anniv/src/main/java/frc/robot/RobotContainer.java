/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
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
  private final ShooterSubsystem m_shooter = new ShooterSubsystem();

  public XboxController m_xboxController = new XboxController(0);

  public RobotContainer() {
    configureButtonBindings();

    m_drive.setDefaultCommand(
      new TankDrive(
        m_drive,
        () -> m_xboxController.getY(Hand.kLeft) * Constants.kDriveSpeed,
        () -> m_xboxController.getY(Hand.kRight) * Constants.kTurnSpeed));
  }

  private void configureButtonBindings() {
    // toggle to tank drive
    new JoystickButton(m_xboxController, Button.kStart.value)
      .whenPressed(
        new TankDrive(
          m_drive,
          () -> m_xboxController.getY(Hand.kLeft) * Constants.kDriveSpeed,
          () -> m_xboxController.getY(Hand.kRight) * Constants.kTurnSpeed), true);

    // toggle to arcade drive
    new JoystickButton(m_xboxController, Button.kBack.value)
      .whenPressed(
        new ArcadeDrive(
          m_drive,
          () -> m_xboxController.getY(Hand.kLeft) * Constants.kDriveSpeed,
          () -> m_xboxController.getX(Hand.kRight) * Constants.kDriveSpeed), true);

    new JoystickButton(m_xboxController, Button.kB.value)
      .whenPressed(new ShooterPush(m_shooter), true)
      .whenReleased(new ShooterPullback(m_shooter), true);
    new JoystickButton(m_xboxController, Button.kA.value)
      .toggleWhenPressed(new Shoot(m_shooter), true);
  }

  /**
   * A simple getter method for the drivetrain system
   * @return m_drive
   */
  public DriveSubsystem getDrive() {
    return m_drive;
  }
}