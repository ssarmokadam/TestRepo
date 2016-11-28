package com.devonfw.devonlocale.translator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.Set;

import com.devonfw.devonlocale.common.Node;

/**
 * TODO ssarmoka This type ...
 *
 * @author ssarmoka
 */
public class TranslationTargetImpl implements TranslationTarget {

  private StringBuffer startJsonStringBuffer = new StringBuffer();

  private StringBuffer endJsonStringBuffer = new StringBuffer();

  private StringBuffer completeJsonString = new StringBuffer();

  /**
   * {@inheritDoc}
   */
  public void generateStream(Map<String, Node> root, OutputStream out) {

    System.out.println("Complete json String is -- " + createJsonString(root).append("}"));

  }

  /**
   * {@inheritDoc}
   */
  public void generateFile(Map<String, Node> root, File out) {

    try {
      if (!out.exists()) {
        out.createNewFile();
      }
      FileWriter fw = new FileWriter(out.getAbsoluteFile());
      BufferedWriter bw = new BufferedWriter(fw);
      bw.write(createJsonString(root).append("}").toString());
      bw.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    // System.out.println("Complete json String is -- " + createJsonString(root).append("}"));

  }

  public StringBuffer createJsonString(Map<String, Node> root) {

    Node node;

    Map<String, Node> childMap;
    Set<String> keySet = root.keySet();
    for (String key : keySet) {
      node = root.get(key);
      if (node.getText() == null && node.getChildren().size() == 1) {
        childMap = node.getChildren();
        this.startJsonStringBuffer.append("\"" + key + "\": {");
        this.endJsonStringBuffer.append("}");
        createJsonString(childMap);
      } else if (node.getText() != null) {
        this.startJsonStringBuffer.append("\"" + key + "\" : " + "\"" + node.getText() + "\"");
        if (this.completeJsonString.toString().isEmpty()) {
          this.completeJsonString.append("{").append(this.startJsonStringBuffer).append(this.endJsonStringBuffer);
        } else {
          this.completeJsonString.append(",").append(this.startJsonStringBuffer).append(this.endJsonStringBuffer);
        }
        // System.out.println("jsonString " + this.completeJsonString.toString());
        this.startJsonStringBuffer = new StringBuffer();
        this.endJsonStringBuffer = new StringBuffer();
        // break;
      } else {
        System.out.println("Out of scope hence skipped");
      }

    }

    return this.completeJsonString;
  }

}
