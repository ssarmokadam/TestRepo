package com.devonfw.devonlocale.translator;

import java.io.File;
import java.io.InputStream;
import java.util.Map;

import com.devonfw.devonlocale.common.Node;

/**
 * TODO ssarmoka This type ...
 *
 * @author ssarmoka
 */
public interface TranslationSource {

  Map<String, Node> parseStream(InputStream in);

  Map<String, Node> parseFile(File in);
}
