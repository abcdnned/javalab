package tom.yang.javalab.apache.cli;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class CommandLineInterface {

	public static void main(final String[] args) throws ParseException {
		final Options options=new Options();
		options.addOption("o", true, "output file path.");
		options.addOption("i", true, "input excel path.");
		options.addOption("c", true, "output config file path.");
		final Option required = Option.builder("r").desc("required arg.").hasArg().required().build();
		options.addOption(required);

		final CommandLineParser parser=new DefaultParser();

		final CommandLine cmd=parser.parse(options, args);

		if(cmd.hasOption('o')){
			final String o=cmd.getOptionValue('o');
			System.out.println(o);
		}
		if(cmd.hasOption('i')){
			System.out.println(cmd.getOptionValue('i'));
		}
		if(cmd.hasOption('c')){
			System.out.println(cmd.getOptionValue('c'));
		}
		System.out.println(cmd.getOptionValue('r'));
	}
}
