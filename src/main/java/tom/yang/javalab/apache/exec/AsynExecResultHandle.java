package tom.yang.javalab.apache.exec;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.ExecuteResultHandler;
import org.apache.commons.exec.ProcessDestroyer;
import org.apache.commons.exec.PumpStreamHandler;

public class AsynExecResultHandle implements ExecuteResultHandler {
    public static void main(String[] args) throws ExecuteException, IOException {
        String s = "pint 127.0.0.1";
        String right = "ping 127.0.0.1";
        CommandLine cmd = CommandLine.parse(s);
        CommandLine rightcmd = CommandLine.parse(right);
        DefaultExecutor executor = new DefaultExecutor();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        AsynExecResultHandle handler = new AsynExecResultHandle();
        handler.setOut(out);

        executor.setStreamHandler(new PumpStreamHandler(out));
        executor.execute(cmd, handler);
        executor.execute(rightcmd, handler);

        ProcessDestroyer destroyer = executor.getProcessDestroyer();

        System.out.println("main end.");
    }

    @Override
    public void onProcessComplete(int exitValue) {
        System.out.println("process completed with exitvalue : " + exitValue);
        System.out.println(out.toString());
    }

    @Override
    public void onProcessFailed(ExecuteException e) {
        System.out.println("failed");
    }

    private ByteArrayOutputStream out;

    public ByteArrayOutputStream getOut() {
        return out;
    }

    public void setOut(ByteArrayOutputStream out) {
        this.out = out;
    }
}
