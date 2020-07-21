package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class ShooterSubsystem extends SubsystemBase {
    private Servo ballPusher = new Servo(Robot.getConstants().getPWM("ball_pusher"));

    public ShooterSubsystem() {
    }

    public void push() {
        ballPusher.set(Constants.kPushAngle);
    }
    
    public void pull() {
        ballPusher.set(Constants.kPullAngle);
    }
}