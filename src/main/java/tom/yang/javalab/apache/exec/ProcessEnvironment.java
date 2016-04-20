package tom.yang.javalab.apache.exec;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.exec.environment.DefaultProcessingEnvironment;

public class ProcessEnvironment {
    public static void main(String[] args) throws IOException {
        DefaultProcessingEnvironment env = new DefaultProcessingEnvironment();
        Map<String, String> envs = env.getProcEnvironment();
        System.out.println(envs.get("NICNAdsdsdME"));
        envs.forEach((k, v) -> System.out.println(k + " = " + v));
    }
}
