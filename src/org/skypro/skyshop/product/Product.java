package org.skypro.skyshop.product;

import java.util.Objects;

public class Product {
    private final String name;
    private final int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "\n" + name + " : " + price +
                " руб.";
    }

    public boolean equals(String o) {
        if (o == null) return false;
        Product product = new Product(o, 0);
        return Objects.equals(name, product.name);
    }
}

