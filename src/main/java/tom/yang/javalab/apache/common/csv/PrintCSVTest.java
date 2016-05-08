package tom.yang.javalab.apache.common.csv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class PrintCSVTest {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		CSVPrinter printer = new CSVPrinter(sb, CSVFormat.EXCEL);
		List<String> ss = new ArrayList<String>();
		ss.add("a");
		ss.add("b");
		ss.add("c");
		ss.add("d");
		printer.printRecord(ss);
		printer.print("fff");
		printer.print("fff");
		printer.print("fff");
		printer.println();
		printer.print("vvv");
		printer.print("vvv");
		printer.print("vvv");
		printer.print("vvv");
		System.out.println(sb.toString());
	}
}
