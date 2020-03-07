/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.DriveTrainSubSys;

import com.revrobotics.CANEncoder;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;

import edu.wpi.first.wpilibj2.command.PIDCommand;
/**
 * An example command that uses an example subsystem.
 */
public class DriveDistance extends PIDCommand {
  private final DriveTrainSubSys m_driveTrainSubSys = new DriveTrainSubSys();
    // double distance = m_driveTrainSubSys.getEncoderDistance();
  public DriveDistance(DriveTrainSubSys driveTrain) {
    super(
        // The controller that the command will use
        new PIDController(0, 0, 0),
        // This should return the measurement
        () -> driveTrain.getEncoderDistance(),
        // This should return the setpoint 
        () -> 12,
        // This uses the output
        output -> {
          // Use the output here
          driveTrain.driving(0, output);
        });
        Shuffleboard.getTab("PID").add(getController());
        Shuffleboard.getTab("PID").addNumber("input", () -> driveTrain.getEncoderDistance());
        if (driveTrain.getEncoderDistance() < 12){
          driveTrain.driving(0, 0.5);
        }
        else {
          driveTrain.driving(0, 0);
        }
  }
  
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  /**
   * Creates a new DriveDistance.
   *
   * @param subsystem The subsystem used by this command.
   */
  /* public DriveDistance(ExampleSubsystem subsystem) {
    m_subsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  } */

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
