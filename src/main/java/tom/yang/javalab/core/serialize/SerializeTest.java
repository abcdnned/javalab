package tom.yang.javalab.core.serialize;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

import tom.yang.tlog.Tlog;

public class SerializeTest {

    public static void main(String[] args) throws IOException {
        Tlog.printSection("one level h");

        ByteArrayOutputStream byteoutput = new ByteArrayOutputStream();
        ObjectOutputStream output = new ObjectOutputStream(byteoutput);

        Clientone one = new Clientone();
        one.setAge(23);
        one.setName("client one");

        Product pro = new Product();
        pro.setPrice(280);

        output.writeObject(one);
        output.writeObject(pro);

        String hexBinary = DatatypeConverter.printHexBinary(byteoutput.toByteArray());

        System.out.println(hexBinary);

        Tlog.printSection("hashmap test");

        Map<String, String> map = new HashMap<String, String>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        byteoutput.reset();
        output.writeObject(map);

        System.out.println(DatatypeConverter.printHexBinary(byteoutput.toByteArray()));

        Tlog.printSection("inherit test");

        Child c = new Child();

        byteoutput.reset();
        output.writeObject(c);

        System.out.println(DatatypeConverter.printHexBinary(byteoutput.toByteArray()));

        Tlog.printSection("primativ type array test");

        byteoutput.reset();
        output.writeObject(new int[] { 1, 2, 3 });

        System.out.println(DatatypeConverter.printHexBinary(byteoutput.toByteArray()));

        Tlog.printSection("object array test");

        byteoutput.reset();
        ObjectOutputStream o2 = new ObjectOutputStream(byteoutput);

        Product[] pros = new Product[4];
        pros[0] = new Product(0);
        pros[1] = new Product(1);
        pros[2] = new Product(2);
        pros[3] = new Product(3);
        o2.writeObject(pros);

        System.out.println(DatatypeConverter.printHexBinary(byteoutput.toByteArray()));

        Tlog.printSection("enum test");
        byteoutput.reset();
        ObjectOutputStream o3 = new ObjectOutputStream(byteoutput);

        o3.writeObject(Enum.one);
        o3.writeObject(Enum.two);

        System.out.println(DatatypeConverter.printHexBinary(byteoutput.toByteArray()));
    }
}
