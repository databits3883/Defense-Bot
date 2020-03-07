/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;



import com.revrobotics.CANSparkMax;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrainSubSys extends SubsystemBase {
  private final CANSparkMax leftMotor = new CANSparkMax(Constants.LEFT, MotorType.kBrushless);
  private final CANSparkMax rightMotor = new CANSparkMax(Constants.RIGHT, MotorType.kBrushless);

  private final CANEncoder leftEncoder = leftMotor.getEncoder();
  private final CANEncoder rightEncoder = rightMotor.getEncoder();

  public double getEncoderDistance(){
    return leftEncoder.getPosition();
  }

  //I have no idea whassst I'm doing
  //And I do???
  // /kill @e
  private final DifferentialDrive difDrive = new DifferentialDrive(leftMotor, rightMotor);
  public void driving (double X , double Y){
    difDrive.arcadeDrive(Y, X);
  }
  /**
   * Creates a new DriveTrainSubSys.
   */
  public DriveTrainSubSys() {
  }

  @Override
  public void periodic() {
    System.out.println(leftEncoder.getPosition());
    System.out.println(rightEncoder.getPosition());
    // This method will be called once per scheduler run
  }
}
