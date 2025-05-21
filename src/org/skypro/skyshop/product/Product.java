package org.skypro.skyshop.product;

import java.util.Objects;

public abstract class Product {
    String name;

    Product(String name) {
        this.name = name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String toString() {
        return "\n" + name + " ";
    }

    public boolean equals(String o) {
        if (o == null) return false;
        return Objects.equals(name, o);
    }
}

