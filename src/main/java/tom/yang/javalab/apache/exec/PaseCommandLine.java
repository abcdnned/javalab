package tom.yang.javalab.apache.exec;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.PumpStreamHandler;

public class PaseCommandLine {
    public static void main(String[] args) throws ExecuteException, IOException {
        // synexec();
        asynexec();
    }

    private static void asynexec() throws ExecuteException, IOException {
        String line = "ping 127.0.0.1";
        CommandLine cmdLine = CommandLine.parse(line);
        DefaultExecutor executor = new DefaultExecutor();
        DefaultExecuteResultHandler handler = new DefaultExecuteResultHandler();

        // if not set default is system.out and system.err
        executor.setStreamHandler(
                new PumpStreamHandler(new ByteArrayOutputStream(), new ByteArrayOutputStream()));

        executor.execute(cmdLine, handler);

        // looks no differences.
        handler.onProcessComplete(48);
    }

    private static void synexec() throws ExecuteException, IOException {
        String line = "ping 127.0.0.1";
        CommandLine cmdLine = CommandLine.parse(line);
        DefaultExecutor executor = new DefaultExecutor();
        int exitValue = executor.execute(cmdLine);
    }
}
