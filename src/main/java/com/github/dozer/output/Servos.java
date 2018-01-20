package com.github.dozer.output;

import java.util.HashMap;
import java.util.Map;

public abstract class Servos {

  private Map<String, ServoWrapper> servos = new HashMap<>();

  public void init() {
    servos.values().forEach(ServoWrapper::init);
  }
}
