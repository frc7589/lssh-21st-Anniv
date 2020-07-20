package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

import frc.robot.subsystems.*;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private static Constants m_constants;
  private static RobotContainer m_robotContainer;

  private static DriveSubsystem m_drive;

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    m_constants = new Constants();
    m_robotContainer = new RobotContainer();
  }

  /**
   * A simple getter method for RobotContainer.java
   * 
   * @return m_robotContainer
   */
  public static RobotContainer getRobotContainer() {
    return m_robotContainer;
  }

  /**
   * A simple getter method for Constant.java
   * 
   * @return m_Constant
   */
  public static Constants getConstants() {
    return m_constants;
  }

  /**
   * A simple getter method for Drivetrain.java
   * 
   * @return m_drive
   */
  public static DriveSubsystem getDrive() {
    return m_drive;
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {

    // Runs the Scheduler. This is responsible for polling buttons, adding
    // newly-scheduled
    // commands, running already-scheduled commands, removing finished or
    // interrupted commands,
    // and running subsystem periodic() methods. This must be called from the
    // robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
    // System.out.println(Robot.getDrivetrain().m_gyro.getRoll());
  } 

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your
   * {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    //m_autonomousCommand = m_robotContainer.getAutonomousCommand();
    m_autonomousCommand = null; // No need of Autonomous

    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }

  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }
}