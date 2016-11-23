package com.devonfw.devonlocale;

import java.io.File;

import com.devonfw.devonlocale.translator.TranslationSourceImpl;

/**
 * TODO ssarmoka This type ...
 *
 * @author ssarmoka
 */
public class DevonLocale {

  public static void main(String[] args) {

    System.out.println("Devon Locale");
    // Input input = new ConsoleInput(System.in, System.out);
    // Output output = new ConsoleOutput(System.out);
    // ConsoleInputManager inputManager = new ConsoleInputManager(input, output);
    // inputManager.parse(args);
    TranslationSourceImpl impl = new TranslationSourceImpl();
    File file = new File("D:/Devon2.0.1/workspaces/main/devon-locale/src/main/resources/sample.properties");
    impl.parseFile(file);
  }

}
