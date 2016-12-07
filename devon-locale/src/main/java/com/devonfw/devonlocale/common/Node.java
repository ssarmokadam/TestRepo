package com.devonfw.devonlocale.common;

import java.util.Map;

/**
 * General interface for listing tree node functionality.s 
 *
 * @author ssarmoka
 */
public interface Node {

  boolean hasChildren();

  String getText();

  Map<String, Node> getChildren();
}
