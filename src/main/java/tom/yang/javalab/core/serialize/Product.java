package tom.yang.javalab.core.serialize;

import java.io.Serializable;

public class Product implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = -3182825213613265267L;
    private int price;

    public int getPrice() {
        return price;
    }

    public Product() {
    }

    public Product(int i) {
        price = i;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
