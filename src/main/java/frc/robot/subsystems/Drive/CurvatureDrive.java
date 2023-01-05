// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Drive;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class CurvatureDrive extends CommandBase {
  /** Creates a new TankDrive. */

  //Declares Variables
  DoubleSupplier m_fwd, m_rot;
  DriveSubsystem m_drive;

  /**
   * 
   * @param forward The speed of forward and back
   * @param rotation The speed of steering
   * @param drive The drive Subsystem
   */
  public CurvatureDrive(DoubleSupplier forward, DoubleSupplier rotation, DriveSubsystem drive) {
    //Sets passed in variables to member variables
    m_fwd = forward;
    m_rot = rotation;
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
    //drives the robot in curvature
    m_drive.curvatureDrive(m_fwd.getAsDouble(), m_rot.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //stops the drivebase
    m_drive.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
