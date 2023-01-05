// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Drive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CanConstants;

public class DriveSubsystem extends SubsystemBase {
  //Creates motor objects
  WPI_TalonFX m_rightFront = new WPI_TalonFX(CanConstants.RIGHT_FRONT_MOTOR);
  WPI_TalonFX m_rightBack = new WPI_TalonFX(CanConstants.RIGHT_BACK_MOTOR);
  WPI_TalonFX m_leftFront = new WPI_TalonFX(CanConstants.LEFT_FRONT_MOTOR);
  WPI_TalonFX m_leftBack = new WPI_TalonFX(CanConstants.LEFT_BACK_MOTOR);

  //Groups left and right side motors
  MotorControllerGroup m_left = new MotorControllerGroup(m_leftFront, m_leftBack);
  MotorControllerGroup m_right = new MotorControllerGroup(m_rightFront, m_rightBack);

  //Creates a differential drive object
  DifferentialDrive m_drive;

  public DriveSubsystem() {
    //Inverts right side
    m_rightFront.setInverted(true);
    m_rightBack.setInverted(true);

    //Gives left and right side motor groups to the differential drive
    m_drive = new DifferentialDrive(m_leftFront, m_rightFront);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  /**
   * 
   * @param fwd The forward speed
   * @param rot the steering speed
   */
  public void arcadeDrive(double fwd, double rot){
    m_drive.arcadeDrive(fwd, rot);
  }

  /**
   * 
   * @param leftSpeed The left side driving speed
   * @param rightSpeed the right side driving speed
   */
  public void tankDrive(double leftSpeed, double rightSpeed){
    m_drive.tankDrive(leftSpeed, rightSpeed);
  }

  /**
   * 
   * @param fwd forward speed
   * @param rot the steering speed
   */
  public void curvatureDrive(double fwd, double rot){
    m_drive.curvatureDrive(fwd, rot, true);
  }

  //Sets the drivebase speed to zero
  public void stop(){
    m_drive.tankDrive(0.0, 0.0);
  }
} 
