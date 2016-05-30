package tom.yang.javalab.apache.common.cli;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class App {
    public static void main(String[] args) throws ParseException {
        Options options = new Options();
        Option op = Option.builder("p").desc("parameter").hasArg().required().build();
        options.addOption(op);

        CommandLine cmd = new DefaultParser().parse(options, args);

        if (cmd.hasOption('p')) {
            System.out.println(cmd.getOptionValue('p'));
        }
    }
}
