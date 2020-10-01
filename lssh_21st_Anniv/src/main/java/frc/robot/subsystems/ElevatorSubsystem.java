package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class ElevatorSubsystem extends SubsystemBase {
    private WPI_TalonSRX elevator = new WPI_TalonSRX(Robot.getConstants().getCAN("elevator"));

    /**
   * Create a elevator subsystem.
   */
    public ElevatorSubsystem() {

    }

    public void ElevatorControl(int action) {
        elevator.set(Constants.kElevatorSpeed * action);
    }

    public void Stop() {
        elevator.set(0);
    }
}