// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Control.XBoxControllerEE;
import frc.robot.subsystems.Drive.ArcadeDrive;
import frc.robot.subsystems.Drive.CurvatureDrive;
import frc.robot.subsystems.Drive.DriveSubsystem;
import frc.robot.subsystems.Drive.TankDrive;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  //Imports drive subsystem
  private final DriveSubsystem m_drive = new DriveSubsystem();

  //Creates a controller
  private final XBoxControllerEE m_controller = new XBoxControllerEE(0);

  //Creates a Chooser for smart dashboard
  SendableChooser<Integer> m_chooser = new SendableChooser<>();

  // The robot's subsystems and commands are defined here...

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    //Puts chooser on smart dashboard
    SmartDashboard.putData("Drive Mode", m_chooser);
    //Adds options for chooser
    m_chooser.addOption("Arcade Drive", 0);
    m_chooser.addOption("Curvature Drive", 1);
    m_chooser.addOption("Tank Drive", 2);
    m_chooser.setDefaultOption("Arcade Drive", 0);
    //Arcade drive active
    if(m_chooser.getSelected() == 0){
      m_drive.setDefaultCommand(new ArcadeDrive(
        () -> m_controller.getLeftY(),
        () -> m_controller.getLeftX(), 
        m_drive));
    } 
    //Tank drive active
    else if(m_chooser.getSelected() == 1){
      m_drive.setDefaultCommand(new TankDrive(
        () -> m_controller.getLeftY(),
        () -> m_controller.getRightY(), 
        m_drive));
    }
    //Curvature drive Active
    else if(m_chooser.getSelected() == 2){
      m_drive.setDefaultCommand(new CurvatureDrive(
        () ->  m_controller.getLeftY(),
        () -> m_controller.getRightX(), 
        m_drive));

    }

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
