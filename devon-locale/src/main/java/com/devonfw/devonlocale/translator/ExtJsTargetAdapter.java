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
public class ExtJsTargetAdapter implements TranslationTarget {

  private StringBuffer prefix = new StringBuffer(
      "Ext.define(\'Sample.view.table.i18n.Table_en_EN\',{extend:\'Devon.I18nBundle\',singleton:true,i18n:{");

  private StringBuffer postfix = new StringBuffer(", only_en_EN:'Only in english'}});");

  private StringBuffer startJsStringBuffer = new StringBuffer();

  private StringBuffer endJsStringBuffer = new StringBuffer();

  private StringBuffer completeJsString = new StringBuffer();

  /**
   * {@inheritDoc}
   */
  @Override
  public void generateStream(Map<String, Node> root, OutputStream out) {

    System.out.println("Complete js String is -- " + this.prefix.append(createJsString(root)).append(this.postfix));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void generateFile(Map<String, Node> root, File out) {

    try {
      if (!out.exists()) {
        out.createNewFile();
      }
      FileWriter fw = new FileWriter(out.getAbsoluteFile());
      BufferedWriter bw = new BufferedWriter(fw);
      bw.write(this.prefix.append(createJsString(root)).append(this.postfix).toString());
      bw.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    // System.out.println("Complete json String is -- " + createJsonString(root).append("}"));

  }

  public StringBuffer createJsString(Map<String, Node> root) {

    Node node;

    Map<String, Node> childMap;
    Set<String> keySet = root.keySet();
    for (String key : keySet) {
      node = root.get(key);
      if (node.getText() == null && node.getChildren().size() == 1) {
        childMap = node.getChildren();
        this.startJsStringBuffer.append(key + ": {");
        this.endJsStringBuffer.append("}");
        createJsString(childMap);
      } else if (node.getText() != null) {
        this.startJsStringBuffer.append(key + " : " + "\'" + node.getText() + "\'");
        if (this.completeJsString.toString().isEmpty()) {
          this.completeJsString.append(this.startJsStringBuffer).append(this.endJsStringBuffer);
        } else {
          this.completeJsString.append(",").append(this.startJsStringBuffer).append(this.endJsStringBuffer);
        }
        // System.out.println("jsonString " + this.completeJsonString.toString());
        this.startJsStringBuffer = new StringBuffer();
        this.endJsStringBuffer = new StringBuffer();
        // break;
      } else {
        System.out.println("Out of scope hence skipped");
      }

    }

    return this.completeJsString;
  }

}
