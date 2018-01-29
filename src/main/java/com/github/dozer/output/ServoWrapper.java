package com.github.dozer.output;


public class ServoWrapper implements Servo {

  private edu.wpi.first.wpilibj.Servo servo;

  public ServoWrapper(int pin) {
    this.servo = new edu.wpi.first.wpilibj.Servo(pin);
  }


  public void setAngle(double degrees) {
    servo.setAngle(degrees);
  }

  public double getAngle(){
    return servo.getAngle();
  }

  public void setRadians(double radians) {
    this.setAngle(Math.toDegrees(radians));
  }

  public double getRadians(){
    return Math.toDegrees(this.getAngle());
  }

  public void setPosition(double pos){
    servo.setPosition(pos);
  }

  public double getPosition(){
    return servo.get();
  }
}
