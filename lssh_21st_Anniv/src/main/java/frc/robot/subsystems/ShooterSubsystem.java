package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class ShooterSubsystem extends SubsystemBase {
    private Servo ballController = new Servo(Robot.getConstants().getPWM("ball_pusher"));
    private WPI_VictorSPX wheel = new WPI_VictorSPX(Robot.getConstants().getCAN("wheel"));

    /**
   * Create a subsystem for shooter for the lssh 21st anniversary robot.
   */
    public ShooterSubsystem() {

    }

    public void BallControllerPush() {
        ballController.set(Constants.kPushAngle);
        System.out.println(ballController.get());
    }
    
    public void BallControllerPull() {
        ballController.set(Constants.kPullAngle);
    }

    public void StartShooting() {
        wheel.set(Constants.kWheelSpeed);
    }
    public void StopShooting() {
        wheel.set(0);
    }
}