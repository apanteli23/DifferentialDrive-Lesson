// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Drive;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class TankDrive extends CommandBase {
  /** Creates a new TankDrive. */

  //Declares Variables
  DoubleSupplier m_leftSpeed, m_rightSpeed;
  DriveSubsystem m_drive;

  /**
   * 
   * @param leftSpeed The speed of the left side of the drivebase
   * @param rightSpeed The speed of the right side of the drivebase
   * @param drive The drive subsystem
   */
  public TankDrive(DoubleSupplier leftSpeed, DoubleSupplier rightSpeed, DriveSubsystem drive) {
    //Sets member variables to passed in variables
    m_leftSpeed = leftSpeed;
    m_rightSpeed = rightSpeed;
    m_drive = drive;
    //The command takes control of the drivetrain
    addRequirements(m_drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //Drives the drive base in tank drive
    m_drive.tankDrive(m_leftSpeed.getAsDouble(), m_rightSpeed.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //Stops the drive base
    m_drive.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
