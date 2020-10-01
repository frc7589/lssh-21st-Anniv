package frc.robot.commands;

import frc.robot.subsystems.ElevatorSubsystem;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ElevatorDown extends CommandBase {
    private final ElevatorSubsystem m_elevator;

    public ElevatorDown(ElevatorSubsystem elevator) {
        m_elevator = elevator;
        addRequirements(m_elevator);
    }

    @Override
    public void execute() {
        m_elevator.ElevatorControl(-1);
    }

    @Override
    public void end(boolean interrupted) {
        m_elevator.Stop();
    }
}