package com.devonfw.devonlocale;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.devonfw.devonlocale.common.Node;
import com.devonfw.devonlocale.translator.TranslationSource;
import com.devonfw.devonlocale.translator.TranslationSourceImpl;
import com.devonfw.devonlocale.translator.TranslationTargetImpl;

/**
 * This is a main class. Here we will read property file may be from console or input file. We will first convert it to
 * map<String,Node>. Further we will convert map to output target format.
 *
 * @author ssarmoka
 */
public class DevonLocale {

  private TranslationSource translationSource;

  private TranslationTargetImpl translationTarget;

  public static final String INPUT = "input";

  public static final String INFORMAT = "informat";

  public static final String OUTPUT = "output";

  public static final String OUTFORMAT = "outformat";

  public DevonLocale() {
    this.translationSource = new TranslationSourceImpl();
    this.translationTarget = new TranslationTargetImpl();
  }

  public static void main(String[] args) {

    Map<String, Node> propertyTreeMap;
    System.out.println("Devon Locale");
    DevonLocale locale = new DevonLocale();

    CommandLineParser parser = new BasicParser();
    try {
      CommandLine cmd = parser.parse(locale.getOptions(), args);
      if (cmd.hasOption(INPUT)) {
        String input = cmd.getOptionValue(INPUT);
        String outputFormat = cmd.getOptionValue(OUTFORMAT);
        if (input.contains(".properties") && new File(input).exists()) {
          propertyTreeMap = locale.translationSource.parseFile(new File(input));
        } else {
          // parse commandline
          System.out.println("Input value ----------- " + input);
          InputStream stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
          propertyTreeMap = locale.translationSource.parseStream(stream);
        }
        System.out.println("map " + propertyTreeMap);
        locale.generateOutput(outputFormat, cmd, propertyTreeMap);
      } else {
        System.out.println("Translation source not present");
      }

    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  /**
   * @return
   */
  private Options getOptions() {

    Options options = new Options();
    options.addOption("i", INPUT, true, "File containing source translation");
    options.addOption("f", "informat", true, "Format of the source translation. Possible values: ”java” or  “xliff” ");
    options.addOption("o", "output", true, "File with target translation");
    options.addOption("t", "outformat", true, "Format of the target translation Possible values: “angular” or “extjs”");
    return options;
  }

  private void generateOutput(String outputFormat, CommandLine cmd, Map<String, Node> propertyTreeMap) {

    switch (outputFormat) {

    case "json":
      if (cmd.hasOption(OUTPUT)) {
        String outputFile = cmd.getOptionValue(OUTPUT);
        if (!new File(outputFile).exists()) {
          File resultFile = new File(outputFile);
          this.translationTarget.generateFile(propertyTreeMap, resultFile);
        } else {
          this.translationTarget.generateFile(propertyTreeMap, new File(outputFile));
        }

      } else {
        System.out.println("propertyTreeMap " + propertyTreeMap);
        this.translationTarget.generateStream(propertyTreeMap, System.out);
      }
      break;

    case "js":

    default: // Converting to json as of now
      if (cmd.hasOption(OUTPUT)) {
        String outputFile = cmd.getOptionValue(OUTPUT);
        if (!new File(outputFile).exists()) {
          File resultFile = new File(outputFile);
          this.translationTarget.generateFile(propertyTreeMap, resultFile);
        } else {
          this.translationTarget.generateFile(propertyTreeMap, new File(outputFile));
        }

      } else {
        System.out.println("propertyTreeMap " + propertyTreeMap);
        this.translationTarget.generateStream(propertyTreeMap, System.out);
      }
      break;
    }
  }

}
