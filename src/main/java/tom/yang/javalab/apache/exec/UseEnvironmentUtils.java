package tom.yang.javalab.apache.exec;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.exec.environment.EnvironmentUtils;

public class UseEnvironmentUtils {
    public static void main(String[] args) throws IOException {
        Map<String, String> env = EnvironmentUtils.getProcEnvironment();
        env.forEach((k, v) -> System.out.println(k + "=" + v));
    }
}
