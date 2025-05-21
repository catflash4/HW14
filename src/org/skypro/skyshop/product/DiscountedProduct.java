package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int price;
    private final int discount;

    public DiscountedProduct(String name, int price, int discount) {
        super(name);
        this.price = price;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return super.toString() + price +
                "руб. Скидка: (" + discount + "%)";
    }

    @Override
    public int getPrice() {
        return price * (100 - discount) / 100;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}

