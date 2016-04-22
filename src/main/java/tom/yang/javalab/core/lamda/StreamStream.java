package tom.yang.javalab.core.lamda;

import java.util.ArrayList;
import java.util.List;

import tom.yang.tlog.Tlog;

public class StreamStream {
    public static void main(String[] args) {
        Tlog.printSection("foreach");
        List<String> l = new ArrayList<String>();
        l.add("1");
        l.add("2");
        l.add("3");
        l.stream().forEach(item -> System.out.println(item));
        l.forEach(item -> System.out.println(item));
    }
}
