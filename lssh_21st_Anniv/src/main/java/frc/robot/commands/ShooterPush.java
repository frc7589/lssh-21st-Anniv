package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterPush extends CommandBase {
    private ShooterSubsystem m_shooter;
    public ShooterPush(ShooterSubsystem shooter) {
        m_shooter = shooter;
        addRequirements(m_shooter);
    }

    @Override
    public void execute() {
        m_shooter.push();
    }
}