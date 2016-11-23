package com.devonfw.devonlocale.common;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO ssarmoka This type ...
 *
 * @author ssarmoka
 */
public class TreeNode implements Node {

  // String text will be null for non-leaf nodes
  private String text = null;

  private Map<String, Node> childeNodeMap = new HashMap<String, Node>();

  public TreeNode() {

  }

  public TreeNode(String text) {
    this.text = text;
  }

  // public TreeNode(String key, String text) {
  // this.key = key;
  // this.text = text;
  // }

  /**
   * {@inheritDoc}
   */
  public boolean hasChildren() {

    if (this.childeNodeMap.isEmpty())
      return false;
    else
      return true;
  }

  /**
   * {@inheritDoc}
   */
  public String getText() {

    return this.text;
  }

  /**
   * {@inheritDoc}
   */
  public Map<String, Node> getChildren() {

    // Do I need to return null if no children exists?
    return this.childeNodeMap;
  }

}
