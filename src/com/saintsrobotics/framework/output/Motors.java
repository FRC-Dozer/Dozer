package com.saintsrobotics.framework.output;

import java.util.HashMap;
import java.util.Map;

public abstract class Motors {


  private Map<String, Motor> motorList = new HashMap<>();

  public void init() {
    motorList.values().forEach(Motor::init);
  }

  public void stopAll() {
    motorList.values().forEach(Motor::stop);
  }

  public void update() {
    motorList.values().forEach(Motor::update);
  }

}
