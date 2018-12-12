package com.github.dozer.output;


public class ServoWrapper implements Servo {

  private edu.wpi.first.wpilibj.Servo servo;
  /**
   * Constucts the ServoWrapper with the hardware pin.
   * Wraps edu.wpi.first.wpilibj.Servo
   * @method ServoWrapper
   * @param  pin The pin corresponding with the server in the hardware.
   */
  public ServoWrapper(int pin) {
    this.servo = new edu.wpi.first.wpilibj.Servo(pin);
  }

/**
 * Sets the angle of the wpilib server to the degrees.
 * @method setAngle
 * @param  degrees the amount of degrees the servo should turn.
 */
  public void setAngle(double degrees) {
    servo.setAngle(degrees);
  }
/**
 * Calls getAngle directly from the wpilibj Servo.
 * @method getAngle
 * @return the current angle that the servo is at.
 */
  public double getAngle(){
    return servo.getAngle();
  }

 /**
  * Uses Math to change radians into degrees and set Servo angle with those degrees.
  * @method setRadians
  * @param  radians the radians that the Servo will be set to
  */
  public void setRadians(double radians) {
    this.setAngle(Math.toDegrees(radians));
  }

/**
 * Returns the current radians that the Servo is set to based on the degrees from wpilibj.Servo.getAngle
 * @method getRadian
 * @return the current radians that the servo is at
 */
  public double getRadians(){
    return Math.toDegrees(this.getAngle());
  }
 /**
  * Sets the position of the servo using wpilibj.Servo.setPosition
  * @method setPosition
  * @param  pos the position the servo will be set to
  */
  public void setPosition(double pos){
    servo.setPosition(pos);
  }
/**
 * Gets the position of the servo using wpilibj.Servo.setPosition
 * @method getPosition
 * @return the position the servo is currently in
 */
  public double getPosition(){
    return servo.get();
  }
}
