package com.devonfw.devonlocale.translator;

import java.io.File;
import java.io.OutputStream;
import java.util.Map;

import com.devonfw.devonlocale.common.Node;

/**
 * TODO ssarmoka This type ...
 *
 * @author ssarmoka
 */
public interface TranslationTarget {
  void generateStream(Map<String, Node> root, OutputStream out);

  void generateFile(Map<String, Node> root, File out);
}
