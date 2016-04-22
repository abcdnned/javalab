package tom.yang.javalab.apache.exec;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.PumpStreamHandler;
import org.apache.commons.exec.ShutdownHookProcessDestroyer;
import org.apache.commons.io.FileUtils;

public class ShutdownHook {

    public static void main(String[] args) throws ExecuteException, IOException {
        String line = "ping 172.13.45.23";
        CommandLine cmdLine = CommandLine.parse(line);
        DefaultExecutor executor = new DefaultExecutor();
        DefaultExecuteResultHandler handler = new DefaultExecuteResultHandler();

        FileOutputStream out = FileUtils.openOutputStream(new File("D:/test/pinglog.txt"));
        executor.setStreamHandler(new PumpStreamHandler(out));

        // haven't found difference.
        executor.setProcessDestroyer(new ShutdownHookProcessDestroyer());

        executor.execute(cmdLine, handler);

        System.out.println("main end.");
        Runtime.getRuntime().exit(0);
        System.out.println("main end.");
    }

}
