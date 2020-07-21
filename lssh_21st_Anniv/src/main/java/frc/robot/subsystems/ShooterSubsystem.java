package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class ShooterSubsystem extends SubsystemBase {
    private Servo ballController = new Servo(Robot.getConstants().getPWM("ball_pusher"));

    /**
   * Create a subsystem for shooter for the lssh 21st anniversary robot. Not completed.
   */
    public ShooterSubsystem() {

    }

    public void BallControllerPush() {
        ballController.set(Constants.kPushAngle);
    }
    
    public void BallControllerPull() {
        ballController.set(Constants.kPullAngle);
    }
}