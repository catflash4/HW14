package org.skypro.skyshop.product;

import org.skypro.skyshop.searchable.Searchable;

public class FixPriceProduct extends Product {
    public static final int FIX_PRICE = 220;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public int getPrice() {
        return FIX_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public String toString() {
        return super.toString() + " Фиксированная цена: " + FIX_PRICE +
                " руб.";
    }

    @Override
    public int compareTo(Searchable o) {
        return this.searchTerm().compareTo(o.searchTerm());
    }
}
