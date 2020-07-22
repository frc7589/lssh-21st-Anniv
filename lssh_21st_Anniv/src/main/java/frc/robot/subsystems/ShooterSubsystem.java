package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class ShooterSubsystem extends SubsystemBase {
    private Servo ballController = new Servo(Robot.getConstants().getPWM("ball_pusher"));
    private WPI_VictorSPX upperWheel = new WPI_VictorSPX(Robot.getConstants().getCAN("upper_wheel"));
    private WPI_VictorSPX lowerWheel = new WPI_VictorSPX(Robot.getConstants().getCAN("lower_wheel"));

    private boolean shooting = false;

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

    public void ToggleShoot() {
        shooting = !shooting;

        if (shooting) {
            upperWheel.set(Constants.kUpperWheelSpeed);
            lowerWheel.set(Constants.kLowerWheelSpeed);
        }
        else {
            upperWheel.set(0);
            lowerWheel.set(0);
        }
    }
}