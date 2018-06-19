package com.jcuke.plugin.util;

public enum Key {
  ;

  public static String createKey(String name) {
    return "com.jcuke.plugin." + name;
  }
}
