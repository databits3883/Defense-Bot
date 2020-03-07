/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.DigitalInput;

import frc.robot.Constants;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.DriveDistance;
import frc.robot.subsystems.DriveTrainSubSys;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.SpinningMotorSubSys;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;



/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private final Joystick driverStick = new Joystick (0);
  private final JoystickButton driverButton8 = new JoystickButton(driverStick, 8);
  private final JoystickButton driverButton9 = new JoystickButton(driverStick, 9);

  // The robot's subsystems and commands are defined here...
  private final DriveTrainSubSys m_driveTrainSubSys = new DriveTrainSubSys();
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final SpinningMotorSubSys m_spinningMotorSubSys = new SpinningMotorSubSys();
  
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  private final Command ManualDrive = new RunCommand(()-> m_driveTrainSubSys.driving(driverStick.getX() , driverStick.getY() * -1), m_driveTrainSubSys);
  
  private final VictorSP spinner = m_spinningMotorSubSys.getSpinner();
  private final Command spinON = new InstantCommand(()-> spinner.set(1.0));
  private final Command spinOFF = new InstantCommand(()-> spinner.set(0));

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    m_driveTrainSubSys.setDefaultCommand(ManualDrive);
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    VictorSP spinner = m_spinningMotorSubSys.getSpinner();
    driverButton8.whenPressed(spinON);
    driverButton8.whenReleased(spinOFF);
    // driverButton9.whenPressed(???);
    // driverButton9.whenReleased(???);
  }



  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    //return m_autoCommand;
    return null;
  }
}
// pwm to talk to victor sp