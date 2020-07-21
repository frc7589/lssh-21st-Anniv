package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class TankDrive extends CommandBase {
    private final DriveSubsystem m_drive;
    private final DoubleSupplier m_rightSide;
    private final DoubleSupplier m_leftSide;

    /**
     * 
     * @param drive
     * @param forward
     * @param rotation
     */
    public TankDrive(DriveSubsystem drive, DoubleSupplier rightSide, DoubleSupplier LeftSide) {
        m_drive = drive;
        m_rightSide = rightSide;
        m_leftSide = LeftSide;
        addRequirements(m_drive);
    }

    @Override
    public void execute() {
        m_drive.tankDrive(m_leftSide.getAsDouble(), m_rightSide.getAsDouble());
    }
}
