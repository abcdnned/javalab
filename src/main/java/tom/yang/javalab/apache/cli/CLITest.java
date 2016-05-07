package tom.yang.javalab.apache.cli;

import org.apache.commons.cli.ParseException;

public class CLITest {
	public static void main(final String[] args) throws ParseException {
		CommandLineInterface.main(new String[]{"-o output","-i input","-c configfile","-r requirearg"});
	}
}
