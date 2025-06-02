package org.skypro.skyshop.product;

import org.skypro.skyshop.exceptions.IllegalPriceException;

public class SimpleProduct extends Product {
    private final int price;

    public SimpleProduct(String name, int price) {
        super(name);
        try {
            checkValue(price);
        } catch (IllegalPriceException e) {
            System.out.println("Указана не корректная цена");
            price = 1;
        } finally {
            this.price = price;
        }
    }


        private void checkValue ( int value){
            if (value <= 0)
                throw new IllegalPriceException();
        }


    @Override
    public String toString() {
        return super.toString() + price +
                " руб.";
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}
