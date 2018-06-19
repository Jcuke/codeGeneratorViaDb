package com.jcuke.plugin.generator.source;

import org.apache.velocity.app.VelocityEngine;

public interface VelocityEngineAware {

  void setVelocityEngine(VelocityEngine ve, String encoding);
}
