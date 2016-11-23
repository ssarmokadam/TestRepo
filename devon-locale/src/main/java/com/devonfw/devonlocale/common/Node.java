package com.devonfw.devonlocale.common;

import java.util.Map;

/**
 * TODO ssarmoka This type ...
 *
 * @author ssarmoka
 */
public interface Node {

  boolean hasChildren();

  String getText();

  Map<String, Node> getChildren();
}
