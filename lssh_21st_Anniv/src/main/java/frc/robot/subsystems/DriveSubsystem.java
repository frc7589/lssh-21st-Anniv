package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;

public class DriveSubsystem extends SubsystemBase {
    WPI_VictorSPX leftF = new WPI_VictorSPX(Robot.getConstants().getCAN("drive_lf"));
    WPI_VictorSPX leftB = new WPI_VictorSPX(Robot.getConstants().getCAN("drive_lb"));
    WPI_VictorSPX rightF = new WPI_VictorSPX(Robot.getConstants().getCAN("drive_rf"));
    WPI_VictorSPX rightB = new WPI_VictorSPX(Robot.getConstants().getCAN("drive_rb"));
    private SpeedControllerGroup leftSide = new SpeedControllerGroup(leftF, leftB);
    private SpeedControllerGroup rightSide = new SpeedControllerGroup(rightF, rightB);
    private DifferentialDrive m_drive = new DifferentialDrive(leftSide, rightSide);
    /**
   * Creates a new DriveSubsystem. Require 4 WPI_VictorSPX Motor Controller, two for the left side, two for the right.
   */
  public DriveSubsystem() {
  }
  @Override
  public void periodic() {
  }

  public void tankDrive (double left, double right)
  {
    m_drive.tankDrive(left, right, false);
  }

  public void arcadeDrive(double fwd, double rot) {
    m_drive.arcadeDrive(fwd, rot, true);
  }
}