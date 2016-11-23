package com.devonfw.devonlocale.translator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.devonfw.devonlocale.common.Node;
import com.devonfw.devonlocale.common.TreeNode;

/**
 * This is a class which is responsible for creating map from inputstream properties or property file.
 *
 * @author ssarmoka
 */
public class TranslationSourceImpl implements TranslationSource {

  /**
   *
   */
  public static String SPLIT_PROPERTY = "=";

  /**
   *
   */
  public static String SPLIT_KEY = "\\.";

  /**
   * {@inheritDoc}
   */
  public Map<String, Node> parseFile(InputStream in) {

    // TODO Auto-generated method stub
    return null;
  }

  /**
   * This method loads property file and create Map from it. Blank line at end of file will be ignored.
   */
  public Map<String, Node> parseFile(File in) {

    Map<String, Node> nodeList = new HashMap<String, Node>();
    FileInputStream fis;
    BufferedReader br;
    try {
      fis = new FileInputStream(in);
      br = new BufferedReader(new InputStreamReader(fis));
      String line = null;
      while ((line = br.readLine()) != null && !line.isEmpty()) {

        String[] propertyArray = line.split(SPLIT_PROPERTY);

        String key = propertyArray[0];
        String value = propertyArray[1];
        if (key.contains(".")) {
          Map<String, Node> nodeMap = createNodeMap(key, value, nodeList);
          nodeList.putAll(nodeMap);
        } else {
          TreeNode node = new TreeNode(propertyArray[1]);
          nodeList.put(propertyArray[0], node);
        }
      }
      System.out.println("final node list " + nodeList);
      br.close();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return nodeList;
  }

  /**
   * This method is responsible for creating map.This method checks if rootNode already exists in map if yes it add
   * property to existing nodes else it creates new node. For example: consider file containing property a.b.c.d=e and
   * a.b.c.g=k. In first case i.e a.b.c.d=e ,it will create all new nodes and add rootNode that is "a" to map.In next
   * case, it will first search map if "a" node exists , if yes it will check for if its children already exists, if no
   * it will create new node and add it to node "a", else it will append new property at appropriate level , in our
   * example, it will travel it node "c" and add g=k as its child.
   *
   * @param key
   * @param value
   */
  private Map<String, Node> createNodeMap(String key, String value, Map<String, Node> nodeMap) {

    String[] nodeKeyList = key.split(SPLIT_KEY);
    TreeNode node, prevNode = null;
    if (!nodeMap.containsKey(nodeKeyList[0])) {
      TreeNode leafNode = new TreeNode(value);
      prevNode = leafNode;
      for (int i = nodeKeyList.length - 1; i > 0; i--) {

        node = new TreeNode();
        node.getChildren().put(nodeKeyList[i], prevNode);
        prevNode = node;
      }
      nodeMap.put(nodeKeyList[0], prevNode);
    } else {
      getIfNodeexists(nodeMap, nodeKeyList, 0, key, value, null);
      // System.out.println("NodeMap after adding child " + nodeMap);
    }

    return nodeMap;
  }

  private void getIfNodeexists(Map<String, Node> nodeMap, String[] nodeKeyList, int level, String key, String value,
      Node prevNode) {

    Node node = null;
    if (nodeMap.containsKey(nodeKeyList[level])) {
      for (int i = level; i < nodeKeyList.length - 1; i++) {
        node = nodeMap.get(nodeKeyList[level]);
        nodeMap = node.getChildren();
        level++;
        getIfNodeexists(nodeMap, nodeKeyList, level, key, value, node);
      }
    } else {
      if (level == nodeKeyList.length - 1) {
        TreeNode leafNode = new TreeNode(value);
        prevNode.getChildren().put(nodeKeyList[level], leafNode);

      } else {
        for (int i = level; i < nodeKeyList.length - 1; i++) {
          TreeNode node1 = new TreeNode();
          prevNode.getChildren().put(nodeKeyList[level], node1);
        }

      }

    }

  }

}
