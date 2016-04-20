package tom.yang.javalab.apache.exec;

import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.LogOutputStream;
import org.apache.commons.exec.PumpStreamHandler;

public class LogStream extends LogOutputStream {
    public static void main(String[] args) throws ExecuteException, IOException {
        String s = "pifdsnf 172.14.45.23";
        CommandLine cmd = CommandLine.parse(s);

        DefaultExecutor e = new DefaultExecutor();
        e.setStreamHandler(new PumpStreamHandler(new LogStream()));
        e.execute(cmd, new DefaultExecuteResultHandler());

    }

    @Override
    protected void processLine(String line, int level) {
        System.out.println("dolog (" + level + ") : " + line);
    }
}
