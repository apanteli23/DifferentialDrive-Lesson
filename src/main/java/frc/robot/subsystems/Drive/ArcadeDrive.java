// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Drive;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ArcadeDrive extends CommandBase {
  /** Creates a new TankDrive. */

  //Declares variables
  DoubleSupplier m_fwd, m_rot;
  DriveSubsystem m_drive;

  /**
   * 
   * @param forward The speed forward and back
   * @param rotation The speed for rotation
   * @param drive Drive Subsystem
   */
  public ArcadeDrive(DoubleSupplier forward, DoubleSupplier rotation, DriveSubsystem drive) {
    //Sets variables passed in to member variables
    m_fwd = forward;
    m_rot = rotation;
    m_drive = drive;

    //the command takes over control of drive subsystem
    addRequirements(m_drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    //Drives in arcade
    m_drive.arcadeDrive(m_fwd.getAsDouble(), m_rot.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //stops drive base
    m_drive.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
