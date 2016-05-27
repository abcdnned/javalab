package tom.yang.javalab.core.bytebuffer;

import java.nio.ByteBuffer;

public class Testt {
    public static void main(String[] args) {
        byte[] bytes = new byte[] { 49, 50, 51, 52 };
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        System.out.println(buffer.getInt());
    }
}
