/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SpinningMotorSubSys extends SubsystemBase {
  private final VictorSP spinner = new VictorSP(Constants.SPIN);
  /**
   * Creates a new SpinningMotorSubSys.
   */
  public SpinningMotorSubSys() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public VictorSP getSpinner(){
    return spinner;
  }
}
