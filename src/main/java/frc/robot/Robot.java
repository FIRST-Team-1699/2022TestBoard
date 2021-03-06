// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;


/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  public Joystick joystick;
  public VictorSP m_motor0;
  public VictorSP m_motor1;
  public double throtSpd;

  
  

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    //m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    //m_chooser.addOption("My Auto", kCustomAuto);
    //SmartDashboard.putData("Auto choices", m_chooser);
    joystick = new Joystick(0);
    m_motor0 = new VictorSP(0);
    m_motor1 = new VictorSP(1);
  }

//For testing motors 
 
  public void printOut(){
   

    // Toggle motors from buttons
    if (joystick.getRawButton(8)){
      //System.out.println("Motor 0 (button 8) speed is now: "+joystick.getZ());
      m_motor0.set(joystick.getZ());
    }
    if (joystick.getRawButton(9)) {
      //System.out.println("Motor 1 (button 9) speed is now: "+joystick.getZ());
      m_motor1.set(joystick.getZ());
    if (joystick.getRawButton(2));
      m_motor0.set(0);
      m_motor1.set(0);
    }

  }
  


  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {}

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {

      // if (joystick.getRawButton(8)){
      //   m_motor0.set(joystick.getZ());
      // }else{
      //   m_motor0.set(0);
      // }
      // if (joystick.getRawButton(9)) {
      //   m_motor1.set(joystick.getZ());
      // }else
      // {
      //   m_motor1.set(0);
      // }
    if (joystick.getRawButton(11)){
      m_motor0.set(joystick.getZ());
      m_motor1.set(-1*joystick.getZ());  
    } else {
      m_motor0.set(0);
      m_motor1.set(0);
    }
      
      // if button throttle mode is enabled, increase and decrease the throttle based on buttons 6 and 7.

  // else {
  //   m_motor0.set(throtSpd/100);
  //   if (joystick.getRawButtonPressed(6)) {
  //     m_motor0.set(m_motor0.get() + 0.01);
  //     m_motor1.set(m_motor0.get() + 0.01);
  //     System.out.println("Throttle value: "+throtSpd+"%");
  //   }
  //   else if (joystick.getRawButtonPressed(7)){
  //     m_motor0.set(m_motor0.get() - 0.01);
  //     m_motor1.set(m_motor0.get() - 0.01);
  //     System.out.println("Throttle value: "+throtSpd+"%");
  //   }




    throtSpd = 100*joystick.getZ();
    throtSpd = Math.round(throtSpd);
    if (joystick.getRawButtonReleased(8) || joystick.getRawButtonReleased(9) || joystick.getRawButtonReleased(11)) {
      System.out.println("Throttle value: "+throtSpd+"%");
    }
    if (joystick.getRawButtonPressed(10)) {
      System.out.println("Throttle value: "+throtSpd+"%");
    }
    // if (joystick.getRawButtonPressed(11)) {
    //   buttThrot = !buttThrot;
    //   System.out.println("Button throttle mode toggled. 6 to increase throttle by 1, 7 to decrease by 1");
    // }

  }
}
