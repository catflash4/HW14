package org.skypro.skyshop.product;

import org.skypro.skyshop.exceptions.IllegalDiscountException;
import org.skypro.skyshop.exceptions.IllegalPriceAndDiscountException;
import org.skypro.skyshop.exceptions.IllegalPriceException;
import org.skypro.skyshop.searchable.Searchable;



public class DiscountedProduct extends Product {
    private final int price;
    private final int discount;

    public DiscountedProduct(String name, int price, int discount) {
        super(name);
        try {
            checkValues(price, discount);
        } catch (IllegalPriceAndDiscountException e) {
            System.out.println("Указана не корректная цена и скидка");
            price = 1;
            discount = 0;
        } catch (IllegalArgumentException e) {
            System.out.println("Указана не корректная цена");
            price = 1;
        } catch (RuntimeException e) {
            System.out.println("Указана некоректная скидка");
            discount = 0;
        } finally {
            this.price = price;
            this.discount = discount;
        }
    }

    private void checkValues(int price, int discount) {
        if (price <= 0 && (discount < 0 || discount > 100)) {
            throw new IllegalPriceAndDiscountException();
        } else if (price <= 0) {
            throw new IllegalPriceException();
        } else if (discount < 0 || discount > 100) {
            throw new IllegalDiscountException();
        }
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


    @Override
    public int compareTo(Searchable o) {
        return this.searchTerm().compareTo(o.searchTerm());
    }
}

