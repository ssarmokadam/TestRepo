package com.devonfw.devonlocale;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * TODO ssarmoka This type ...
 *
 * @author ssarmoka
 */
public class TestClass {
  public static void main(String[] args) {

    TestClass t = new TestClass();
    try {
      CommandLineParser parser = new BasicParser();
      CommandLine cmd = parser.parse(t.getOptions(), args);
      System.out.println("Commandline options " + cmd.getOptions());
      System.out.println("args " + args);
      if (cmd.hasOption("input")) {
        System.out.println(cmd.getOptionValue("input"));
      }
      if (cmd.hasOption("informat")) {
        System.out.println(cmd.getOptionValue("informat"));
      }
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    // Scanner scanner = new Scanner(System.in);
    // String inputString = scanner.nextLine();
    // TestClass t = new TestClass();
    // CommandLineParser parser = new BasicParser();
    // try {
    // CommandLine cmd = parser.parse(t.getOptions(), args);
    // if (cmd.hasOption("help")) {
    // System.out.println("This will provide help for Devon locale ");
    // System.exit(0);
    // }
    //
    // if (cmd.hasOption("devconlocale")) {
    // Properties props = cmd.getOptionProperties("devconlocale");
    // String input=props.getProperty("input");
    //
    // System.out.println(props.getProperty("input"));
    // System.out.println(props.getProperty("informat"));
    // }
    // } catch (ParseException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }

  }

  private Options getOptions() {

    Options options = new Options();
    Option option1 = new Option("help", "This will provide help for Devon Locale");
    // Option option2 = new Option("input", "input file");
    Option option3 = new Option("informat", "input file format");
    Option option4 = new Option("output", "outputfile format");
    Option option5 = new Option("outformat", "output file format");

    options.addOption(option1);
    options.addOption("i", "input", true, "inputfile");
    options.addOption(option3);
    options.addOption(option4);
    options.addOption(option5);

    // Option option1 = new Option("help", "This will provide help for Devon Locale");
    //
    // // Option option2 = new Option("devonlocale", "This will be input file or input text");
    // // Option option3 = new Option("informat", "This will be input format");
    // // Option option4 = new Option("output", "this will be output file");
    // // Option option5 = new Option("outformat", "This will be outputFormat");
    // options.addOption(option1);
    // // options.addOption(option2);
    // // options.addOption(option3);
    // // options.addOption(option4);
    // // options.addOption(option5);
    // // TODO Auto-generated method stub
    //
    // OptionBuilder.withLongOpt("devconlocale");
    // OptionBuilder.withArgName("property=value");
    // OptionBuilder.hasArgs(2);
    // OptionBuilder.withValueSeparator();
    // OptionBuilder.withDescription("Get all properties");
    // Option status = OptionBuilder.create('s');
    // options.addOption(status);
    return options;
  }
}
