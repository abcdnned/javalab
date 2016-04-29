package tom.yang.javalab.core.hexToBytes;

import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

import tom.yang.tlog.Tlog;

public class MultiWaysTransformBetweenBytesAndHex {

    public static void main(String[] args) {
        /**
         * Reasons why it is an improvement:
         *
         * Safe with leading zeros (unlike BigInteger) and with negative byte values (unlike
         * Byte.parseByte)
         * Doesn't convert the String into a char[], or create StringBuilder and String objects for
         * every single byte.
         */
        Tlog.printSection("way1");

        byte[] bs = hexStringToByteArray("aced");
        printresult(bs);

        Tlog.printSection("way2");

        System.out.println(toHexString(bs));
        bs = toByteArray("aced");
        printresult(bs);

        Tlog.printSection("way3");
        bs = hexToBytes("aced");
        printresult(bs);
    }

    private static void printresult(byte[] bs) {
        System.out.println(bs[0]);
        System.out.println(bs[1]);
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    public static String toHexString(byte[] array) {
        return DatatypeConverter.printHexBinary(array);
    }

    public static byte[] toByteArray(String s) {
        return DatatypeConverter.parseHexBinary(s);
    }

    public static byte[] hexToBytes(String hexString) {
        HexBinaryAdapter adapter = new HexBinaryAdapter();
        byte[] bytes = adapter.unmarshal(hexString);
        return bytes;
    }

}
